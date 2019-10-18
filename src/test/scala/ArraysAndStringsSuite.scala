import ArraysAndStrings._
import org.scalatest.FunSuite

class ArraysAndStringsSuite extends FunSuite {

  test("stringCompression") {
    assert(stringCompression("") == Left(""))
    assert(stringCompression("A") == Left("A"))
    assert(stringCompression("AB") == Left("AB"))
    assert(stringCompression("AA") == Left("AA"))
    assert(stringCompression("AAA") == Right("A3"))
    assert(stringCompression("AABB") == Left("AABB"))
    assert(stringCompression("AABBB") == Right("A2B3"))
    assert(stringCompression("AABBBC") == Left("AABBBC"))
    assert(stringCompression("AABBBBC") == Right("A2B4C1"))
  }

  test("stringRotation") {
    assert(stringRotation("waterbottle", "erbottlewat"))
    assert(stringRotation("ABCD", "CDAB"))
    assert(!stringRotation("ABCD", "ACBD"))
  }

}
