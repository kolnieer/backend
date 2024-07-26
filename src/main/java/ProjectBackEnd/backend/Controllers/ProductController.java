package ProjectBackEnd.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjectBackEnd.backend.Model.Product;
import ProjectBackEnd.backend.NotFoundException.ProductNotFoundException;
import ProjectBackEnd.backend.Repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    ProductRepository repo;
    
    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<Product> getProducts(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new ProductNotFoundException(id));
    
    }

    @PostMapping("/new")
    public String addProduct(@RequestBody Product newProduct){
        repo.save(newProduct);
        return "A new product is added. YEY!";
    }

    @PutMapping("/edit/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product newProduct){
        return repo.findById(id)
        .map(product -> {
            product.setProductName(newProduct.getProductName());
            product.setDescription(newProduct.getDescription());
            product.setSmallPrice(newProduct.getSmallPrice());
            product.setLargePrice(newProduct.getLargePrice());
            product.setImageUrl(newProduct.getImageUrl());
            return repo.save(product);
        }).orElseGet(()->{
            return repo.save(newProduct);
        });
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        repo.deleteById(id);
        return "A product has been deleted!";
    }

}

