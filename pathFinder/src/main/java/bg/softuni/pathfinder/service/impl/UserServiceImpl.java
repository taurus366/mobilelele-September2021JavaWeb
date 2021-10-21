package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.model.entity.enums.LevelEnum;
import bg.softuni.pathfinder.model.service.UserServiceModel;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final CurrentUser currentUser;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(CurrentUser currentUser, UserRepository userRepository, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {

        User user = modelMapper.map(userServiceModel,User.class);
        user.setLevel(LevelEnum.BEGINNER);

        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username,password)
                .map(user -> modelMapper.map(user,UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        System.out.println("logged user");
            currentUser.setUsername(username)
                    .setId(id);

    }

    @Override
    public void logout() {
        currentUser.setUsername(null)
                .setId(null);
    }

    @Override
    public Object findById(Long id) {
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user,UserServiceModel.class))
                .orElse(null);
    }



    @Override
    public boolean isNameExists(String username) {
        return userRepository
                .findByUsername(username)
                .isPresent();
    }
}
