package bg.softuni.mobilelele.data.service.impl;

import bg.softuni.mobilelele.data.model.entity.UserEntity;
import bg.softuni.mobilelele.data.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.data.repository.UserRepository;
import bg.softuni.mobilelele.data.service.UserService;
import bg.softuni.mobilelele.data.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void initializeUsers() {

    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        //TODO - login the user

        Optional<UserEntity> userEntityOpt =
                userRepository.findByUsername(userLoginServiceModel.getUsername());

        if (userEntityOpt.isEmpty()) {
            logOut();
            return false;
        } else {
           boolean success = passwordEncoder
                   .matches(
                           userLoginServiceModel.getRawPassword(),
                           userEntityOpt.get().getPassword());

           if (success){
               UserEntity loggedInUser = userEntityOpt.get();
               currentUser.setLoggedIn(true).setUserName(loggedInUser.getUsername()).setFirstName(loggedInUser.getFirstName()).setLastName(loggedInUser.getLastName());
           }

           return success;
        }
//        throw new UnsupportedOperationException("No implemented YET!");
//        return false;
    }

    @Override
    public void logOut() {
        currentUser.clean();
    }
}
