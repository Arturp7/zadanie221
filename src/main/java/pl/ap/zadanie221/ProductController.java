package pl.ap.zadanie221;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @RequestMapping("/add")
    public String hello(@RequestParam String name, @RequestParam double price, @RequestParam Category category) {

        Product product = new Product(name, price, category);
        productRepository.add(product);
        return "redirect:/list";
    }

    @ResponseBody
    @RequestMapping("/list")
    public String list(@RequestParam (required = false)Category category) {
        List<Product> productsList = productRepository.getAll();
        String result = "";
        double price = 0;
        double totalPrice = 0;
        for (Product product1 : productsList) {
            if (product1.getCategory().equals(category)) {
                result += product1.getName() + "  " + product1.getPrice() + "  " + product1.getCategory() + "<br/>";
                price = price + product1.getPrice();
            }
            totalPrice = price;

        }

        return result + "Suma cen produktów   " + totalPrice;

//, defaultValue = " "

    }


}
