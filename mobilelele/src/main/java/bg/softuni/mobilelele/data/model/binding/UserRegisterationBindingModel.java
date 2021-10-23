package bg.softuni.mobilelele.data.model.binding;

import bg.softuni.mobilelele.data.model.validador.UniqueUserName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterationBindingModel {
    @NotNull
    @Size(min = 4,max = 20)
    private String firstName;
    @NotNull
    @Size(min = 4,max = 20)
    private String lastName;
    private String password;
    private String confirmPassword;
    //custom Validator UniqueUserName
    @UniqueUserName
    private String username;

    public String getUsername() {
        return username;
    }

    public UserRegisterationBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterationBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterationBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterationBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterationBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
