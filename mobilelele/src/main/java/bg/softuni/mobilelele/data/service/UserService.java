package bg.softuni.mobilelele.data.service;

import bg.softuni.mobilelele.data.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.data.model.service.UserRegistrationServiceModel;

public interface UserService {

     void initializeUsers();

     boolean login(UserLoginServiceModel userLoginServiceModel);

     void logOut();

     void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);

     boolean isUsernameFree(String username);
}
