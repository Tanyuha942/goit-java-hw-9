package com.goIit.homework.getvalidphones;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

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

  public ArrayList<ReadPhones> getCorrectPhoneNumbers() {
    ArrayList<ReadPhones> readPhones = new ArrayList<>();
    try(BufferedReader file = new BufferedReader(new FileReader(FILE_NAME)))
    {

      String stringFile;
      while((stringFile = file.readLine())!=null){
        String[] line = stringFile.split("\n");
        for (String l : line) {
          String str2 = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[-]*\\d{4}$";
          try {
            if (Pattern.compile(str2).matcher(l).matches() ) {
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