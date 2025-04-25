package seeProduct;

import products.Products;

public class BuySelectedProduct {

    private final ProductsActions productsActions;

    public BuySelectedProduct(ProductsActions productsActions) {
        this.productsActions=productsActions;
    }

    public Products buySelectedProduct()
    {
        final ChoiceProduct choiceProduct = new ChoiceProduct(productsActions);
        return productsActions.buySelectedProduct(choiceProduct.selectionCategory());
    }

    }

