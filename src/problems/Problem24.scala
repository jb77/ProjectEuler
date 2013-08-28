package problems

object Problem24 extends App {
  
   val l=List(0,1,3,4,5,6,7,8,9).permutations.toList.map(_.toString)
   val item=l(274239)
   
   println(item)
   
}