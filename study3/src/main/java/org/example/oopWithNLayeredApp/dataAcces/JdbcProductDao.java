package org.example.oopWithNLayeredApp.dataAcces;

import org.example.oopWithNLayeredApp.enties.Product;

public class JdbcProductDao implements ProductDao {
    // Alinan urun veri tabanina eklenir
    public void add(Product product){ //product tipinde bir nesne gecmem gerektigi icin
        // Sadece ve sadece db erisim kodlari buraya yazilir... SQL
        System.out.println("JDBC ile veritabanina eklendi");

    }

}
// Domain -> Iki farkli web sitesinin ayni domaine sahip olmasi mumkun degildir.
// Alan adi DNS(Domain Name System) ile ilgili IP adresine donusturulur.