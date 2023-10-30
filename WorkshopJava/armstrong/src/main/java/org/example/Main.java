package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner num = new Scanner(System.in);
        System.out.print("Sayı Giriniz : ");
        int number = num.nextInt();
        int tempNumber = number;
        int orgNumber = number;
        int basamaksayisi = 0;
        double sum = 0;
        boolean isArmstrong;

        while (number != 0){
            number /= 10;
            basamaksayisi++;
        }

        for (int i = 0; i < basamaksayisi ; i++) {
            int digit = tempNumber % 10;
            sum = sum + Math.pow(digit,basamaksayisi);
            tempNumber /= 10;
        }


        if (sum == orgNumber) {
            System.out.println(orgNumber + " bir Armstrong sayısıdır.");

        } else {

            System.out.println(orgNumber + " bir Armstrong sayısı değildir.");
        }
    }






}