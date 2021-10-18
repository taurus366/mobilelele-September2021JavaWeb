package bg.softuni.mobilelele.data.service.impl;

import bg.softuni.mobilelele.data.enums.UserRoleEnum;
import bg.softuni.mobilelele.data.model.entity.UserEntity;
import bg.softuni.mobilelele.data.model.entity.UserRoleEntity;
import bg.softuni.mobilelele.data.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.data.model.service.UserRegistrationServiceModel;
import bg.softuni.mobilelele.data.repository.UserRepository;
import bg.softuni.mobilelele.data.repository.UserRoleRepository;
import bg.softuni.mobilelele.data.service.UserService;
import bg.softuni.mobilelele.data.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser, UserRoleRepository userRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void initializeUsers() {

    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        //TODO - login the user

//        Optional<UserEntity> userEntityOpt =
        UserEntity byUsername = userRepository.findByUsername(userLoginServiceModel.getUsername());

//        if (userEntityOpt.isEmpty()) {
        if (byUsername == null) {
            logOut();
            return false;
        } else {
           boolean success = passwordEncoder
                   .matches(
                           userLoginServiceModel.getRawPassword(),
                           byUsername.getPassword());

           if (success){
//               UserEntity loggedInUser = userEntityOpt.get();
            login(byUsername);

               byUsername.getRoles()
                        .forEach(r -> currentUser.addRole(r.getRole()));

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

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel) {

        UserRoleEntity userRole = userRoleRepository.findByRole(UserRoleEnum.USER);


        UserEntity newUser = new UserEntity();
        newUser.setUsername(userRegistrationServiceModel.getUsername())
                .setFirstName(userRegistrationServiceModel.getFirstName())
                .setLastName(userRegistrationServiceModel.getLastName())
                .setPassword(passwordEncoder.encode(userRegistrationServiceModel.getPassword()))
                .setRoles(List.of(userRole))
        .setActive(true);

        userRepository.save(newUser);
        login(newUser);
    }

    @Override
    public boolean isUsernameFree(String username) {
        return userRepository.findByUsername(username) == null;
    }

    private void login(UserEntity user){
        currentUser
                .setLoggedIn(true)
                .setUserName(user.getUsername())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName());

    }
}
