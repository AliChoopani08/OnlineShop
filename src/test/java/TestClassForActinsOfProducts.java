
import example.InputAndOutput;
import exceptions.RequestOutsideOfCategoryOfProducts;
import org.junit.jupiter.api.BeforeEach;
import products.Products;
import seeProduct.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestClassForActinsOfProducts {

    private ProductsActions productsActions;

    @BeforeEach
    void setUp(){
        productsActions=mock(ManageProductsActions.class);
    }


    @Test
    void showProductsInCategory_method() {

        final ChoiceProduct choiceProduct = new ChoiceProduct(productsActions);

        List<Products> fakeList=List.of(new Products("TABIAT Tomato Past", 20000),
        new Products("YELLOW Oil", 35000));

        when(choiceProduct.selectionCategory()).thenReturn(fakeList);

        assertThat(choiceProduct.selectionCategory()).isEqualTo(fakeList);
    }

    @Test
    void should_test_exception_of_selectCategory_method() {
        String input = "3\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out=new ByteArrayOutputStream();
         InputAndOutput io = new InputAndOutput(new Scanner(in), new PrintStream(out));

        final ProductsActions manageProductsActions = new ManageProductsActions(io);

        assertThatExceptionOfType(RequestOutsideOfCategoryOfProducts.class).isThrownBy(()
                ->manageProductsActions.getSelectCategory(Products.FoodsTuffs.foodsProducts, Products.SanitaryMaterials.sanitaryProduct));
    }

    @Test
    void test_buySelectedProduct_method_in_BuySelectedProduct_class() {
        final BuySelectedProduct buySelectedProduct = new BuySelectedProduct(productsActions);

        List<Products> fakeList=List.of(new Products("TABIAT Tomato Past", 20000),
                new Products("YELLOW Oil", 35000));
        when(buySelectedProduct.buySelectedProduct()).thenReturn(fakeList.get(1));

        assertThat(buySelectedProduct.buySelectedProduct()).isEqualTo(fakeList.getLast());
    }
}
