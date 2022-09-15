package demo.service;
import demo.entity.Product;
import demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product getProductById(Long productId){
        return productRepository.findById(productId).get();
    }

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProductById(Long productId){
        productRepository.deleteById(productId);
    }
    public List<Product> getExAllExp(Date lastUseDate){
        return productRepository.findByLast_use_dateBeforeOrderById(lastUseDate);
    }
    public List<Product> getNotExAllExp(Date lastUseDate){
        return productRepository.findByLast_use_dateAfterOrLast_use_dateNullOrderById(lastUseDate);
    }

}
