package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
    val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a', 'b', 'd'))
    }
  }

  test("times of chars") {
    val str = "abaaadb".toList
    val res = List(('b', 2), ('d', 1), ('a', 4))
    assert(times(str) === res)
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4)))
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("create Code Tree") {
    val strList = "abcdababa".toList
    val codeTree = createCodeTree(strList)
    assert(codeTree.toString === "Fork(Leaf(a,4),Fork(Fork(Leaf(d,1),Leaf(c,1),List(d, c),2),Leaf(b,3),List(d, c, b),5),List(a, d, c, b),9)")
  }

  test("decode a char") {
    val codeTree = createCodeTree("abcdababa".toList)
    val s = decode(codeTree, List(1, 0, 1))
    assert(s === List('c'))
  }
  
  test("encode a char") {
    val codeTree = createCodeTree("abcdababa".toList)
    val s = encode(codeTree)(List('d'))
    assert(s === List(1, 0, 0))
  }
  
  
  test("convert a CodeTree to a CodeTable") {
    val codeTree = Fork(Leaf('a',4),Fork(Fork(Leaf('d',1),Leaf('c',1),List('d', 'c'),2),Leaf('b',3),List('d', 'c', 'b'),5),List('a', 'd', 'c', 'b'),9)
    val codeTable = convert(codeTree)
    assert(codeTable === List(('a',List(0)), ('b',List(1, 1)), ('d',List(1, 0, 0)), ('c',List(1, 0, 1))))
  }
  
}
