package seeProduct;

import products.Products;

import java.util.List;

public interface ProductsActions {
    List<Products> getSelectCategory(List<Products> foodsProducts , List<Products> sanitaryProduct);
    Products buySelectedProduct(List<Products> products);

}
