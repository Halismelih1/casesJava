package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        System.out.print("Bir kelime giriniz : ");
        String input = str.nextLine();
        //Girilen kelimeyi küçük harfe çevirme
        input = input.toLowerCase();
        //Dizi oluşturma
        int[] charCount = new int[128];

        for (char c : input.toCharArray()) {
                charCount[c]++;
        }

        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > 0) {
                char c = (char) i;
                System.out.println(c + ":" + charCount[i]);
            }
        }
    }
}
