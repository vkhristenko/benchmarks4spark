package ch.cern.benchmarks4spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SaveMode

//
// a simple test benchmark to verify that things work as expected
//
object BTest {
  def main(args: Array[String]): Unit = {
    //
    // unpack CLI arguments
    //
    val pathToOutput = args(0)
    val n = args(1).toInt

    //
    // setup spark session
    //
    val spark = SparkSession.builder
      .appName("BTest")
      .getOrCreate

    //
    // prepare the data
    //
    val data = 1 to n

    // TODO
    import spark.implicits._

    // 
    // create a dataset
    //
    val ds = spark.createDataset(data)

    // 
    // perform an action count
    //
    ds.count

    //
    // save to disk
    //
    ds.write.mode(SaveMode.Overwrite).parquet(pathToOutput)

    // all done
    spark.stop
  }
}
