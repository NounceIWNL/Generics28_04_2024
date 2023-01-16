package com.company.parsing;

import java.util.List;

public class Products {
//    @XmlElement(name = "product")
    private List<Product> products = null;

    public Products(){
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
