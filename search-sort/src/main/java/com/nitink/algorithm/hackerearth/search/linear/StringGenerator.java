package com.nitink.algorithm.hackerearth.search.linear;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class StringGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of total characters in the output string");
        int numberOfTotalChars = scanner.nextInt();
        System.out.println("Enter number of vowels you want in output string");
        int numberOfVowels = scanner.nextInt();
        numberOfTotalChars = numberOfTotalChars - numberOfVowels;
        List<Integer> vowels = TestClass.getVowels();
        StringBuilder stringBuilder = new StringBuilder();
        while (numberOfVowels > 0 || numberOfTotalChars > 0) {
            boolean randomBoolean = ThreadLocalRandom.current().nextBoolean();
            if (randomBoolean && numberOfVowels > 0) {
                stringBuilder.append((char) vowels.get(ThreadLocalRandom.current().nextInt(0, vowels.size())).shortValue());
                numberOfVowels--;
            } else if (numberOfTotalChars > 0) {
                char c = (char) ThreadLocalRandom.current().nextInt(97, 122);
                if (!vowels.contains(c) && !vowels.contains(c-32)) {
                    stringBuilder.append(c);
                    numberOfTotalChars--;
                }
            }
        }
        System.out.println(stringBuilder.toString());
        scanner.close();
    }

}
