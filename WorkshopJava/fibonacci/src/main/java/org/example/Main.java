package org.example;

public class Main {
    public static void main(String[] args) {
        int n, a = 0, b = 1, c = 1;
        System.out.print("Fibonacci Serisi : ");
        for(int i = 1; i <= 100; i++)
        {
            a = b;
            b = c;
            c = a + b;
            System.out.print(a+" ");
        }
    }
}