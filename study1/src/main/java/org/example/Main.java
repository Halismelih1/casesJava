package org.example;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");


        String ortaMetin = "İlginizi çekebilir";
        String altMetin = "Vade süresi";

        System.out.println(orta);

        int vade = 12;

        double dolarDun = 18.20;
        double dolarBugun = 18.30;

        boolean dolarDustuMu = false;

        String okYonu = "";

        if (dolarBugun<dolarDun){ //true
            okYonu = "down.svg";
            System.out.println(okYonu);
        } else if (dolarBugun>dolarDun) {
            okYonu = "up.svg";
            System.out.println(okYonu);
        } else { //false
            okYonu = "equal.svg";
            System.out.println(okYonu);
        }




        String[] krediler = {"Hızlı Kredi","Maaşını Halkbanktan","Mutlu Emekli"};

        System.out.println(krediler[0]);
        System.out.println(krediler[1]);
        System.out.println(krediler[2]);

        for (int i = 0; i < krediler.length; i++) {
            System.out.println(krediler[i]);
        }


    }
}