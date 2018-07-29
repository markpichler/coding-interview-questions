public class ArraysAndStrings {
  /**
   * 1. Is Unique:
   *    Determine if a string has all unique characters.
   *    What if you can't use additional data structures?
   *
   * Hints:
   * "Try a hash table"
   * "Could a bit vector be useful?"
   * "Can you solve it in O(N log(N)) time?

     Method 1: Boolean Array:
     Step 1.
     Ask if string is ASCII (128 or 256 characters for extended ASCII) or
     Unicode.  Automatically return false if string length exceeds number of
     characters in the given charset.
     Step 2.
     Map each character to an index i in the boolean array corresponding to its
     position in the alphabet and toggling the value true.
     Step 3.
     If a value for a character is already true, then terminate returning false.

     Method 2: Bit Vector
     This solution assumes charset is only lowercase alphabet a-z and uses each
     bit in an int (32 bits) to store one of the letters.

     ** No additional data structures **
     Brute Force - O(n^2) time | O(1) space
     Sort First - O(n log(n)) time | O(1) space (depends on sorting algorithm)
  */
  public static boolean isUnique1(String str) {

    if (str.length() > 128)
      return false;

    int val;
    boolean[] char_set = new boolean[128];

    for (int i = 0; i < str.length(); i++) {
      val = str.charAt(i);
      if (char_set[val])
        return false;
      char_set[val] = true;
     }
     return true;
  }

  public static boolean isUnique2(String str) {
      int checker = 0, val = 0;
      for (int i = 0; i < str.length(); i++) {
          val = str.charAt(i) - 'a';
          if ((checker & (1 << val)) > 0)
              return false;
          checker |= 1 << val;
      }
      return true;
  }

  public static void main(String[] args) {
    String test1 = "StABCDEFGHIJKLMNOPQRTUVWX.Yringabcdefhjklmopqsuvwxyz";
    String test2 = "abpceioqhpkdtlj";

    System.out.println(isUnique1(test1));
    System.out.println(isUnique2(test2));
  }
}
