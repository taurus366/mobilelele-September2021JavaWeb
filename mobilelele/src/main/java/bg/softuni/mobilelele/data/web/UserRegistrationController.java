package bg.softuni.mobilelele.data.web;

import bg.softuni.mobilelele.data.model.binding.UserRegisterationBindingModel;
import bg.softuni.mobilelele.data.model.service.UserRegistrationServiceModel;
import bg.softuni.mobilelele.data.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserRegistrationController {

    private final UserService userService;
    private final ModelMapper modelMapper;
//    private final Model model;

    public UserRegistrationController(UserService userService, ModelMapper modelMapper
//            , Model model
    ) {
        this.userService = userService;
        this.modelMapper = modelMapper;
//        this.model = model;
    }

    @GetMapping("/users/register")
    public String registerUser() {

        return "auth-register";
    }

    @ModelAttribute("userModel")
    public UserRegisterationBindingModel userRegisterationBindingModel() {
        return new UserRegisterationBindingModel();
    }

    /*    @VALID validate the UserRegisterationBindingModel parameters like @Size or @NotNull and etc.
          BindingResult works together with @Valid
          RedirectAttributes has addFlashAttribute it saves the attribute after redirect.
     */
    @PostMapping("/users/register")
    public String registerNewUser(@Valid UserRegisterationBindingModel userModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        //TODO: validation

        if (bindingResult.hasErrors() || !userModel.getPassword().equals(userModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/register";
        }

        UserRegistrationServiceModel serviceModel = modelMapper.map(userModel, UserRegistrationServiceModel.class);
        //TODO: add with flash attribute
//        if (!userService.isUsernameFree(serviceModel.getUsername())) {
//            System.out.println("username exists");
////            model.addAttribute("userNameNotFree", true);
//            return "redirect:/users/register";
//        } else {
//            System.out.println("username is not exists!");
//        }
        userService.registerAndLoginUser(serviceModel);

        return "redirect:/";
    }


}
