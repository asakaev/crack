import scala.annotation.tailrec

object ArraysAndStrings {

  def isUnique[A](xs: List[A]): Boolean = {
    @tailrec def go(as: List[A]): Boolean = as match {
      case Nil                       => true
      case h :: tl if tl.contains(h) => false
      case _ :: tl                   => go(tl)
    }
    go(xs)
  }

  def permutation[A](l: List[A], r: List[A]): Boolean = {
    def occurrences(as: List[A]): Map[A, Int] =
      as.groupMapReduce(identity)(_ => 1)(_ + _)

    occurrences(l) == occurrences(r)
  }

  def urlify(s: String): String =
    s.foldLeft("") {
      case (s, c) if c == ' ' => s + "%20"
      case (s, c)             => s + c
    }

}
