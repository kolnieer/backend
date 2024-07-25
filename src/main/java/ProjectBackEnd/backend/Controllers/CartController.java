package ProjectBackEnd.backend.Controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjectBackEnd.backend.DTO.CartDTO;
import ProjectBackEnd.backend.Model.AddOns;
import ProjectBackEnd.backend.Model.Cart;
import ProjectBackEnd.backend.Model.Product;
import ProjectBackEnd.backend.Repository.AddonsRepository;
import ProjectBackEnd.backend.Repository.CartRepository;
import ProjectBackEnd.backend.Repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    AddonsRepository addonsRepository;

    @PostMapping("/new") 
    public String addToCart(@RequestBody CartDTO entity){
        Product product = productRepository.findByProductName(entity.getProductName());
        AddOns addOns = addonsRepository.findByAddOnsId(entity.getAddOnsId());
        Cart cart = new Cart();
        cart.setProduct(Collections.singleton(product));
        cart.setUserId(entity.getUserId());
        cart.setQuantity(entity.getQuantity());
        cartRepository.save(cart);
        return "added to cart";
    }

    @GetMapping("/{userId}")
    public List<Cart> getCartItems(@PathVariable Long userId){
        return cartRepository.findAllByUserId(userId);
    }
    

    

}
