package org.example.oopWithNLayeredApp.core.loging;

public class MailLogger implements Logger{

    @Override
    public void log(String data) {
        System.out.println("Mail Gonderildi : " + data);

    }
}
