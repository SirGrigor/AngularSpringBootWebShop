package oisproject.iljagrigorjev.contoller;

import oisproject.iljagrigorjev.model.Product;
import oisproject.iljagrigorjev.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/home")
    public String getAllProducts(Model model) {
        model.addAttribute("productList", productService.getAllProducts());
        return "home";
    }

    @RequestMapping(value = "/add-product")
    public String showAddProductForm(Model model) {
        model.addAttribute("command", new Product());
        return "add-product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/home";
    }
}
