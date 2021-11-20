package bg.softuni.errors.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Product not found!")
public class ProductNotFoundException extends RuntimeException {

    private final Long productId;
    public ProductNotFoundException(Long productID) {
        super("Cannot find product with id " + productID);
        this.productId = productID;
    }

    public Long getProductId() {
        return productId;
    }

    //    public ProductNotFoundException(String message) {
//        super(message);
//    }

}
