package slot

import scala.List._
import scala.util.Random

trait Slot {
  val symbolsPerReel: Int
  val lineCount: Int
  val reels: List[Reel]

  /**
   * Return true if symbol is wild
   */
  def isWild(symbol: Symbol): Boolean

  /**
   * Spin the reels and return the result
   */
  def spin(): SpinResult = reels.map { reel =>
    val pos = Random nextInt reel.length
    range(0, symbolsPerReel).map(i => reel((pos + i) % reel.length))
  }

  /**
   * Map a spin result to a list of symbols for each line of the slot
   */
  def lines(result: SpinResult)(implicit paylines: List[Payline]): List[List[Symbol]] =
    paylines.take(lineCount).map(result.zip(_).map { case (s, i) => s(i)})
}