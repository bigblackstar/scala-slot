package slot

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SlotSuite extends FunSuite {
  trait DummySlot extends Slot {
    override def isWild(symbol: Symbol): Boolean = symbol == 0
    override val symbolsPerReel: Int = 3
    override val lineCount: Int = 5
    override val reels: List[Reel] = List.fill(5)(List(1,2,3,4,5))
  }

  test("spin: correct result dimensions") {
    new DummySlot {
      assert(spin().length == reels.length)
      assert(spin().forall(_.length == symbolsPerReel))
    }
  }
}
