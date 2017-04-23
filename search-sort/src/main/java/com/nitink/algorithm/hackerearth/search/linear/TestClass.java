package com.nitink.algorithm.hackerearth.search.linear;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class TestClass {

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        List<Integer> vowels = getVowels();
        for (int i = 0; i < numberOfTests; i++) {
            String input = scanner.next();
            int count = 0;
            Iterator<Integer> iterator= input.chars().iterator();
            while(iterator.hasNext()){
                count = vowels.contains(iterator.next()) ? ++count : count;
            }
            System.out.println(count);
        }
        scanner.close();
    }

    static List<Integer> getVowels() {
        List<Integer> vowels = new ArrayList<>();
        vowels.add((int) 'a');
        vowels.add((int) 'A');

        vowels.add((int) 'e');
        vowels.add((int) 'E');

        vowels.add((int) 'i');
        vowels.add((int) 'I');

        vowels.add((int) 'o');
        vowels.add((int) 'O');

        vowels.add((int) 'u');
        vowels.add((int) 'U');
        return vowels;
    }

}