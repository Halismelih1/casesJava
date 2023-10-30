package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner str = new Scanner(System.in);
        System.out.print("Bir kelime giriniz : ");
        String input = str.nextLine();
        //Girilen kelimeyi küçük harfe çevirme
        input = input.toLowerCase();

        if (uniqueCharacters(input)){
            System.out.println("Kelimeniz benzersiz karakterlerden oluşuyor.");
        }else {
            System.out.println("Kelimeniz benzersiz karakterlerden oluşmuyor.");
        }

    }

    static boolean uniqueCharacters(String str)
    {
        for (int i = 0; i < str.length(); i++)
            for (int j = i + 1; j < str.length(); j++)
                if (str.charAt(i) == str.charAt(j))
                    return false;

        return true;
    }
}