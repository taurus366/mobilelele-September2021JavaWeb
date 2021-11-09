package bg.softuni.mobilelele.data.service.impl;

import bg.softuni.mobilelele.data.enums.UserRoleEnum;
import bg.softuni.mobilelele.data.model.entity.UserEntity;
import bg.softuni.mobilelele.data.model.entity.UserRoleEntity;
import bg.softuni.mobilelele.data.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.data.model.service.UserRegistrationServiceModel;
import bg.softuni.mobilelele.data.repository.UserRepository;
import bg.softuni.mobilelele.data.repository.UserRoleRepository;
import bg.softuni.mobilelele.data.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void initializeUsers() {

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

        //TODO: register user
    }

    @Override
    public boolean isUsernameFree(String username) {
        return userRepository.findByUsername(username) == null;
    }


}
