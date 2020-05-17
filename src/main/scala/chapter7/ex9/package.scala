package chapter7
package object ex9 {

  import java.lang.System._

  def passTest(): Unit = {
    val userName: String = getProperty("user.name")
    val pass = scala.io.StdIn.readLine()
    if (pass == "secret") {
      println(f"Greetings $userName")
    } else {
      System.err.println("error")
    }

  }

}
