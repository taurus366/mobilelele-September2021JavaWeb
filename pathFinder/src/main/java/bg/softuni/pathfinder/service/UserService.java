package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel map);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logout();

    Object findById(Long id);

    boolean isNameExists(String username);
}
