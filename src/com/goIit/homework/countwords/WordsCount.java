package com.goIit.homework.countwords;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class WordsCount {

  private static final String FILE_NAME = "words.txt";

  public void getCount() throws IOException {
    Multiset<String> countSet = HashMultiset.create();
    BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME));
    String line;
    StringBuilder result = new StringBuilder();
    while ((line = bufferedReader.readLine()) != null) {
      if (line.length() != 0) {
        List<String> words = Arrays.asList(line.split("\\W+"));
        countSet.addAll(words);
      }
    }
    bufferedReader.close();
    for (Entry<String> entry : countSet.entrySet()) {
      result
          .append("\n").append(entry.getElement()).append(" ").append(entry.getCount())
          .append("\n");
    }
    System.out.println("\n\n" + result.toString() + "\n\n");
  }
}