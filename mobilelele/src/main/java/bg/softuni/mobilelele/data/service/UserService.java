package bg.softuni.mobilelele.data.service;

import bg.softuni.mobilelele.data.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.data.model.service.UserRegistrationServiceModel;

public interface UserService {

     void initializeUsers();

     void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);

     boolean isUsernameFree(String username);
}
