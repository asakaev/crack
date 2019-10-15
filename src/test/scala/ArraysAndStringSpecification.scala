import ArraysAndStrings.isUnique
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

object ArraysAndStringSpecification extends Properties("ArraysAndString") {

  property("isUnique") = forAll { xs: List[Int] =>
    isUnique(xs) == (xs.toSet.size == xs.size)
  }

}
