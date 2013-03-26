package problems

import scala.annotation.tailrec

class Problem3 {

  /*
   * The prime factors of 13195 are 5, 7, 13 and 29. 
   * What is the largest prime factor of the number 600851475143 ?
   */

  // This version was too slow for the big input
  @tailrec private final def slowPrimes(maxNum: Int, p: Int, acc: List[Int]): List[Int] = {
    if (p > maxNum) {
      acc
    } else {
      val newP = p + 1
      val filteredAcc = acc.filter(x => (x % p != 0) || (x == p))
      slowPrimes(maxNum, newP, filteredAcc)
    }
  }

  val primes = 2 #:: sieve(3)

  def sieve(n: Int): Stream[Int] =
    if (primes.takeWhile(p => p * p <= n).exists(n % _ == 0)) sieve(n + 2)
    else n #:: sieve(n + 2)

  val number: Long = 600851475143L 
  val maximum = Math.sqrt(number).round.toInt //> maximum  : Int = 775146

  val candidatePrimes = primes.filter(x => x < maximum)

  val primeFactors = scala.collection.mutable.Set[Long]()
  var currentNumber = number

  try {
    for (p <- candidatePrimes) {
      if ((p * p) > currentNumber) throw new Exception("Break")
      while (currentNumber % p == 0) {
        println("p:" + p)
        println("currentNumber:" + currentNumber)

        primeFactors.add(p)
        currentNumber = currentNumber / p
      }
    }
  } catch {
    case _:Throwable => {
      if (currentNumber > 1) primeFactors.add(currentNumber)
      println(primeFactors.max)
    }
  }

}

object Problem3 extends App {
  new Problem3

}
