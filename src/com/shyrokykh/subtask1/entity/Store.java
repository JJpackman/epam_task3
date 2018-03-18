package com.shyrokykh.subtask1.entity;

import java.util.*;

public class Store {
    private final String name;
    private final List<Department> departments;

    public Store(String name) {
        this.name = name;
        this.departments = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    private Department findDepartment(String name) {
        for (Department existingDep : departments) {
            if (Objects.equals(existingDep.name.toLowerCase(), name.toLowerCase())) {
                return existingDep;
            }
        }

        return null;
    }

    public void exit() {}

    public Department visitDepartment(String name) {
        return findDepartment(name);
    }

    public Department addDepartment(String name) {
        Department dep = findDepartment(name);

        if (dep != null) {
            return dep;
        }

        this.departments.add(new Department(name));
        return departments.get(departments.size() - 1);
    }

    public boolean removeDepartment(String name) {
        Department dep = findDepartment(name);

        return dep != null && departments.remove(dep);
    }

    public class Department {
        private final String name;
        private final Set<Product> products;
        private final List<String> services;

        private Department(String name) {
            this.name = name;
            this.products = new HashSet<>();
            this.services = new LinkedList<>();
        }

        private String findService(String service) {
            for (String existingService : services) {
                if (Objects.equals(existingService.toLowerCase(), service.toLowerCase())) {
                    return existingService;
                }
            }

            return null;
        }

        public Department addServices(String... services) {
            if (services != null) {
                for (String service : services) {
                    if (findService(service) == null) {
                        this.services.add(service);
                    }
                }
            }

            return this;
        }

        public Department addProduct(Product p) {
            this.products.add(p);

            return this;
        }

        public Store backToStore() {
            return Store.this;
        }

        public boolean removeProduct(Product p) {
            return this.products.remove(p);
        }
    }
}
