package org.example.oopWithNLayeredApp.dataAcces;

import org.example.oopWithNLayeredApp.enties.Product;

public class HibernateProductDao implements ProductDao {
    public void add(Product product){
        System.out.println("Hibernate ile veritabanina eklendi");

    }

}
