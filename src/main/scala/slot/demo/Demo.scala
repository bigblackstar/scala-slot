package slot.demo

import slot._

object Demo extends Slot with PayoutCombos {
  val symbolsPerReel: Int = 3
  val lineCount: Int = 25

  val payoutCombos: List[PayoutCombo] = List(
    PayoutCombo(1, 0, 5, 10000), PayoutCombo(2, 0, 4, 1000), PayoutCombo(3, 0, 3, 100), PayoutCombo(4, 0, 2, 10),
    PayoutCombo(5, 1, 5, 1000), PayoutCombo(6, 1, 4, 250), PayoutCombo(7, 1, 3, 50), PayoutCombo(8, 1, 2, 2),
    PayoutCombo(9, 2, 5, 500), PayoutCombo(10, 2, 4, 150), PayoutCombo(11, 2, 3, 25), PayoutCombo(12, 2, 2, 2),
    PayoutCombo(13, 3, 5, 500), PayoutCombo(14, 3, 4, 150), PayoutCombo(15, 3, 3, 25), PayoutCombo(16, 3, 2, 2),
    PayoutCombo(17, 4, 5, 300), PayoutCombo(18, 4, 4, 75), PayoutCombo(19, 4, 3, 20), PayoutCombo(20, 5, 5, 300),
    PayoutCombo(21, 5, 4, 75), PayoutCombo(22, 5, 3, 20), PayoutCombo(23, 6, 5, 150), PayoutCombo(24, 6, 4, 50),
    PayoutCombo(25, 6, 3, 10), PayoutCombo(26, 7, 5, 100), PayoutCombo(27, 7, 4, 50), PayoutCombo(28, 7, 3, 5),
    PayoutCombo(29, 8, 5, 100), PayoutCombo(30, 8, 4, 40), PayoutCombo(31, 8, 3, 5), PayoutCombo(32, 9, 5, 100),
    PayoutCombo(33, 9, 4, 40), PayoutCombo(34, 9, 3, 5)
  )

  val reels: List[Reel] = List(
    List(9, 9, 4, 8, 4, 8, 7, 8, 9, 8, 4, 4, 8, 3, 3, 8, 7, 5, 6, 9, 5, 8, 7, 6, 6, 6, 2, 9, 9, 9, 1, 5, 9, 7, 3, 5, 9, 8, 5, 7, 7, 7, 6, 2, 6),
    List(5, 7, 9, 3, 4, 7, 9, 5, 1, 2, 5, 4, 7, 7, 5, 9, 8, 8, 9, 8, 3, 9, 6, 6, 3, 9, 8, 8, 9, 8, 6, 4, 8, 6, 2, 6, 9, 9, 7, 5, 7, 8, 4, 6, 7),
    List(5, 9, 6, 6, 3, 7, 7, 6, 4, 5, 4, 2, 3, 7, 7, 6, 8, 8, 9, 9, 6, 8, 8, 8, 5, 8, 7, 8, 9, 2, 4, 9, 9, 1, 4, 5, 3, 5, 9, 8, 7, 9, 9, 6, 7),
    List(7, 6, 8, 6, 5, 2, 2, 9, 5, 9, 9, 9, 8, 4, 9, 4, 6, 3, 5, 8, 3, 6, 3, 1, 7, 9, 9, 9, 7, 8, 8, 8, 6, 6, 7, 7, 4, 7, 8, 8, 5, 4, 7, 5, 9),
    List(6, 7, 6, 3, 2, 9, 8, 4, 9, 9, 9, 8, 9, 9, 1, 9, 4, 6, 3, 4, 7, 8, 5, 7, 7, 8, 8, 4, 8, 6, 6, 2, 7, 8, 5, 5, 9, 7, 3, 5, 6, 9, 5, 8, 7)
  )

  override def isWild(symbol: Int): Boolean = symbol == 0

  def main(args: Array[String]) {
    val spinResult: SpinResult = Demo.spin()
    val lineSymbols: List[List[Int]] = lines(spinResult)
    val payoutCombos: List[Option[PayoutCombo]] = lineSymbols.map(payoutCombo)
    val totalWin: Int = payoutCombos.flatten.map(_.multiplier).sum

    println(spinResult)
    (lineSymbols zip payoutCombos).foreach(println)
    println("Win: " + totalWin)
  }
}
