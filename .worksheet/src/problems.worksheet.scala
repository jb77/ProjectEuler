package problems

object worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(232); 

	def combinatorics(n:Int) = {
		var total:Long=1;
		for(x<-0.to(n-1)) { // binomial coefficient??
			total=total * ((2*n)-x)
			total = total / (x + 1)
		}
		println("final total: " +total)
	};System.out.println("""combinatorics: (n: Int)Unit""");$skip(20); 
	
	combinatorics(1);$skip(18); 
	combinatorics(2);$skip(19); 
  combinatorics(3);$skip(19); 
  combinatorics(4);$skip(19); 
	combinatorics(20);$skip(212); 
	
	
	//functional version
	def funcCombinatorics(n:Int) = {
		val top=0.to(n-1).map(x=>( BigDecimal(2)*BigDecimal(n))-BigDecimal(x)  ).product
		val bottom=1.to(n).map(x => BigDecimal(x)).product
		top/bottom
	};System.out.println("""funcCombinatorics: (n: Int)scala.math.BigDecimal""");$skip(24); val res$0 = 
	
	funcCombinatorics(3);System.out.println("""res0: scala.math.BigDecimal = """ + $show(res$0));$skip(23); val res$1 = 
	funcCombinatorics(20);System.out.println("""res1: scala.math.BigDecimal = """ + $show(res$1))}
}
