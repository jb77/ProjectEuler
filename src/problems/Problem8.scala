package problems

object Problem8 extends App {
  
 	for(a<-1 to 1000;b<-1 to 1000;c<-1 to 1000)
 	{
 		val sumCorrect=a+b+c==1000
 		val isPythagoreanTriple=(a*a) + (b*b) == c*c
 		
 		if(sumCorrect && isPythagoreanTriple) println(a *b *c)
 	}


}