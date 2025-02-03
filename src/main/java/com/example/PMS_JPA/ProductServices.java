package com.example.PMS_JPA;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {

    @Autowired
    ProductDB db;

    //ADD PRODUCT
    public void addProduct(Product product){
        System.out.println("ADDING PRODUCT");
        db.save(product);
    }


    //ALL PRODUCTS
    public void getAllProducts() {
        System.out.println("GET ALL PRODUCTS:");
        List<Product> ps=db.findAll();
        for(Product p:ps) {
            System.out.println(p);
        }

        if(ps.isEmpty()) {
            System.out.println("No product are present!");
        }
    }

    //GET PRODUCT BY NAME
    public void getProductByName(String name) {
        System.out.println("GET PRODUCTS BY NAME");
        List<Product> ps=db.findByName(name);//DSL(DOMAIN SPECIFIC LANGUAGE)
        if(!ps.isEmpty()) {
            System.out.println(ps);
        }
        else {
            System.out.println("Product not found with this name: " + name);
        }
    }



    // GET PRODUCT BY PLACE
    public void getProductByPlace(String place) {
        System.out.println("GET PRODUCTS BY PLACE");
        List<Product> ps = db.findByPlace(place); // DSL

        if (!ps.isEmpty()) {
            for (Product p : ps) {
                System.out.println(p);
            }
        } else {
            System.out.println("Products not found at this place: " + place);
        }
    }



    // DELETE PRODUCT BY NAME
    public void deleteProductByName(String name){
    	System.out.println("DELETE PRODUCT BY NAME");
    	List<Product> ps=db.findByName(name);

    	if(!ps.isEmpty()) {
    		db.deleteByName(name);
    		System.out.println(name + " Product is deleted!");
    	}
    	else {
    		System.out.println("Product not found with this name: "+ name);
    	}
    }



    // DELETE ALL PRODUCTS
    public void deleteAllProducts(){
        System.out.println("DELETE All PRODUCTS");
        List<Product> list=db.findAll();
        if(!list.isEmpty()){
            db.deleteAll();
        }
        else{
            System.out.println("List is Empty!");
        }
    }



    //OUT OF WARRENTY
    public void outOfWarrenty(int year) {
        System.out.println("OUT OF WARRENTY");
        List<Product> list=db.findAll();
        List<Product> out=new ArrayList<>();

        if(!list.isEmpty()){
            for(Product p : list){
                if(p.getWarrenty()<year){
                    out.add(p);
                }
            }
        }
        else{
            System.out.println("List is empty!");
        }


        if(!out.isEmpty()){
            for(Product p: out){
                System.out.println(p);
            }
        }
        else{
            System.out.println("There are no out of warranty products!");
        }


    }

    //FIND BY SUBSTRING
    public void findBySubString(String text){
        text=text.toLowerCase();
        System.out.println("FIND BY SUBSTRING");
        List<Product> list=db.findAll();
        List<Product> filtered=new ArrayList<>();

        for(Product p: list){
            String year=String.valueOf(p.getWarrenty());
            if(p.getName().toLowerCase().contains(text) || p.getType().toLowerCase().contains(text) ||
                    p.getPlace().toLowerCase().contains(text) || year.contains(text)){
                filtered.add(p);
            }
        }

        if(!filtered.isEmpty()){
            for(Product p: filtered){
                System.out.println(p);
            }
        }
        else{
            System.out.println("No products matched the substring: " + text);
        }
    }


}
