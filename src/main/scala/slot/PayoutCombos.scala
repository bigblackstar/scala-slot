package slot

trait PayoutCombos {
  this: Slot =>

  val payoutCombos: List[PayoutCombo]

  /**
   * Default payout combo matcher implementation
   */
  implicit def defaultMatcher: (List[Symbol], PayoutCombo) => Boolean = (line, combo) =>
    line.take(combo.count).forall(s => s == combo.symbol || isWild(s))

  /**
   * Find the biggest payout combo that matches the given line symbols
   */
  def payoutCombo(line: List[Symbol])(implicit matcher: (List[Symbol], PayoutCombo) => Boolean): Option[PayoutCombo] =
    payoutCombos.find(matcher(line, _))

  case class PayoutCombo(id: Int, symbol: Symbol, count: Int, multiplier: Int)
}
