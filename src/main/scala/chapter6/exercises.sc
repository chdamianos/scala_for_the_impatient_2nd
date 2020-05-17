/*1*/

import chapter6.CardSuits
import chapter6.Conversions.{gallonsToLiters => gl2Lt, inchesToCentimeters => inc2cm, milesToKilometers => ml2Km}

println(inc2cm(inches = 1))
println(gl2Lt(gallons = 2))
println(ml2Km(miles = 2))
/*2*/

import chapter6.{inchesToCentimeters, gallonsToLiters, milesToKilometers}

println(inchesToCentimeters.convertUnit(1))
println(gallonsToLiters.convertUnit(1))
println(milesToKilometers.convertUnit(1))

// a better solution
class UnitConversion(val factor: Double) {
  def convert(value: Double): Double = factor * value
}

object InchesToCentimeters extends UnitConversion(2.54)
object GallonsToLiters extends UnitConversion(3.78541178)
object MilesToKilometers extends UnitConversion(1.609344)
/*3*/

import chapter6.Point

println(Point.x, Point.y)
/*4*/

import chapter6.PointClass

val point1 = PointClass(10.0, 20.0)
println(point1)
/*5*/
// scala Reverse.scala Hello World
// >>> World Hello
/*6*/
import chapter6.CardSuits._

println(clubs)
println(diamonds)
/*7*/
val card1 = hearts
println(CardSuits.isRead(card1))
val card2 = diamonds
println(CardSuits.isRead(card2))
val card3 = spades
println(CardSuits.isRead(card3))