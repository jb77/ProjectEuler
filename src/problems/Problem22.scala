package problems

object Problem22 extends App {

  def p22Func = {
    val names = io.Source.fromFile("C:\\Users\\bunchj\\Documents\\GitHub\\ProjectEuler\\data\\names.txt").
      mkString.replaceAll("\"", "").split(",")

    val sortedNamesWithIndex = names.sorted.zipWithIndex.map(tuple => (tuple._1, tuple._2 + 1))

    def alphabeticalValue(name: String): Int = name.map(_.toInt - 64).sum
    
    println(sortedNamesWithIndex.map(tuple => alphabeticalValue(tuple._1) * tuple._2).sum)
  }

  def time(func: => Unit) = { // note use of call by name param
    val start = System.currentTimeMillis() // could use System.nanoTime() for greater precision
    func
    val end = System.currentTimeMillis()
    println("Time Taken: " + (end - start) + "ms")
  }
  
  time( p22Func )

}