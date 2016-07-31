package forcomp

object Anagrams {

  /** A word is simply a `String`. */
  type Word = String

  /** A sentence is a `List` of words. */
  type Sentence = List[Word]

  /**
   * `Occurrences` is a `List` of pairs of characters and positive integers saying
   *  how often the character appears.
   *  This list is sorted alphabetically w.r.t. to the character in each pair.
   *  All characters in the occurrence list are lowercase.
   *
   *  Any list of pairs of lowercase characters and their frequency which is not sorted
   *  is **not** an occurrence list.
   *
   *  Note: If the frequency of some character is zero, then that character should not be
   *  in the list.
   */
  type Occurrences = List[(Char, Int)]

  /**
   * The dictionary is simply a sequence of words.
   *  It is predefined and obtained as a sequence using the utility method `loadDictionary`.
   */
  val dictionary: List[Word] = loadDictionary

  /**
   * Converts the word into its character occurrence list.
   *
   *  Note: the uppercase and lowercase version of the character are treated as the
   *  same character, and are represented as a lowercase character in the occurrence list.
   *
   *  Note: you must use `groupBy` to implement this method!
   */
  def wordOccurrences(w: Word): Occurrences = {
    (w.toLowerCase.toList
      .filter(r => r.toString.matches("[a-z]"))
      .map(r => (r, 1))
      .groupBy(r => r._1)
      .map(r => (r._1, r._2.size))
      .toList
      .sorted)
  }

  /** Converts a sentence into its character occurrence list. */
  def sentenceOccurrences(s: Sentence): Occurrences = wordOccurrences(s.mkString(""))

  /**
   * The `dictionaryByOccurrences` is a `Map` from different occurrences to a sequence of all
   *  the words that have that occurrence count.
   *  This map serves as an easy way to obtain all the anagrams of a word given its occurrence list.
   *
   *  For example, the word "eat" has the following character occurrence list:
   *
   *     `List(('a', 1), ('e', 1), ('t', 1))`
   *
   *  Incidentally, so do the words "ate" and "tea".
   *
   *  This means that the `dictionaryByOccurrences` map will contain an entry:
   *
   *    List(('a', 1), ('e', 1), ('t', 1)) -> Seq("ate", "eat", "tea")
   *
   */
  lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] =
    (dictionary.map(r => (wordOccurrences(r), r))
      .groupBy(r => r._1)
      .map(r => (r._1, for (x <- r._2) yield x._2)))

  /** Returns all the anagrams of a given word. */
  def wordAnagrams(word: Word): List[Word] = {
    val wordOccurence = wordOccurrences(word)
    val words = for (r <- dictionaryByOccurrences if r._1 == wordOccurence) yield r._2
    words.flatten.toList
  }

  /**
   * Returns the list of all subsets of the occurrence list.
   *  This includes the occurrence itself, i.e. `List(('k', 1), ('o', 1))`
   *  is a subset of `List(('k', 1), ('o', 1))`.
   *  It also include the empty subset `List()`.
   *
   *  Example: the subsets of the occurrence list `List(('a', 2), ('b', 2))` are:
   *
   *    List(
   *      List(),
   *      List(('a', 1)),
   *      List(('a', 2)),
   *      List(('b', 1)),
   *      List(('a', 1), ('b', 1)),
   *      List(('a', 2), ('b', 1)),
   *      List(('b', 2)),
   *      List(('a', 1), ('b', 2)),
   *      List(('a', 2), ('b', 2))
   *    )
   *
   *  Note that the order of the occurrence list subsets does not matter -- the subsets
   *  in the example above could have been displayed in some other order.
   */
  def combinations(occurrences: Occurrences): List[Occurrences] = {

    def decompose(xs: (Char, Int)): List[Occurrences] =
      (for (i <- 1 to xs._2) yield List((xs._1, i))).toList

    def loop(occurrence: Occurrences, res: List[Occurrences]): List[Occurrences] = occurrence match {
      case List() => res
      case x :: xs => {
        val res0 = decompose(x)
        val res1 = for (i <- 1 to x._2; item <- res if (item.forall(z => z._1 != x._1))) yield ((x._1, i) :: item).sorted
        val res2: List[Occurrences] = res1.toList

        loop(xs, res2 ::: res0 ::: res)
      }
    }

    List(List()) ::: loop(occurrences, List())
  }

  /**
   * Subtracts occurrence list `y` from occurrence list `x`.
   *
   *  The precondition is that the occurrence list `y` is a subset of
   *  the occurrence list `x` -- any character appearing in `y` must
   *  appear in `x`, and its frequency in `y` must be smaller or equal
   *  than its frequency in `x`.
   *
   *  Note: the resulting value is an occurrence - meaning it is sorted
   *  and has no zero-entries.
   */
  def subtract1(x: Occurrences, y: Occurrences): Occurrences = (x.toSet -- y.toSet).toList.sorted

  def subtract(x: Occurrences, y: Occurrences): Occurrences = {
    val mapX = x.toMap
    val mapY = y.toMap
    mapX.map(r => if (mapY.contains(r._1)) (r._1, r._2 - mapY(r._1)) else r).toList.filter(r => r._2 > 0).sorted
  }

  /**
   * Returns a list of all anagram sentences of the given sentence.
   *
   *  An anagram of a sentence is formed by taking the occurrences of all the characters of
   *  all the words in the sentence, and producing all possible combinations of words with those characters,
   *  such that the words have to be from the dictionary.
   *
   *  The number of words in the sentence and its anagrams does not have to correspond.
   *  For example, the sentence `List("I", "love", "you")` is an anagram of the sentence `List("You", "olive")`.
   *
   *  Also, two sentences with the same words but in a different order are considered two different anagrams.
   *  For example, sentences `List("You", "olive")` and `List("olive", "you")` are different anagrams of
   *  `List("I", "love", "you")`.
   *
   *  Here is a full example of a sentence `List("Yes", "man")` and its anagrams for our dictionary:
   *
   *    List(
   *      List(en, as, my),
   *      List(en, my, as),
   *      List(man, yes),
   *      List(men, say),
   *      List(as, en, my),
   *      List(as, my, en),
   *      List(sane, my),
   *      List(Sean, my),
   *      List(my, en, as),
   *      List(my, as, en),
   *      List(my, sane),
   *      List(my, Sean),
   *      List(say, men),
   *      List(yes, man)
   *    )
   *
   *  The different sentences do not have to be output in the order shown above - any order is fine as long as
   *  all the anagrams are there. Every returned word has to exist in the dictionary.
   *
   *  Note: in case that the words of the sentence are in the dictionary, then the sentence is the anagram of itself,
   *  so it has to be returned in this list.
   *
   *  Note: There is only one anagram of an empty sentence.
   */
  def sentenceAnagrams(sentence: Sentence): List[Sentence] = {

    /**
     * Occurrences created from the input sentence
     */
    val occurrences: Occurrences = sentenceOccurrences(sentence)
    //    println("occurrences: " + sentence)
    //    occurrences.foreach(println)

    /**
     * List of Occurrences based on the input sentence
     */
    val occurrencesCombination: List[Occurrences] = combinations(occurrences)
    //    println("\n============ Occurrences Combination: ================")
    //    occurrencesCombination.foreach(println)

    /**
     * search a list of words for an Occurrences
     */
    def getWordsByOccurrence(occurrence: Occurrences): List[Word] =
      if (dictionaryByOccurrences.contains(occurrence)) dictionaryByOccurrences(occurrence) else List()

    def getWordsByOccurrences(occurrences: List[Occurrences]): List[List[Word]] =
      for (item <- occurrences) yield getWordsByOccurrence(item)

    def wordCombination(wordList1: List[Word], wordList2: List[List[Word]]): List[List[Word]] =
      if (wordList2.isEmpty) for (word1 <- wordList1) yield List(word1)
      else for (word1 <- wordList1; word2 <- wordList2) yield word1 :: word2

    /**
     * search the complete list of words for an Occurrences
     */
    def getAllWordsByOccurrence(sentenceOccurrences: Occurrences,
                                occurrence: Occurrences,
                                words: List[List[Word]]): List[List[Word]] = occurrence match {
      case List() => words
      case occurrence => {
        val newWords = getWordsByOccurrence(occurrence)
        //if (!newWords.isEmpty) println("\nWords: " + words + "\t\t" + "New Words: " + newWords)

        if (newWords.isEmpty) List()
        else {
          val remaintOccurrences = subtract(sentenceOccurrences, occurrence)
          val remaintOccurrencesCombination = combinations(remaintOccurrences)

          val wordList: List[List[Word]] = if (remaintOccurrences.isEmpty) wordCombination(newWords, words)
          else {
            val allWords = for (item <- remaintOccurrencesCombination if (!item.isEmpty))
              yield (getAllWordsByOccurrence(remaintOccurrences, item, wordCombination(newWords, words)))

            //println("\nAll Words: " + allWords )
            //allWords.foreach(r => if(!r.isEmpty) println(r))

            if (allWords.forall(item => !item.isEmpty)) allWords.flatten else List()
            allWords.flatten
          }

          wordList
        }
      }
    }

    // val w = getAllWordsByOccurrence(occurrences, List(('a', 1), ('m', 1), ('n', 1)), Nil)
    val w = for (item <- occurrencesCombination) yield getAllWordsByOccurrence(occurrences, item, List())

    //    println("\n============== Results =================")
    //    w.foreach(r => if (!r.isEmpty) println(r))

    //wordCombination(List("yes"), List("ok")).foreach(println)
    if (occurrences.isEmpty) List(List()) else w.flatten
  }

  def main(args: Array[String]): Unit = {
    println("Start from here ...")
    //    val t = combinations(List(('a', 2), ('b', 2), ('c', 2)))
    //    val t = combinations(List(('a', 2), ('b', 2)))

    println("===============================")
    //    t.foreach(r => println(r))

    val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 2))
    val r = List(('a', 1), ('r', 1))
    //    println("\nlard:" + lard)
    //    println("ar:" + r)
    //    println(subtract(lard, r))
    sentenceAnagrams(List("Yes", "man")).foreach(println)

  }
}
