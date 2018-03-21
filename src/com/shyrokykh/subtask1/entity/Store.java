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

    public void exit() {}

    public Department visitDepartment(String name) {
        final Department newDep = new Department(name);
        int index = this.departments.indexOf(newDep);

        return index != -1 ? this.departments.get(index) : null;
    }

    public Department addDepartment(String name) {
        final Department newDep = new Department(name);
        int index = this.departments.indexOf(newDep);

        if (index == -1) {
            this.departments.add(newDep);
            index = departments.size() - 1;
        }

        return departments.get(index);
    }

    public boolean removeDepartment(String name) {
        return departments.remove(new Department(name));
    }

    public class Department {
        private final String name;
        private final Set<Product> products;
        private final List<String> services;

        private Department(String name) {
            this.name = name;
            this.products = new HashSet<>();
            this.services = new ArrayList<>();
        }

        public Department addServicesAll(String... services) {
            if (services != null) {
                for (String checkedService : services) {
                    if (!this.services.contains(checkedService)) {
                        this.services.add(checkedService);
                    }
                }
            }

            return this;
        }

        public String getName() {
            return name;
        }

        public Department addProduct(Product p) {
            if (!this.products.contains(p)) {
                this.products.add(p);
            }

            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Department that = (Department) o;

            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        public boolean removeProduct(Product p) {
            return this.products.remove(p);
        }

        public Store backToStore() {
            return Store.this;
        }
    }
}
