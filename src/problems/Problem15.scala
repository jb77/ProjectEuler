package problems

object Problem15 extends App {

  def combinatorics(n: Int) = {
    var total: Long = 1;
    for (x <- 0.to(n - 1)) { // binomial coefficient??
      total = total * ((2 * n) - x)
      total = total / (x + 1)
    }
    total
  }
  
  println(combinatorics(3))
  println(combinatorics(20))

  //functional version
  def funcCombinatorics(n: Int) = {
    val top = 0.to(n - 1).map(x => (BigDecimal(2) * BigDecimal(n)) - BigDecimal(x)).product
    val bottom = 1.to(n).map(x => BigDecimal(x)).product
    top / bottom
  }

  println(funcCombinatorics(3))
  println(funcCombinatorics(20))
}