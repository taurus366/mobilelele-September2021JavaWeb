package bg.softuni.errors.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @GetMapping("/products/{id}/details")
    public String showProductDetails(@PathVariable Long id) {
        // retrieve product from repository
        // productRepository.findByID(id).orElseThrow(new ProductNotFoundException());
        throw new ProductNotFoundException(id);
    }

    @GetMapping("/products/{id}/error")
    public String boom(@PathVariable Long id) {

        throw new NullPointerException();
    }

    @ExceptionHandler({ProductNotFoundException.class})
    public ModelAndView handleDbExceptions(ProductNotFoundException e){
        ModelAndView modelAndView = new ModelAndView("product-not-found");
        modelAndView.addObject("message", e.getMessage());
        modelAndView.addObject("productId", e.getProductId());

        return modelAndView;
    }
}
