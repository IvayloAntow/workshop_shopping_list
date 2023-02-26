package com.example.prep.web;




import com.example.prep.model.entity.enums.CategoriesEnum;
import com.example.prep.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {

        if(httpSession.getAttribute("user") == null){
            return "index";
        }

       model.addAttribute("totalSum", productService.getTotalSum());
        model.addAttribute("drinks", productService.findAllProductsByCategory(CategoriesEnum.DRINK));
        model.addAttribute("food",productService.findAllProductsByCategory(CategoriesEnum.FOOD));
        model.addAttribute("households", productService.findAllProductsByCategory(CategoriesEnum.HOUSEHOLD));
        model.addAttribute("others", productService.findAllProductsByCategory(CategoriesEnum.OTHER));


        return "home";

    }


}
