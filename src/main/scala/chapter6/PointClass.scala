package chapter6

class PointClass private(val x: Double, val y: Double) {
  override def toString: String = f"x = $x, y = $y"
}

object PointClass {
  def apply(x: Double, y: Double) =
    new PointClass(x, y)
}
