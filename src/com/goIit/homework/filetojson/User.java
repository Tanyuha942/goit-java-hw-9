package com.goIit.homework.filetojson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.Serializable;

public class User implements Serializable {

  private static final String FILE_NAME = "fileUser.txt";
  private static final String FILE_WRITE = "user.json";
  private String name;
  private int age;

  public User() {}

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "\n\n{\n\n\"name\":\"" + name + "\",\n\n" +
           "\"age\":" + age +
           "\n\n}";
  }

  public void getUsers() throws FileNotFoundException {
    ArrayList<String> listUsers = getUserList();
    ArrayList<User> user = new ArrayList<>();
    for (int i = 2, j = 3; i < listUsers.size() && j < listUsers.size(); i+=2, j+=2) {
      user.add(new User(listUsers.get(i), Integer.parseInt(listUsers.get(j))));
    }
    try (FileWriter writer = new FileWriter(FILE_WRITE))
    {
      String text = user.toString().replace("[", "").replace("]", "");
      writer.write("\n\n\n[" + text + "\n\n]\n\n\n");
      writer.flush();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  private ArrayList<String> getUserList() throws FileNotFoundException {
    Scanner scan = new Scanner(new File(FILE_NAME));
    ArrayList<String> list = new ArrayList<>();
    while (scan.hasNext()){
      list.add(scan.next());
    }
    scan.close();
    return list;
  }
}