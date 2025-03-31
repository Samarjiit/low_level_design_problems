package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {

    //category wise products storage
    public List<ProductCategory> productCategoryList;

    public Inventory(){
        productCategoryList = new ArrayList<>();
    }

    //add new category

    //here coco cola is a product and coco cola large is the product category having the price and qty
    public void addCategory(int categoryId, String name, int price){
        ProductCategory productCategory = new ProductCategory();
        productCategory.price = price;
        productCategory.categoryName = name;
        productCategory.productCategoryId = categoryId;
        productCategoryList.add(productCategory);
    }


    //add product to the particular category
    public void addProduct(Product product, int productCategoryId){

        //take out the respective productCategory Object
        ProductCategory categoryObject = null;
        for(ProductCategory category : productCategoryList)
        {
            if(category.productCategoryId == productCategoryId){
                categoryObject = category;
            }
        }

        if(categoryObject !=null) {
            categoryObject.addProduct(product);
        }
    }

    //remove product from the category
    public void removeItems(Map<Integer, Integer> productCategoryAndCountMap){

        for(Map.Entry<Integer, Integer> entry : productCategoryAndCountMap.entrySet())
        {
            ProductCategory category = getProductCategoryFromID(entry.getKey());
             category.removeProduct(entry.getValue());
        }

    }

    public ProductCategory getProductCategoryFromID(int productCategoryId){

        for(ProductCategory productCategory : productCategoryList){

            if(productCategory.productCategoryId == productCategoryId){
                return productCategory;
            }
        }

        return null;
    }
}
//The removeItems method:
//Takes a map where each entry consists of a product category ID and a count of how many products should be removed from that category.
//It iterates over the map, and for each entry:
//Retrieves the product category associated with the category ID.
//Removes the specified number of products from that category.