package oisproject.iljagrigorjev.repository;

import oisproject.iljagrigorjev.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
