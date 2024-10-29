import org.apache.spark.SparkContext

object FileWrite {
  def main(args:Array[String]):Unit= {

    val sc = new SparkContext("local[*]", "scalaspark")
    val arr = Array(10,20,30,40,50,60,70,80,90)
    val rdd1 = sc.parallelize(arr)
    rdd1.saveAsTextFile("C:/Users/cvnsa/Documents/SparkOutput/arraydata")

  }
}
