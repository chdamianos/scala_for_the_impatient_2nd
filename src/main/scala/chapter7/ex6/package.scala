package chapter7


package object ex6 {
  import java.util
  import scala.collection.immutable.{HashMap => ScalaHashMap}
  def copyHash[T](someMap: ScalaHashMap[T, T]): util.Map[T, T] = {
    import scala.jdk.CollectionConverters._

    someMap.asJava
  }
}
