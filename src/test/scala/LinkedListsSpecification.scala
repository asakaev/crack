import LinkedLists._
import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Prop.{forAll, propBoolean}
import org.scalacheck.{Gen, Properties}

object LinkedListsSpecification extends Properties("LinkedLists") {

  property("removeDups") = forAll { xs: List[Int] =>
    removeDups(xs) == xs.distinct
  }

  property("removeDups2") = forAll { xs: List[Int] =>
    removeDups2(xs) == xs.reverse.distinct.reverse
  }

  property("deleteMiddleNode") =
    forAll(Gen.listOfN(0, arbitrary[Int])) { xs =>
      deleteMiddleNode(xs) == xs
    } && forAll(Gen.listOfN(1, arbitrary[Int])) { xs =>
      deleteMiddleNode(xs) == xs
    } && forAll(Gen.listOfN(2, arbitrary[Int])) { xs =>
      deleteMiddleNode(xs) == xs
    } && forAll { xs: List[Int] =>
      (xs.size > 2) ==> (deleteMiddleNode(xs) == xs.zipWithIndex.collect {
        case (v, idx) if idx != xs.size / 2 => v
      })
    }

}
