package org.example;

import org.example.oopWithNLayeredApp.business.ProductManager;
import org.example.oopWithNLayeredApp.core.loging.DatabaseLogger;
import org.example.oopWithNLayeredApp.core.loging.FileLogger;
import org.example.oopWithNLayeredApp.core.loging.Logger;
import org.example.oopWithNLayeredApp.dataAcces.HibernateProductDao;
import org.example.oopWithNLayeredApp.enties.Product;

public class Main {
    public static void main(String[] args) {
        // sanki ekrandan bir urun girmisiz gibi
        Product product1 = new Product(1, "iphone Xr", 10);

        // istenene gore eklenir cikarilir
        Logger[] loggers = {new DatabaseLogger(), new FileLogger()};

        // sonrasinda onu is birimine yolluyoruz
        ProductManager productManager = new ProductManager(new HibernateProductDao());
        productManager.add(product1);


    }
}