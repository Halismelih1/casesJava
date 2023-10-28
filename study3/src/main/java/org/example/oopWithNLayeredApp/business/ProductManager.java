package org.example.oopWithNLayeredApp.business;

import org.example.oopWithNLayeredApp.core.loging.Logger;
import org.example.oopWithNLayeredApp.dataAcces.HibernateProductDao;
import org.example.oopWithNLayeredApp.dataAcces.JdbcProductDao;
import org.example.oopWithNLayeredApp.dataAcces.ProductDao;
import org.example.oopWithNLayeredApp.enties.Product;

public class ProductManager {

    private ProductDao productDao;
    private Logger[] loggers;

    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
        this.loggers = loggers;
    }

    // is birimi
    // is birimi kurallarini isletiyor
    public void add(Product product) throws Exception {
        // iş kurallari
        if (product.getUnitPrice() < 10) {
            //eger kurallara uyulmuyorsa hata firlatiyor
            throw new Exeption("Urun fiyati 10 dan kucuk olamaz");
        }
        // kurallara uyuluyorsa veri tabanina eklenir
        //HibernateProductDao productDao = new HibernateProductDao();
        productDao.add(product);

        for (Logger logger : loggers) { // db,mail
            logger.log(product.getName());
        }
    }
}

// bir katman baska bir katmanin clasini kullanirken sadece interfacesinden erisim kurmalidir