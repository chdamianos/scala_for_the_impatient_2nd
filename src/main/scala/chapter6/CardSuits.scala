package chapter6

object CardSuits extends Enumeration {
  type CardSuit = Value
  val clubs: CardSuits.Value = Value("\u2663")
  val diamonds: CardSuits.Value = Value("\u2666")
  val hearts: CardSuits.Value = Value("\u2764")
  val spades: CardSuits.Value = Value("\u2660")

  def isRead(card: CardSuit): Boolean = card == hearts || card == diamonds

}
