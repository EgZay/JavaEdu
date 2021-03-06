package ru.noorsoft.javaeducation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Model model
    ) {
        model.addAttribute("name", name);
        return "greeting";
    }
    @GetMapping("/")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }
    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/user-create")
    public String createUserForm(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser( @Valid @ModelAttribute("user") User user, Errors errors) {
        if (errors.hasErrors()) {
            return "user-create";
        }
       //* userService.saveUser(user);
       userService.add(user);

        return "redirect:/";

    }


    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(@Valid @ModelAttribute("user") User user, Errors errors){
        if (errors.hasErrors()) {
            return "user-update";
        }
        userService.saveUser(user);
        return "redirect:/";
    }




}
