package exceptions;

public class RequestOutsideOfCategoryOfProducts extends RuntimeException{
    public RequestOutsideOfCategoryOfProducts(String message) {
        super(message);
    }
}
