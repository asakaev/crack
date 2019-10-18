import scala.annotation.tailrec

object ArraysAndStrings {

  def isUnique[A](as: List[A]): Boolean = {
    @tailrec def go(as: List[A]): Boolean = as match {
      case Nil                       => true
      case h :: tl if tl.contains(h) => false
      case _ :: tl                   => go(tl)
    }
    go(as)
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

  def palindromePermutation[A](as: List[A]): Boolean = {
    val s = as.foldLeft(Set.empty[A]) {
      case (s, a) if s.contains(a) => s - a
      case (s, a)                  => s + a
    }
    s.size <= 1
  }

  def oneAway[A](l: List[A], r: List[A]): Boolean = ???

  def stringCompression(s: String): Either[String, String] = {
    @tailrec def go(s: String, s1: String, n: Int): String = s match {
      case s if s.isEmpty                    => s1
      case s if s.length == 1                => s1 + s + n
      case s if s.length > 1 && s(0) == s(1) => go(s.tail, s1, n + 1)
      case s                                 => go(s.tail, s1 + s.head + n, 1)
    }

    go(s, "", 1) match {
      case s1 if s1.length < s.length => Right(s1)
      case _                          => Left(s)
    }
  }

  def rotateMatrix[A](m: Vector[Vector[A]]): Vector[Vector[A]] = ???

  def zeroMatrix[A](m: Vector[Vector[A]]): Vector[Vector[A]] = ???

  def stringRotation(l: String, r: String): Boolean =
    (l + l).contains(r)

}
