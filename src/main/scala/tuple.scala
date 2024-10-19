object tuple {
  def main(args:Array[String]):Unit= {
    var tup=(10,20,10.5,true)
    println(tup._2)
    println(tup._4)

    var c = 0
    for(i<-tup.productIterator)
    {
      println(i)
      c=c+1
    }

    println(c)
  }
}
