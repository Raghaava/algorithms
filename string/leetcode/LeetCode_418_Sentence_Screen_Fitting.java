package org.interview.preperation.string.leetcode;

public class LeetCode_418_Sentence_Screen_Fitting {

  public static void main(String... args) {
    int rows = 4, cols = 5;
    String sentence[] = new String[]{"I", "had", "apple", "pie"};

    int leftOverSpaces = cols, currentRow = 0, counter = 0, index = 0;
    //keep fitting words till last row.
    while (currentRow < rows) {
      //reset if we reach end of the sentence array.
      if (index >= sentence.length) {
        counter++;
        index = 0;
      }
      //check before printing if current row can accommodate word or not.
      if (sentence[index].length() <= leftOverSpaces) {
        System.out.print(sentence[index]);
        leftOverSpaces = leftOverSpaces - sentence[index].length();
        //print space as well.
        if (leftOverSpaces >= 1) {
          System.out.print("_");
          leftOverSpaces--;
        }
        index++;
      } else {
        currentRow++;
        leftOverSpaces = cols;
        System.out.println();
      }
    }
    System.out.println(counter);
  }
}
