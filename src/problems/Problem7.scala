package problems

object Problem7 extends App {
  
    def sieve(n: Int): Stream[Int] =
    if (primes.takeWhile(p => p * p <= n).exists(n % _ == 0)) sieve(n + 2)
    else n #:: sieve(n + 2)
    
    
    val primes = 2 #:: sieve(3)
   println(primes.take(10001).last)


}