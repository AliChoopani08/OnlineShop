package seeProduct;

import products.Products;
import java.util.List;

public class ChoiceProduct {

    private final ProductsActions productsActions;

    public ChoiceProduct(ProductsActions productsActions) {
        this.productsActions=productsActions;
    }

    public List<Products> selectionCategory(){
        return productsActions.getSelectCategory(Products.FoodsTuffs.foodsProducts, Products.SanitaryMaterials.sanitaryProduct);
    }
}
