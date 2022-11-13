package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String usersList(ModelMap model) {
        model.addAttribute("users", userService.getList());
        return "users";
    }

    @GetMapping("/user-form")
    public String userForm(ModelMap model, @ModelAttribute User user) {
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/user-add")
    public String saveUser(@ModelAttribute User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/user-delete")
    public String deleteUser(@ModelAttribute User user) {
        userService.delete(user);
        return "redirect:/users";
    }
}
