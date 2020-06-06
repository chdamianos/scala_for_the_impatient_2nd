package chapter9

import java.io.PrintWriter

object ex5 extends App {
  val writeOut = new PrintWriter("./resources/chapter9ex5.txt")

  val range_ = (1 to 20).toArray
  for (i <- range_) {
    val powertwo = math.pow(i, 2)
    val reciprocal = 1 / powertwo
    val tempString = f"""$powertwo%5.0f    $reciprocal%5.4f"""
    writeOut.println(tempString)
  }
  writeOut.close()
}
