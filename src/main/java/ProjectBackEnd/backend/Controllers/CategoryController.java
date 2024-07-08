package ProjectBackEnd.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ProjectBackEnd.backend.Model.Category;
import ProjectBackEnd.backend.NotFoundException.CategoryNotFoundException;
import ProjectBackEnd.backend.Repository.CategoryRepository;

@RestController
public class CategoryController {

    CategoryRepository repo;

    public CategoryController(CategoryRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return repo.findAll();
    }

    @GetMapping("/category/{id}")
    public Category gCategory(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new CategoryNotFoundException(id));
    }

    @PostMapping("/category/new")
    public String addCategory(@RequestBody Category newproductCategory){
        repo.save(newproductCategory);
        return "A new category has been added!";
    }

    @PutMapping("/category/edit/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category newproductCategory){
        return repo.findById(id)
        .map(category -> {
            category.setproductCategory(newproductCategory.getproductCategory());
            return repo.save(category);
        }).orElseGet(()->{
            return repo.save(newproductCategory);
        });
    }

    @DeleteMapping("/category/delete/{id}")
    public String deleteproductCategory(@PathVariable Long id){
        repo.deleteById(id);
        return "A category has been deleted";
    }

}