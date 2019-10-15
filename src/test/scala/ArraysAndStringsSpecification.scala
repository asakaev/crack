import ArraysAndStrings._
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties
import org.scalacheck.Test.Parameters

object ArraysAndStringsSpecification extends Properties("ArraysAndStrings") {

  override def overrideParameters(p: Parameters): Parameters = p.withMaxSize(5)

  property("isUnique") = forAll { xs: List[Int] =>
    isUnique(xs) == (xs.toSet.size == xs.size)
  }

  property("permutation") = forAll { (l: List[Int], r: List[Int]) =>
    permutation(l, r) == (l.sorted == r.sorted)
  }

  property("urlify") = forAll { s: String =>
    urlify(s) == s.replace(" ", "%20")
  }

  property("palindromePermutation") = forAll { xs: List[Int] =>
    palindromePermutation(xs) == xs.permutations.exists(xs => xs == xs.reverse)
  }

}
