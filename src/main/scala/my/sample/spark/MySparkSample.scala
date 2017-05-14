package my.sample.spark

import org.apache.spark.sql.{DataFrame, SparkSession}

import scala.util.Random

/**
  * Created by ltian on 5/15/2017.
  */
object MySparkSample {

  // kind of a solution but not a simple one
  def UDF_convert_1(df: DataFrame): Unit = {
    import org.apache.spark.sql.functions._

//    scala> df.printSchema
//    root
//    |-- Year: string (nullable = true)
//    |-- Month: string (nullable = true)
//    |-- DayofMonth: string (nullable = true)
//    |-- DayOfWeek: string (nullable = true)
//    |-- DepDelay: string (nullable = true)
//    |-- Distance: string (nullable = true)
//    |-- CRSDepTime: string (nullable = true)

    // define of udf code,
    val toInt    = udf[Int, String]( _.toInt)
    val toDouble = udf[Double, String]( _.toDouble)
    val toHour   = udf((t: String) => "%04d".format(t.toInt).take(2).toInt )
    val days_since_nearest_holidays = udf(
      (year:String, month:String, dayOfMonth:String) => year.toInt + 27 + month.toInt-12
    )

    val featureDf = df
      .withColumn("departureDelay", toDouble(df("DepDelay")))
      .withColumn("departureHour",  toHour(df("CRSDepTime")))
      .withColumn("dayOfWeek",      toInt(df("DayOfWeek")))
      .withColumn("dayOfMonth",     toInt(df("DayofMonth")))
      .withColumn("month",          toInt(df("Month")))
      .withColumn("distance",       toDouble(df("Distance")))
      .withColumn("nearestHoliday", days_since_nearest_holidays(
        df("Year"), df("Month"), df("DayofMonth"))
      )
      .select("departureDelay", "departureHour", "dayOfWeek", "dayOfMonth",
        "month", "distance", "nearestHoliday")


  }

  // simple one, details from : http://spark.apache.org/docs/1.6.0/api/scala/#org.apache.spark.sql.DataFrame
  def convert_2(df: DataFrame) : Unit = {
    import org.apache.spark.sql.types.IntegerType
    val df2 = df.withColumn("yearTmp", df("year").cast(IntegerType))
      .drop("year")
      .withColumnRenamed("yearTmp", "year")

    // sql convert
    val df3 = df.selectExpr("cast(year as int) year",
      "make",
      "model",
      "comment",
      "blank")
  }

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.appName("MyLocalSample")
                .master("local[2]")
                .getOrCreate()

    val sc = spark.sparkContext
    val ran = Random
    val firstRdd = sc.parallelize( 0 until 1000, 2).map(_=>(ran.nextInt(100), ran.nextInt(1000) + 200))
    val secondRdd = firstRdd.reduceByKey(_+_).sortByKey(ascending = true)
    secondRdd.collect.foreach(println)
  }
}
