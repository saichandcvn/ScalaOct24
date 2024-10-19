object arr_foreach {
  def main(args:Array[String]):Unit= {

    println("Printing Using ForEach Loop:")

    var arr=Array(10,20,30,40,50)
    val len=arr.length
    println("length of array: "+ len)
    arr.foreach(println)

    println("Printing Using For Loop:")

    for(i <- 0 until len)
      {
        println(arr(i))
      }
  }
}
