package problems

object Problem12 {

/*
The sequence of triangle numbers is generated by adding the natural numbers.
So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
Let us list the factors of the first seven triangle numbers:
  1: 1
  3: 1,3
  6: 1,2,3,6
 10: 1,2,5,10
 15: 1,3,5,15
 21: 1,3,7,21
 28: 1,2,4,7,14,28
 
We can see that 28 is the first triangle number to have over five divisors.
What is the value of the first triangle number to have over five hundred divisors?
*/

def nthTriangleNumber(n:Int):Int ={
    //1.to(n).sum
    // faster is:
    ( n*(n+1) ) / 2
}                                                 //> nthTriangleNumber: (n: Int)Int

nthTriangleNumber(50)                             //> res0: Int = 1275

def countDivisors( x:Int):Int= {
    var limit = x;
    var numberOfDivisors = 0;

    for (i<-1.to(limit)) {
            //println(x,i,limit)
        if (x % i == 0) {
            limit = x / i;
            if (limit != i) {
                numberOfDivisors=numberOfDivisors+1
            }
            numberOfDivisors=numberOfDivisors+1
        }
    }

    numberOfDivisors /2
}                                                 //> countDivisors: (x: Int)Int

println(countDivisors(76576500))                  //> 576

 val candidate=2^3                                //> candidate  : Int = 1


import scala.math._
val dn=pow(2, 4) * pow(3,4) * pow(5,4) * 7 * 11   //> dn  : Double = 6.237E7
val n=dn.toLong                                   //> n  : Long = 62370000
countDivisors(n.toInt)                            //> res1: Int = 500

n*2                                               //> res2: Long = 124740000

 
var trgNum=0                                      //> trgNum  : Int = 0
for(i<-11168.to(12000)) //too slow to call repeatedly (esp for big numbers)
{
    trgNum=nthTriangleNumber(i)
    //val cnt=countDivisors(trgNum)
    //println(trgNum,cnt)
    //if(cnt>300)   println(trgNum,cnt)
}
                                                   
 
                                                  

 
}