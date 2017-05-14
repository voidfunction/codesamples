package my.sample.spark

import org.apache.spark.sql.SparkSession

import scala.util.Random

/**
  * Created by ltian on 5/15/2017.
  */
object MySparkSample {
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
