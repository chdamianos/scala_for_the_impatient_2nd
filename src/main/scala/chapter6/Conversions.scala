package chapter6

object Conversions extends App {
  def inchesToCentimeters(inches: Double): Double = {
    inches * 2.54
  }

  def gallonsToLiters(gallons: Double): Double = {
    gallons * 3.79
  }

  def milesToKilometers(miles: Double): Double = {
    miles * 1.61
  }
}

object inchesToCentimeters extends UnitConversion {
  override val factor: Double = 2.54
}

object gallonsToLiters extends UnitConversion {
  override val factor: Double = 3.79
}

object milesToKilometers extends UnitConversion {
  override val factor: Double = 1.61

}