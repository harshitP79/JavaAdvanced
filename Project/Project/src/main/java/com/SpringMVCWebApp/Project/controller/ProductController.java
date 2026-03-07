package com.SpringMVCWebApp.Project.controller;

import com.SpringMVCWebApp.Project.model.Product;
import com.SpringMVCWebApp.Project.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller //Tells Spring: “This class handles web requests.”
@RequestMapping("/products") //All URLs will start with:
@SessionAttributes("product")
/*This stores product in session during form flow.
Used when: User opens add form, Submits form, If validation fails → form reloads with previous data*/
public class ProductController {

    @Autowired //Dependency Injection/ Constructor Injection
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @ModelAttribute("product")
    public Product getProduct() {
        return new Product();
    }/*This method runs before every request
    It automatically adds model.addAttribute("product", new Product());
    So your form always has an object to bind to.*/

    @GetMapping("/home")
    public String home(){
        return "home";
    } // Returns templates/home.html

    @GetMapping("/list")
    public String viewProducts(Model model){
        model.addAttribute("products",service.getAllProducts());
        return "product-list";
    }//Controller → Service → Repository → List<Product> Then sends list to HTML.


    @GetMapping("/add")
    public String showAddForm(){
        return "product-form";
    }// Just opens form page.

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product,
                              BindingResult result, SessionStatus status){
        if(result.hasErrors()){
            return "product-form";
        }

        service.saveProduct(product);
        status.setComplete();
        return "redirect:/products/list";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model){
        Product product = service.getProductById(id)
                .orElseThrow(() -> new RuntimeException("product not found"));
        model.addAttribute("product",product);
        return "product-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        if(service.getProductById(id).isEmpty()){
            throw new RuntimeException("Cannot Delete. Product not found");
        }
        service.deleteProduct(id);
        return  "redirect:/products/list";
    }

    @GetMapping("/count")
    @ResponseBody
    public String getProductCount(){
        return "Total Products: "+service.getAllProducts().size();
    }

    @ExceptionHandler(RuntimeException.class)
    public  String handleRuntimeException(RuntimeException ex,Model model){
        model.addAttribute("errorMessage", ex.getMessage());
        return "error-page";
    }
}