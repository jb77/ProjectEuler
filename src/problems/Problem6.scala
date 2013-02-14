package problems

import scala.annotation.tailrec

class Problem6 {

  /*
	The sum of the squares of the first ten natural numbers is,
	12 + 22 + ... + 102 = 385
	The square of the sum of the first ten natural numbers is,
	(1 + 2 + ... + 10)2 = 552 = 3025
	Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 385 = 2640.
	Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
  */

  // brute force way
  def sumOfSquares(max: Int): Int = 1.to(max).map(x => x * x).sum
  def squareOfSum(max: Int): Int = 1.to(max).sum * 1.to(max).sum

  // analytical solution to the series
  def qSumOfSquares(max: Long): Long = scala.math.round(((max * max * max) / 3f) + ((max * max) / 2f) + (max / 6f))
  def qSquareOfSum(max: Long): Long = (max * (max + 1)) / 2 * (max * (max + 1)) / 2

  val testRange = 1000000

  println(sumOfSquares(testRange) - squareOfSum(testRange))

}

object Problem6 extends App {
  new Problem6

}
