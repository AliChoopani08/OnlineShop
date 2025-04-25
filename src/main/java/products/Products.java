package products;



import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Products implements ProductsCategory {
   public  String nameOfProduct;
   public  int priceOfProduct;

    public Products(String nameOfProduct, int priceOfProduct) {
       this.nameOfProduct = nameOfProduct;
        this.priceOfProduct = priceOfProduct;
    }


    public static void addProducts(List<Products>products , String nameOfProduct, int priceOfProduct) {
        Products product = new Products(nameOfProduct, priceOfProduct);
        products.add(product);
    }

    @Override
    public void addProducts(PrintStream output) {

    }

    @Override
    public String toString() {
        return
                ", name Of Product='" + nameOfProduct + '\'' +
                " ,  price Of Product=" + priceOfProduct  +
                '}' + "\n";
    }



    public static class FoodsTuffs  implements ProductsCategory {
        public static List<Products>foodsProducts=new LinkedList<>();

        @Override
        public void addProducts(PrintStream output) {
            if (foodsProducts.isEmpty()) {
                Products.addProducts(foodsProducts, "TABIAT Tomato Past", 20000);
                Products.addProducts(foodsProducts, "YELLOW Oil", 35000);
                Products.addProducts(foodsProducts, "COCOA Cake", 15000);
                Products.addProducts(foodsProducts, "FRESH Yogurt", 28000);
                Products.addProducts(foodsProducts, "ZAR Macaroni", 26000);
            }
            for (Products product : foodsProducts) {
                output.println(product);
        }
    }
    }


   public static class SanitaryMaterials  implements ProductsCategory {
       public static LinkedList<Products>sanitaryProduct=new LinkedList<>();
       @Override
       public void addProducts(PrintStream output) {
           if (sanitaryProduct.isEmpty()) {
               Products.addProducts(sanitaryProduct, "GOLRANG Soap", 42000);
               Products.addProducts(sanitaryProduct, "SEHAT Shampoo", 37000);
               Products.addProducts(sanitaryProduct, "TENO Napkin", 27000);
           }
            for (Products product : sanitaryProduct) {
                output.println(product);
            }

       }
   }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return priceOfProduct == products.priceOfProduct && Objects.equals(nameOfProduct, products.nameOfProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfProduct, priceOfProduct);
    }
}

