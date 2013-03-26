package problems

object worksheet {

	def combinatorics(n:Int) = {
		var total:Long=1;
		for(x<-0.to(n-1)) { // binomial coefficient??
			total=total * ((2*n)-x)
			total = total / (x + 1)
		}
		println("final total: " +total)
	}                                         //> combinatorics: (n: Int)Unit
	
	combinatorics(1)                          //> final total: 2
	combinatorics(2)                          //> final total: 6
  combinatorics(3)                                //> final total: 20
  combinatorics(4)                                //> final total: 70
	combinatorics(20)                         //> final total: 137846528820
	
	
	//functional version
	def funcCombinatorics(n:Int) = {
		val top=0.to(n-1).map(x=>( BigDecimal(2)*BigDecimal(n))-BigDecimal(x)  ).product
		val bottom=1.to(n).map(x => BigDecimal(x)).product
		top/bottom
	}                                         //> funcCombinatorics: (n: Int)scala.math.BigDecimal
	
	funcCombinatorics(3)                      //> res0: scala.math.BigDecimal = 20
	funcCombinatorics(20)                     //> res1: scala.math.BigDecimal = 137846528820
}