package problems

import scala.annotation.tailrec

class Problem10 {
  
    val primes = 2 #:: sieve(3)

  def sieve(n: Long): Stream[Long] =
    if (primes.takeWhile(p => p * p <= n).exists(n % _ == 0)) sieve(n + 2)
    else n #:: sieve(n + 2)
    

    println(primes.takeWhile(_<2000000).toList.sum)
  
}

object Problem10 extends App {
  
  new Problem10


}