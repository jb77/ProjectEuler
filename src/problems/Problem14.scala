package problems

object problem14 extends App{

  /*
        The following iterative sequence is defined for the set of positive integers:
        
        n  n/2 (n is even)
        n  3n + 1 (n is odd)
        
        Using the rule above and starting with 13, we generate the following sequence:
        
        13  40  20  10  5  16  8  4  2  1
        It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
        Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
        
        Which starting number, under one million, produces the longest chain?
        
        NOTE: Once the chain starts the terms are allowed to go above one million.
    */

  def evenFunc(n: Int) = n / 2                    //> evenFunc: (n: Int)Int
  def oddFunc(n: Int) = (3 * n) + 1               //> oddFunc: (n: Int)Int

  def isEven(n: Int) = n % 2 == 0                 //> isEven: (n: Int)Boolean
  def isOdd(n: Int) = n % 2 != 0                  //> isOdd: (n: Int)Boolean
  
  val cache=scala.collection.mutable.Map[Int,Int]()
                                                  //> cache  : scala.collection.mutable.Map[Int,Int] = Map()

  def sequence(orig:Long): (Long,Long) = {
    var currentNumber = orig
    var size=1;
    
    //if(orig % 10000 == 0) println(orig)
    
    while(currentNumber!=1)
    {   
        if(currentNumber % 2 ==0) currentNumber=(currentNumber / 2)
        else currentNumber=(3 * currentNumber) +1
        size=size+1
    }
    (orig,size)
    
    
  }                                               //> sequence: (orig: Int)(Int, Int)
  
  
  sequence(13)                                    //> res0: (Int, Int) = (13,10)
  
  val tuples=1.to(999999).map(n => sequence(n))
  println(tuples.sortBy(_._2).last)
    
    
      
  /*def memoizedSequence(currentNumber: Int, orig:Int, size:Int): (Int,Int) ={
        val cacheRes=cache.get(currentNumber)
        
        cacheRes match {
            case None => {
                val calcRes=sequence(currentNumber,orig,size)._2
                cache.put( currentNumber, calcRes )
                //println("Put value for " + currentNumber)
                (orig,calcRes)
            }
            case Some(x) => (orig,x+size)
        }
  
  }      */

}