import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import org.apache.log4j.{Level, LogManager, Logger}

object DataFrame005Rank {

  def main(args:Array[String]):Unit= {

    val logger: Logger = Logger.getLogger(this.getClass)

    val spark = SparkSession.builder()
      .appName("scala-spark-program")
      .master("local")
      .getOrCreate()

    import spark.implicits._

    val storeSalesData = Seq(
      ("Karthik", "Store_A", "2023-03", 1500),
      ("Vijay", "Store_B", "2023-03", 1500),
      ("Jay", "Store_C", "2023-03", 1800),
      ("Mohan", "Store_D", "2023-03", 1600),
      ("Karthik", "Store_A", "2023-04", 2000),
      ("Vijay", "Store_B", "2023-04", 1800),
      ("Jay", "Store_C", "2023-04", 2000),
      ("Mohan", "Store_D", "2023-04", 1800)
    ).toDF("manager", "store", "month", "sales")

    val window = Window.partitionBy("manager","month").orderBy(desc("sales"))

    val df1 = storeSalesData.withColumn("rank",dense_rank().over(window))

    df1.show()

  }

}
