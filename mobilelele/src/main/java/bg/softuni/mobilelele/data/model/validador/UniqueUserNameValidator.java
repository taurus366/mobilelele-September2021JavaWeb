package bg.softuni.mobilelele.data.model.validador;

import bg.softuni.mobilelele.data.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName,String> {

    private UserService userService;

    public UniqueUserNameValidator(UserService userService){

        this.userService = userService;
    }

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext context) {
        if (userName == null){
            return true;
        }
        return userService.isUsernameFree(userName);
    }
}
