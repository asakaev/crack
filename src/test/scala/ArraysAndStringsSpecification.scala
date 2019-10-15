import ArraysAndStrings._
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

object ArraysAndStringsSpecification extends Properties("ArraysAndStrings") {

  property("isUnique") = forAll { xs: List[Int] =>
    isUnique(xs) == (xs.toSet.size == xs.size)
  }

  property("permutation") = forAll { (l: List[Int], r: List[Int]) =>
    permutation(l, r) == (l.sorted == r.sorted)
  }

  property("urlify") = forAll { s: String =>
    urlify(s) == s.replace(" ", "%20")
  }

}
