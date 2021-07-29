package com.goIit.homework.getvalidphones;

import java.io.*;
import java.util.*;

class ReadPhones {

  private static final String FILE_NAME = "file.txt";

  private String phone;

  public ReadPhones() {}

  public ReadPhones(String phone) {
    this.phone = phone;
  }

  @Override
  public String toString() {
    return phone;
  }

  private ArrayList<ReadPhones> getCorrectPhoneNumbers() {
    ArrayList<ReadPhones> readPhones = new ArrayList<>();
    try(BufferedReader file = new BufferedReader(new FileReader(FILE_NAME)))
    {

      String stringFile;
      while((stringFile = file.readLine())!=null){
        String[] line = stringFile.split("\n");
        for (String l : line) {
          try {
            if ((l.charAt(0) == '(' && l.charAt(4) == ')' && l.charAt(9) == '-' && checkPhone(l)) ||
                (l.charAt(3) == '-' && l.charAt(7) == '-' && checkPhone(l))) {
              readPhones.add(new ReadPhones(l));
            }
          } catch (StringIndexOutOfBoundsException ex) {
            System.out.print("");
          }
        }
      }
    }
    catch(IOException ex){
      System.out.println(ex.getMessage());
    }
    return readPhones;
  }

  private boolean checkPhone(String phoneNumber) {
    phoneNumber = phoneNumber
        .replace("-", "")
        .replace("(", "")
        .replace(")" , "")
        .replace(" ", "");
    int count = 0;
        for (int i = 0; i < phoneNumber.length(); i++) {
          if ((int)phoneNumber.charAt(i) >= 48 && phoneNumber.charAt(i) <= 57) {
            count++;
          }
        }
        return count == phoneNumber.length();
    }

    public void printValidPhones() {

      ArrayList<ReadPhones> phonesList = new ReadPhones().getCorrectPhoneNumbers();
      StringBuilder resultString = new StringBuilder();
      for (ReadPhones p: phonesList) {
        resultString
            .append("\n")
            .append(p)
            .append("\n");
      }
      System.out.println("\n\n" + resultString + "\n\n");
    }
}