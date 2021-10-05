package bg.softuni.mobilelele.data.service.impl;

import bg.softuni.mobilelele.data.model.entity.UserEntity;
import bg.softuni.mobilelele.data.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.data.repository.UserRepository;
import bg.softuni.mobilelele.data.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        //TODO - login the user

        Optional<UserEntity> byUsername =
                userRepository.findByUsername(userLoginServiceModel.getUsername());

        if (byUsername.isEmpty()) {
            return false;
        } else {
           return passwordEncoder
                   .matches(
                           userLoginServiceModel.getRawPassword(),
                           byUsername.get().getPassword());
        }

//        throw new UnsupportedOperationException("No implemented YET!");
//        return false;
    }
}
