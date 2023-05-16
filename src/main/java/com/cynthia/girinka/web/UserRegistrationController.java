package com.cynthia.girinka.web;

import com.cynthia.girinka.service.UserService;
import com.cynthia.girinka.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    //call the service not using @Autowired but constructor
    private UserService userService;
    public UserRegistrationController(UserService userService){
        super();
        this.userService = userService;
    }

    //SAVE from registration form
    @ModelAttribute("user") //returns user object from registration page intead of using the model.addAttribute Model model
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping //mapping from register page
    public String showRegistrationForm() {
        return "registration";
    }
    @PostMapping //register button?
    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }


}
