package demo.controller;

import demo.entity.Product;
import demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> allProduct = productService.getAllProduct();
        return new ResponseEntity<List<Product>>(allProduct, HttpStatus.OK);
    }

    @GetMapping("/exallExp")
    public ResponseEntity<List<Product>> getExpDateAll(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        List<Product> allProduct = productService.getExAllExp(java.sql.Date.valueOf(formatter.format(date)));
        return new ResponseEntity<List<Product>>(allProduct, HttpStatus.OK);
    }
    @GetMapping("/notExallExp")
    public ResponseEntity<List<Product>> getNotExpDateAll(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        List<Product> allProduct = productService.getNotExAllExp(java.sql.Date.valueOf(formatter.format(date)));
        return new ResponseEntity<List<Product>>(allProduct, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(name = "id") Long productId){
        Product product = productService.getProductById(productId);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProductById(@RequestBody Product product){
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable(name = "id") Long productId){
        productService.deleteProductById(productId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }


}
