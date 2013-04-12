package problems

object Problem20 extends App {

  def compute {
    val factorial = 1.to(100).par.map(java.math.BigInteger.valueOf(_)).reduce((a, b) => a.multiply(b))
    println(factorial.toString.toList.map(_.asDigit).sum)
  }

  def time(func: => Unit) = { // note use of call by name param
    val start=System.currentTimeMillis() // could use System.nanoTime() for greater precision
    func
    val end=System.currentTimeMillis()
    println("Time Taken: " + (end-start) + "ms")
  }
  
  time(compute)
}