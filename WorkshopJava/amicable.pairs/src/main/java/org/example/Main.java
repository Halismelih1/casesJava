package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner numbers = new Scanner(System.in);
        System.out.print("1. Sayıyı Giriniz : ");
        int num1 = numbers.nextInt();
        System.out.print("2. Sayıyı Giriniz : ");
        int num2 = numbers.nextInt();

        isAmicable (num1,num2);

    }

    public static boolean isAmicable(int num1, int num2) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 1; i < num1 ; i++) {
            if (num1 % i == 0){
                sum1 += i;
            }
        }

        for (int i = 1; i < num2 ; i++) {
            if (num2 % i == 0){
                sum2 += i;
            }
        }

        if (num1 == sum2 && num2 == sum1)
        {
            System.out.println("İki sayi arkadas sayidir.");
        }
        else
        {
            System.out.println("İki sayi arkadas sayi degildir.");
        }

        return true;

    }
}