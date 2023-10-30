package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) { //Write a Java program finds first 10 perfect numbers.
        List<Long> perfectNumbers = new ArrayList<>();

        for (long i = 1; i < 10000; i++ ){
            if (perfectNumbers.size() == 10){
                break;
            }
            if (isPerfect(i)){
                perfectNumbers.add(i);
            }
        }

    }

    public static List<Long> findDivisors(long num){
        List<Long> divisors = new ArrayList<>();
        for(long i = 1; i < num; i++) {
            if (num % i == 0){
                divisors.add(i); // 1,2,3
            }
        }
        return divisors;
    }

    public static boolean isPerfect(long num){
        List<Long> divisors = findDivisors(num); // 1,2,3
        long sum = 0;
        for (long i = 0; i < divisors.size(); i++){
            sum += divisors.get((int) i);
        }
        if (sum == num){
            System.out.println(num);
            return true;
        }else {
            return false;
        }
    }

}