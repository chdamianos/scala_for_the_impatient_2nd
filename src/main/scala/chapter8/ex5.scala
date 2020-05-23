package chapter8

object ex5 extends App {
  val point1 = new Point(1.0, 2.0)
  println(point1)
  val labelledPoint = new LabelledPoint(label = "A", 3, 4)
  println(labelledPoint)
  println(labelledPoint.label)
}

class Point(val x: Double, val y: Double) {
  override def toString: String = f"x=$x, y=$y"
}

class LabelledPoint(val label: String, x: Double, y: Double) extends Point(x, y) {
  override def toString: String = f"Point $label has coordinates x=$x, y=$y"
}