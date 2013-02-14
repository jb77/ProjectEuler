package problems

import scala.annotation.tailrec

class Problem5 {

  /*
   *   2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
   *     What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
   */

  def isEvenlyDivisible(candidate: Int, rng: Range): Boolean = !rng.exists(r => candidate % r != 0)

  val allInts = 1 to Int.MaxValue

  val slow=allInts.find(isEvenlyDivisible(_, 1 to 20)) //slow... 232792560
  println(slow)

  val rng2 = 1 to 20
  val productofPrimes = 2 * 3 * 5 * 7 * 11 * 13 * 17 * 19
  val someInts = Range(0, Int.MaxValue, productofPrimes)
  val fast=someInts.tail.find(x => isEvenlyDivisible(x, rng2)) //fast... 232792560
  println(fast)

}

object Problem5 extends App {
  new Problem5

}
