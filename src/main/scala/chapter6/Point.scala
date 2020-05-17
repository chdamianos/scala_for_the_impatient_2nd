package chapter6

import java.awt.Point

object Point extends Point {
  /*
  not a good idea because
  there are public methods in `java.awt.Point`
  that can change the point location
  */
  override def setLocation(v: Double, v1: Double): Unit = super.setLocation(0.0, 0.0)
}
