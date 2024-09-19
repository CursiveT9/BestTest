package com.example.besttest.controllers.view;

import com.example.besttest.dtos.output.UserOutputDTO;
import com.example.besttest.services.UserRoleService;
import com.example.besttest.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.besttest.dtos.UserDTO;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserViewController {

    private UserService userService;
    private UserRoleService userRoleService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @ModelAttribute("userDto")
    public UserDTO initCompany() {
        return new UserDTO();
    }

    @GetMapping("/users")
    public String allUsers(Model model) {
        List<UserOutputDTO> users = userService.getUserOutputDTO();
        model.addAttribute("users", users);
        return "users-all";
    }

    @GetMapping("/user/view/{id}")
    public String userDetails(@PathVariable("id") String id, Model model){
        UserOutputDTO user = userService.getUserOutputDTOById(id);
        model.addAttribute("user",user);
        return "user-details";
    }

    @GetMapping("/user/add")
    public String showAddUser(Model model){
        model.addAttribute("UserDTO", new UserDTO());
        model.addAttribute("roles",userRoleService.findAll());
        return "user-add";
    }

    @PostMapping("/user/add")
    public String addUser(@Valid UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        System.out.println(userDTO.toString());
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userDto", userDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userDto", bindingResult);
            System.out.println(userDTO);
            return "redirect:/user/add";
        }
        userService.createUser(userDTO);
        return "redirect:/users";
    }

    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable("id") String id, Model model) {
        UserDTO user = userService.getUserDTOById(id);
        model.addAttribute("user", user);
        model.addAttribute("roles",userRoleService.findAll());
        return "user-edit";
    }

    @PostMapping("/user/edit/{id}")
    public String editUser(@PathVariable("id") String id, @Valid UserDTO userDTO, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            System.out.println(userDTO.toString());
            redirectAttributes.addFlashAttribute("userDto", userDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userDto", bindingResult);
            return "redirect:/user/edit/" + id;
        }
//        System.out.println(userDTO.toString());
        userService.editUser(id, userDTO);
        return "redirect:/users";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") String id, Model model) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}