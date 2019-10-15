import scala.annotation.tailrec

object ArraysAndStrings {

  def isUnique[A](xs: List[A]): Boolean = {
    @tailrec def go(xs: List[A]): Boolean = xs match {
      case Nil                       => true
      case h :: tl if tl.contains(h) => false
      case _ :: tl                   => go(tl)
    }
    go(xs)
  }

}
