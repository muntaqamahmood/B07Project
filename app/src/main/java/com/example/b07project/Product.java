package com.example.b07project;

public class Product {

    String name;
    String brand;
    float price;

    public Product(){}

    public Product(String name, String brand, float price){
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    @Override
    public int hashCode(){
        return (int)(name.length() + price* 100);
    }

    @Override
    public String toString(){
        return name + ',' + brand +',' + price;
    }

}
