package problems

import scala.annotation.tailrec

class Problem4 {

  /*
   * A palindromic number reads the same both ways. 
   * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 99.
   * Find the largest palindrome made from the product of two 3-digit numbers.
   */
  
  val threeDigitNumbers=100 to 999  
  val products=for(i<-threeDigitNumbers; j<-threeDigitNumbers) yield i*j                                                                                     
  println(products.filter(isPalindrome(_)).max)     
  
  def isPalindrome(candidate:Int):Boolean=candidate.toString.reverse == candidate.toString   
}

object Problem4 extends App {
  new Problem4

}
