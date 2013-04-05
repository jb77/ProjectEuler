package problems

object Problem19 extends App {

  /*
       You are given the following information, but you may prefer to do some research for yourself.

       1 Jan 1900 was a Monday.
       Thirty days has September,
       April, June and November.
       All the rest have thirty-one,
       Saving February alone,
       Which has twenty-eight, rain or shine.
       And on leap years, twenty-nine.
       A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
       How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
   */

  def daysInMonth(m: Int, yr: Int) = m match {
    case 1 | 3 | 5 | 7 | 8 | 10 | 12 => 31
    case 9 | 4 | 6 | 11 => 30
    case 2 if (isLeapYear(yr)) => 29
    case 2 if (!isLeapYear(yr)) => 28
    case _ => throw new IllegalArgumentException("Month must be 1 - 12")
  }

  def isLeapYear(yr: Int) = {
    val div4 = yr % 4 == 0
    val div100 = yr % 100 == 0
    val div400 = yr % 400 == 0

    div4 && (!div100 || div400)
  }

  def daysInYear(yr: Int) = 1.to(12).map(daysInMonth(_, yr)).sum

  def is1stASunday(m: Int, yr: Int): Boolean = {
    val daysInMonths = 1.to(m).map(daysInMonth(_, yr)).sum
    val daysInThisMonth = daysInMonth(m, yr)
    val daysInPriorMonths = daysInMonths - daysInThisMonth
    val daysInPriorYears = 1900.to(yr - 1).map(daysInYear(_)).sum
    val priorDays = daysInPriorYears + daysInPriorMonths
    (priorDays + 1) % 7 == 0
  }

  def numberOfSunday1sts(fromYr: Int, toYr: Int) = {
    val years = fromYr.to(toYr)
    val months = 1.to(12)
    (for (year <- years; month <- months) yield is1stASunday(month, year)).count(_ == true)
  }

  println(numberOfSunday1sts(1901, 2000))

}