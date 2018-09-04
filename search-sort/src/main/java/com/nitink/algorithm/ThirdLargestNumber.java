package com.nitink.algorithm;


import java.util.Scanner;

public class ThirdLargestNumber {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numberOfElementsInArray = in.nextInt();
    int[] input = new int[numberOfElementsInArray];
    while (numberOfElementsInArray > 0) {
      input[input.length - numberOfElementsInArray] = in.nextInt();
      numberOfElementsInArray--;
    }
    System.out.println("Third largest number is: " + findLargestThree(input)[2]);
  }

  private static Integer[] findLargestThree(int[] input) {
    Integer[] result = new Integer[3];
    for (Integer i : input) {
      if (result[0] == null) {
        result[0] = i;
      } else if (i >= result[0]) {
        result = rightshiftArray(result);
        result[0] = i;
      } else if (result[1] == null) {
        result[1] = i;
      } else if (i >= result[1]) {
        result[2] = result[1];
        result[1] = i;
      } else if (result[2] == null) {
        result[2] = i;
      } else if (i >= result[2]) {
        result[2] = i;
      }
    }
    return result;
  }

  private static Integer[] rightshiftArray(Integer[] input) {
    for (int i = input.length - 1; i > 0; i--) {
      input[i] = input[i - 1];
    }
    return input;
  }

}
