object list {
  def main(args:Array[String]):Unit= {

    var mylist=List(2,4,6,8,10)
    println(mylist(0))
    println(mylist(4))

    println("Printing using foreach loop:")
    mylist.foreach(println)

    println("Printing using for loop:")
    for(i <- mylist.indices)
      {
        println(mylist(i))
      }
  }
}
