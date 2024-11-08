import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object DataFrame003LeadLag {

  def main(args:Array[String]):Unit= {

    val spark = SparkSession.builder()
      .appName("scala-spark-program")
      .master("local")
      .getOrCreate()

    import spark.implicits._

    val customer = List (
      (101,"CustomerA","2023-09-01"),
      (103,"CustomerA","2023-09-03"),
      (102,"CustomerB","2023-09-02"),
      (104,"CustomerB","2023-09-04")
    ).toDF("order_id","customer_name","order_date")

    val window=Window.partitionBy(col("customer_name")).orderBy(col("order_date"))

    val df2 = customer.withColumn("lead_date",lead(col("order_date"),1).over(window))

    df2.show()

  }

}
