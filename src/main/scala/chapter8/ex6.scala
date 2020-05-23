package chapter8

object ex6 extends App {
  val rec1 = new Rectangle(1, 5, (10, 10))
  println(rec1.centerPoint)
  val circ1 = new Circle(10, (0, 0))
  println(circ1.centerPoint)
}

abstract class Shape {
  def centerPoint: (Double, Double) = ???
}

class Rectangle(val height: Double, val width: Double, val upperLeftPoint: (Double, Double)) extends Shape {
  override def centerPoint: (Double, Double) = (upperLeftPoint._1 + width / 2, upperLeftPoint._2 + height / 2)
}

class Circle(val radius: Double, val center: (Double, Double)) extends Shape {
  override def centerPoint: (Double, Double) = center
}