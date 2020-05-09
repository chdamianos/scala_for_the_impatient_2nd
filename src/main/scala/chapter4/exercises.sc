import scala.io.Source
import scala.jdk.CollectionConverters._

/*1*/
val gizmos = Map("monitor" -> 10, "mouse" -> 20)
val gizmosDisc = for ((k, v) <- gizmos) yield (k, v * 0.9)
/*2*/
val testFile = getClass.getResource("/myfile.txt").getPath
val source = Source.fromFile(testFile, "UTF-8")
val tokens = source.mkString.split("\\s+")
val mutMap = scala.collection.mutable.Map[String, Int]()
for (i <- tokens) {
  mutMap(i) = mutMap.getOrElse(i, 0) + 1
}
println(mutMap)
/*3*/
var immuWords = scala.collection.Map[String, Int]()
for (i <- tokens)
  immuWords += (i -> (immuWords.getOrElse(i, 0) + 1))
println(immuWords)

