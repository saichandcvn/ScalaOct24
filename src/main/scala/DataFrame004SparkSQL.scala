import org.apache.spark.sql.SparkSession

object DataFrame004SparkSQL {

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

    customer.createOrReplaceTempView("customer_data")

    spark.sql(
      """
      select  order_id,
              customer_name,
              order_date,
              lead(order_date) over (partition by customer_name order by order_date) as next_date
      from    customer_data
      """
    ).show()

  }

}
