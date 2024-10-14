package ie.atu.week3cicd;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class productController {
    private List<product> productList = new ArrayList<>();

    public productController(){
        productList.add(new product("1","TV","Electronics",600.0));
        productList.add(new product("2","Phone","Electronics",500.0));
    }

    @GetMapping
    public List<product> getAllProducts(){
        return productList;
    }

    @PostMapping
    public product addProduct(@RequestBody product newProduct){
        productList.add(newProduct);
        return newProduct;
    }

    @PutMapping("/{id}")
    public product updateProduct(@PathVariable("id") String id, @RequestBody product updatedProduct) {
        for (product prod : productList) {
            if (prod.getId().equals(id)) {
                prod.setName(updatedProduct.getName());
                prod.setCategory(updatedProduct.getCategory());
                prod.setPrice(updatedProduct.getPrice());
                return prod;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") String id) {
        for (product p : productList) {
            if (p.getId().equals(id)) {
                productList.remove(p);
                return "Product with ID " + id + " has been deleted.";
            }
        }
        return id + " not found.";
    }


}
