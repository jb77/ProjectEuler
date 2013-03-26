package problems

object worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(811); 

  /*If the numbers 1 to 5 are written out in words: one, two, three, four, five,
then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

NOTE: Do not count spaces or hyphens.
For example, 342 (three hundred and forty-two) contains 23 letters
and 115 (one hundred and fifteen) contains 20 letters.
The use of "and" when writing out numbers is in compliance with British usage.*/

  def getUnits(n: Int) = n.toString.last.asDigit match {
    case 1 => "one"
    case 2 => "two"
    case 3 => "three"
    case 4 => "four"
    case 5 => "five"
    case 6 => "six"
    case 7 => "seven"
    case 8 => "eight"
    case 9 => "nine"
    case _ => ""
  };System.out.println("""getUnits: (n: Int)String""");$skip(321); 

  def getTens(n: Int) = n.toString.takeRight(2).head.asDigit match {
    case 1 => "teen " // throw except?
    case 2 => "twenty "
    case 3 => "thirty "
    case 4 => "forty "
    case 5 => "fifty "
    case 6 => "sixty "
    case 7 => "seventy "
    case 8 => "eighty "
    case 9 => "ninety "
    case _ => ""
  };System.out.println("""getTens: (n: Int)String""");$skip(346); 

  def getTeens(n: Int) = n.toString.takeRight(2).toInt match {
    case 10 => "ten "
    case 11 => "eleven "
    case 12 => "twelve "
    case 13 => "thirteen "
    case 14 => "fourteen "
    case 15 => "fifteen "
    case 16 => "sixteen "
    case 17 => "seventeen "
    case 18 => "eighteen "
    case 19 => "nineteen "
    case _ => ""
  };System.out.println("""getTeens: (n: Int)String""");$skip(336); 

  def getHundreds(n: Int) = {
    val t = n.toString.head.asDigit match {
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case 4 => "four"
      case 5 => "five"
      case 6 => "six"
      case 7 => "seven"
      case 8 => "eight"
      case 9 => "nine"
      case _ => ""
    }
    t + " hundred and "
  };System.out.println("""getHundreds: (n: Int)String""");$skip(679); 

  def numb2Text(n: Int): String = {
    if (n < 1) throw new IllegalArgumentException("n less than 1")
    if (n > 1000) throw new IllegalArgumentException("n greater than 1000")
    if (n == 1000) return "one thousand"

    val inTheTeens = (n > 9 && n.toString.takeRight(2).toInt < 20 && n.toString.takeRight(2).toInt > 9)
    if (inTheTeens) {
      val teens = getTeens(n)
      val h = if (n > 99) getHundreds(n) else ""
      h + teens
    } else {
      val u = getUnits(n)
      val t = if (n > 9) getTens(n) else ""
      val h = if (n > 99) getHundreds(n) else ""
      if (n % 100 == 0) {
        h.dropRight(4)
      } else {
        h + t + u
      }
    }

  };System.out.println("""numb2Text: (n: Int)String""");$skip(71); 

  println(1.to(1000).map(numb2Text(_).replaceAll(" ", "").size).sum)}


}
