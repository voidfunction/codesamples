import org.apache.spark.{SparkConf, SparkContext}

import scala.util.Random

/**
 * Created by ltian on 6/23/2017.
 */

object SparkLocalRunSample {
    def main (arg:Array[String]): Unit = {
        var userHome = System.getProperty("user.dir")
        val date = new java.util.Date
        val conf = new SparkConf().
                setAppName(date.toString)
                .setMaster("local[2]")
                .set("spark.eventLog.enabled", "true")
                .set("spark.eventLog.dir", userHome + "/logs")
                .set("spark.local.dir", userHome + "/tmp")

        val sc = new SparkContext(conf)
        val ran = Random
        var rdd1 = sc.parallelize(0 until 100, 2).flatMap { p =>
            val arr = new Array[(Int, Int)](100)
            for (i <- 0 until 100) {
                arr(i) = (ran.nextInt(20), ran.nextInt(1000) + 1000)
            }
            arr
        }

        var rdd2 = sc.parallelize(0 until 100, 2).flatMap { p =>
            val arr = new Array[(Int, Int)](100)
            for (i <- 0 until 100) {
                arr(i) = (ran.nextInt(15) + 10, ran.nextInt(1000) + 1000)
            }
            arr
        }

        var rdd3 = rdd1.reduceByKey(_+_)
        var rdd4 = rdd2.reduceByKey(_+_)
        var rdd5 = rdd3.union(rdd4)
        var rdd6 = rdd5.sortByKey()
        rdd6.foreach(println)
    }
}
