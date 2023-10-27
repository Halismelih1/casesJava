package org.example;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product();
        product1.setName("karpuz");
        product1.setImageUrl("bilmemne.jpg");
        product1.setDiscount(35);
        product1.setUnitInStock(50);
        product1.setUnitPrice(15);

        Product product2 = new Product();
        product2.setName("elma");
        product2.setImageUrl("falan.jpg");
        product2.setDiscount(25);
        product2.setUnitInStock(50);
        product2.setUnitPrice(85);

        Product product3 = new Product();
        product3.setName("armut");
        product3.setImageUrl("filan.jpg");
        product3.setDiscount(25);
        product3.setUnitInStock(40);
        product3.setUnitPrice(75);

        Product[] products = {product1, product2, product3};

        for (Product product : products) {
            System.out.println(product.getName() + product.getDiscount());
        }

        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setName("melih");
        individualCustomer.setFirstName("halis");
        individualCustomer.setLastName("abak");
        individualCustomer.setCustomerNumber("3242354235");
        individualCustomer.setPhone("05256595898");

        CorvorateCustomer corvorateCustomer = new CorvorateCustomer();
        corvorateCustomer.setCompanyName("expLa");
        corvorateCustomer.setTaxNo("65487ed");
        corvorateCustomer.setName("melih");
        corvorateCustomer.setPhone("05256595898");
        corvorateCustomer.setCustomerNumber("321564yu");

        Customer[] customers = {individualCustomer,corvorateCustomer};






    }
}
