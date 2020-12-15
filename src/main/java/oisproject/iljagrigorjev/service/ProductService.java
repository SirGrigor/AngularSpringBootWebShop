package oisproject.iljagrigorjev.service;

import lombok.Data;
import oisproject.iljagrigorjev.model.Product;
import oisproject.iljagrigorjev.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.getOne(id);
    }
}
