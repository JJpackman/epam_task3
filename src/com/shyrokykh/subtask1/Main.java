package com.shyrokykh.subtask1;

import com.shyrokykh.subtask1.entity.Product;
import com.shyrokykh.subtask1.entity.Store;

public class Main {
    public static void main(String[] args) {
        Store store = new Store("sportmaster");

        store.addDepartment("sneaker")
                .addProduct(new Product("Nike Air Max 97", 2513.245))
                .addProduct(new Product("Adidas Originals", 1900.82))
                .addProduct(new Product("Nike Duckboot", 3400))
                .addServices("consulting", "verifying pronation")
                .addServices("cleaning sneakers")
        .backToStore().visitDepartment("sneaker")
                .addProduct(new Product("asics gel lyte 3", 1990))
        .backToStore().exit();

        store.addDepartment("MMA equipment")
                .addProduct(new Product("Punching Bags", 2000.4312))
                .addProduct(new Product("Gloves", 1480))
                .addServices("consulting")
                .addServices("punch measurement")
        .backToStore().exit();
    }
}
