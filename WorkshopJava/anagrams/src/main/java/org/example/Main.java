package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner word = new Scanner(System.in);
        System.out.println("Anagrams");
        System.out.print("1.Kelime : ");
        String word1 = word.nextLine();
        System.out.print("2.Kelime : ");
        String word2 = word.nextLine();


        //Girilen kelimeleri fonksiyona gönderme
        boolean areAnagrams = areAnagrams(word1, word2);

        //Denetleme
        if (areAnagrams) {
            System.out.println(word1 + " ve " + word2 + " anagramdır.");
        } else {
            System.out.println(word1 + " ve " + word2 + " anagram değildir.");

        }
    }

    public static boolean areAnagrams(String word1, String word2) {
        //Kelimelerin harf sayısı eşit değilse False değeri döndürür.
        if (word1.length() != word2.length()) {
            return false;
        }

        //Eşit ise
        //Kelimeleri diziye aktarıp sıralama
        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);

        // Karşılaştırma ve geriye True değeri döndürme
        return Arrays.equals(array1, array2);
    }
}