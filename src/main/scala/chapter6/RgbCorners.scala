package chapter6

object RgbCorners extends Enumeration {
  type RgbCorner = Value
  val Red: RgbCorners.Value = Value(0xff0000, "Red")
  val Green: RgbCorners.Value = Value(0x00ff00, "Green")
  val Blue: RgbCorners.Value = Value(0x0000ff, "Blue")
  val Cyan: RgbCorners.Value = Value(0x00ffff, "Cyan")
  val Magenta: RgbCorners.Value = Value(0xf00ff, "Magenta")
  val Yellow: RgbCorners.Value = Value(0xffff00, "Yellow")
  val Black: RgbCorners.Value = Value(0x000000, "Black")
  val White: RgbCorners.Value = Value(0xffffff, "White")

}
