package com.shyrokykh.subtask1;

import com.shyrokykh.subtask1.entity.Product;
import com.shyrokykh.subtask1.entity.Store;

public class Main {
    public static void main(String[] args) {
        Store store = new Store("sportmaster");

        store.addDepartment("sneaker")
                .addProduct(new Product("Nike Air Max 97", 2513.245, 1))
                .addProduct(new Product("Adidas Originals", 1900.82, 4))
                .addProduct(new Product("Nike Duckboot", 3400, 6))
                .addServicesAll("consulting", "verifying pronation")
                .addServicesAll("cleaning sneakers")
        .backToStore().visitDepartment("sneaker")
                .addProduct(new Product("asics gel lyte 3", 1990, 2))
        .backToStore().exit();

        store.addDepartment("MMA equipment")
                .addProduct(new Product("Punching Bags", 2000.4312, 4))
                .addProduct(new Product("Gloves", 1480, 5))
                .addServicesAll("consulting", "punch measurement")
        .backToStore().exit();
    }
}
