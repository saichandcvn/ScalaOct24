import org.apache.spark.sql.SparkSession

object DataFrame002 {

  def main(args:Array[String]):Unit= {

    val spark = SparkSession.builder()
      .appName("spark-program")
      .master("local")
      .getOrCreate()

    val df = spark.read.format("csv")
      .option("header", true)
      .option("inferschema", true)
      .option("path", "C:/Users/cvnsa/Documents/SparkInput/details.csv")
      .load()

    df.printSchema()

  }

}
