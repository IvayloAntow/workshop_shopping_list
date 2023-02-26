package com.example.prep.web;

import com.example.prep.model.binding.UserLoginBindingModel;
import com.example.prep.model.binding.UserRegisterBindingModel;
import com.example.prep.model.service.UserServiceModel;
import com.example.prep.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model){

        if (!model.containsAttribute("userRegisterBindingModel")){
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
            model.addAttribute("isExists", false);
        }

        return "register" ;
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){

         boolean isValidPassword = userRegisterBindingModel
                .getPassword().equals(userRegisterBindingModel.getConfirmPassword());



        if (bindingResult.hasErrors() || !isValidPassword ){
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                    bindingResult);


            return "redirect:register";
        }

        boolean isSaved = userService.register(modelMapper
                .map(userRegisterBindingModel , UserServiceModel.class));
        if (!isSaved){
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("isExists", true);

            return "redirect:register";
        }

        return "redirect:/login";

    }
    @GetMapping("/login")
    public String login(Model model){
        if (!model.containsAttribute("userLoginBindingModel")){
            model.addAttribute("userLoginBindingModel" , new UserLoginBindingModel());
            model.addAttribute("notFound" , false);
        }

        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel
    , BindingResult bindingResult, RedirectAttributes redirectAttributes,
                               HttpSession httpSession){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                    bindingResult);

            return "redirect:login";
        }

        UserServiceModel userServiceModel = userService
                .findByUsernameAndPassword(userLoginBindingModel.getUsername()
                , userLoginBindingModel.getPassword());

        if (userServiceModel == null){
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("notFound" , true);
            return "redirect:/login";
        }

        httpSession.setAttribute("user" , userServiceModel);

        return "redirect:/";

    }

    @GetMapping("/logout")
    public String Logout(HttpSession httpSession){
        httpSession.invalidate();

        return "redirect:/";
    }

}
