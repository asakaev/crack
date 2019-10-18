import scala.annotation.tailrec

object LinkedLists {

  def removeDups[A](as: List[A]): List[A] =
    as.foldLeft(List.empty[A] -> Set.empty[A]) {
        case ((xs, s), a) if s.contains(a) => xs -> (s + a)
        case ((xs, s), a)                  => (a :: xs) -> (s + a)
      }
      ._1
      .reverse

  def removeDups2[A](as: List[A]): List[A] = {
    @tailrec def contains(as: List[A], a: A): Boolean = as match {
      case Nil              => false
      case h :: _ if h == a => true
      case _ :: tl          => contains(tl, a)
    }

    @tailrec def go(as: List[A], acc: List[A]): List[A] = {
      as match {
        case Nil                         => acc
        case h :: tl if !contains(tl, h) => go(tl, h :: acc)
        case _ :: tl                     => go(tl, acc)
      }
    }

    go(as, Nil).reverse
  }

}
