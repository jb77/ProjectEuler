package problems

object Problem23 extends App {
  
    /*
        A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
        For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
        
        A number n is called deficient if the sum of its proper divisors is less than n and
        it is called abundant if this sum exceeds n.
        
        As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16,
        the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis,
        it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers.
        However, this upper limit cannot be reduced any further by analysis
        even though it is known that the greatest number that cannot be expressed
        as the sum of two abundant numbers is less than this limit.
        
        Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
    */
    
    def getDivisors(i:Int): List[Int] = 1.to(i/2).filter(n => (i%n==0)).toList                                                
    def isAbundant(n:Int):Boolean = getDivisors(n).sum > n
         
    // ~2s - definitely better ways to find sum of divisors...
    val abundantNumbers=(1.to(28123).par.filter(n => isAbundant(n))).seq   
    
    // ~10s Try as a bog standard nested loop? Seems to be faster much
    //val allPairSums=(for(i<-abundantNumbers;j<-abundantNumbers;if(i+j<28124)) yield i+j).toSet
    
    val arr=new Array[Boolean](28124)    
    for(i<-abundantNumbers){
          for(j<-abundantNumbers){
              if(i+j<28124) arr.update(i+j,true)
          }     
    }

    val unmakeableNumbers=1.to(28123).filterNot(n=>arr(n)==true) // array of booleans rather than list of ints - O(1) rather than O(n) for each filterNot?
    println(unmakeableNumbers.sum)

}