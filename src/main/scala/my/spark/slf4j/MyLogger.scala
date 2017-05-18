package my.spark.slf4j

import org.apache.log4j.{LogManager, PropertyConfigurator}
import org.slf4j.Logger
import org.slf4j.impl.{StaticLoggerBinder}

/**
  * Created by ltian on 5/18/2017.
  */
trait MyLogger {
  @transient private var mylog_ : Logger = null

  protected def log: Logger = {
    if(mylog_ == null) {
      MyLogger.lock.synchronized {
        initialize()
        if(mylog_ == null) {
          mylog_ = org.slf4j.LoggerFactory.getLogger(this.getClass.getName)
        }
      }
    }
    mylog_
  }

  protected def logInfo(msg: => String) {
    if (log.isInfoEnabled) log.info(msg)
  }


  protected def logWarning(msg: => String) {
    if (log.isWarnEnabled) log.warn(msg)
  }

  protected def logError(msg: => String) {
    if (log.isErrorEnabled) log.error(msg)
  }

  protected def logError(msg: => String, throwable: Throwable) {
    if (log.isErrorEnabled) log.error(msg, throwable)
  }


  private def initialize() : Unit = {
    val bindingClass = StaticLoggerBinder.getSingleton.getLoggerFactoryClassStr

    val isLog4j12 = "org.slf4j.impl.Log4jLoggerFactory".equals(bindingClass)
    if(isLog4j12) {
      val isLog4j12Initialized = LogManager.getRootLogger.getAllAppenders.hasMoreElements
      if(!isLog4j12Initialized) {
        val logFileName = "log4j-my.properties"
        val url = this.getClass.getResource(logFileName)
        if(url != null) {
          PropertyConfigurator.configure(url)
          System.out.println(s"Using customized logger file: $logFileName")
        }
      }
    }
    MyLogger.initialized = true
    log
  }
}

object MyLogger {
  @volatile private var initialized = false
  val lock = new Object()
}