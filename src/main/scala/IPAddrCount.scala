import org.apache.spark.SparkContext

object IPAddrCount {
  def main(args:Array[String]):Unit= {

    val sc = new SparkContext("local[*]", "scalaspark")
    val input = sc.textFile("C:/Users/cvnsa/Documents/SparkInput/IpAddress.txt")

    val rdd1 = input.flatMap(x => x.split(" "))
    val rdd2 = rdd1.map(x => (x, 1))
    val rdd3 = rdd2.reduceByKey((x, y) => (x + y))
    val rdd4 = rdd3.sortBy(x=>x._2,false)
    rdd4.take(2).foreach(println)

  }
}
