import LinkedLists._
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

object LinkedListsSpecification extends Properties("LinkedLists") {

  property("removeDups") = forAll { xs: List[Int] =>
    removeDups(xs) == xs.distinct
  }

  property("removeDups2") = forAll { xs: List[Int] =>
    removeDups2(xs) == xs.reverse.distinct.reverse
  }

}
