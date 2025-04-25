package seeProduct;

import example.InputAndOutput;
import products.Products;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static example.ConsoleColor.*;

public class ManageProductsActions implements ProductsActions{

    InputAndOutput io;

    public ManageProductsActions(InputAndOutput io) {
        this.io = io;
    }

    @Override
    public List<Products> getSelectCategory( List<Products> foodsProducts, List<Products> sanitaryProduct) {
        List<Products> selectedCategory=new LinkedList<>();
                io.println(GREEN + "Which category do want to go to ?" + RESET);
        io.println(BLUE + "1.FoodsTurfs  ,  2.SanitaryMaterials" + RESET);
      int answer;
      while (true){
          io.println(YELLOW + "Select your choice category......" + RESET);
          answer=io.nextInt();
          if (answer==1 || answer==2)
              break;
          else
              io.println(RED + "Your input is invalid !! \n Please try again....." + RESET);
      }
      switch (answer){
          case 1:
            io.println("Entered to FoodsTurfs");
            new Products.FoodsTuffs().addProducts(io.printStream);
            selectedCategory.addAll(foodsProducts);
            break;
          case 2:
            io.println("Entered to SanitaryMaterials");
            new Products.SanitaryMaterials().addProducts(io.printStream);
            selectedCategory.addAll(sanitaryProduct);
              break;
      }
      return selectedCategory;
    }

    @Override
    public Products buySelectedProduct(List<Products> products) {
            io.println(YELLOW + "Please choice your desire product for buying.... " + RESET);
            io.nextLine();
            try {
                String choicePerson = io.nextLine();

                Optional<Products> findProduct = products.stream()
                        .filter(p ->
                                p.nameOfProduct.equalsIgnoreCase(choicePerson))
                        .findFirst();
                findProduct.ifPresentOrElse(product -> io.println("Product found." + "  name of product : " + product.nameOfProduct),
                        () -> io.logger.severe(RED + "Product there's no !! " + RESET)
                );
                findProduct.ifPresent(products::remove);
                io.println("Available products : " + products);
                return findProduct.orElse(null);
            }catch (InputMismatchException e){
                io.logger.warning("Your input is invalid !!");
                throw e;
            }
        }
    }
