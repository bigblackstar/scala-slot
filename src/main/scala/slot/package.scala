package object slot {
  type Symbol = Int
  type Reel = List[Symbol]
  type SpinResult = List[List[Symbol]]
  type Payline = List[Int]

  implicit val Paylines: List[Payline] = List(
    List(1, 1, 1, 1, 1), List(0, 0, 0, 0, 0), List(2, 2, 2, 2, 2), List(0, 1, 2, 1, 0), List(2, 1, 0, 1, 2),
    List(1, 2, 1, 2, 1), List(1, 0, 1, 0, 1), List(2, 1, 2, 1, 2), List(0, 1, 0, 1, 0), List(0, 0, 1, 2, 2),
    List(2, 2, 1, 0, 0), List(1, 0, 1, 2, 1), List(1, 2, 1, 0, 1), List(0, 1, 1, 1, 2), List(2, 1, 1, 1, 0),
    List(1, 0, 0, 1, 2), List(1, 2, 2, 1, 0), List(1, 1, 0, 1, 2), List(1, 1, 2, 1, 0), List(0, 0, 1, 2, 1),
    List(2, 2, 1, 0, 1), List(1, 0, 1, 2, 2), List(1, 2, 1, 0, 0), List(0, 0, 0, 1, 2), List(2, 2, 2, 1, 0)
  )
}
