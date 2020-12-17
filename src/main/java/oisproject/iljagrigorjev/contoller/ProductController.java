package oisproject.iljagrigorjev.contoller;

import oisproject.iljagrigorjev.model.Product;
import oisproject.iljagrigorjev.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value="/home")
    public String getAllProducts(Model model) {
        model.addAttribute("productList",  productService.getAllProducts());
        return "home";
    }

    @RequestMapping(value="/add-product")
    public String showAddProductForm(Model model) {
        model.addAttribute("command", new Product());
        return "add-product";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/home";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Long id) {
        Product product = productService.getProduct(id);
        productService.deleteProduct(product);
        return "redirect:/home";
    }

    @RequestMapping(value = "/product/{id}")
    public String getOneProduct(@PathVariable Long id, Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "product-view";
    }
    @RequestMapping(value = "/product/editsave", method = RequestMethod.POST)
    public String saveEditProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/product/" + product.getId();
    }
}
