package bg.softuni.mobilelele.data.service;

import bg.softuni.mobilelele.data.model.service.UserLoginServiceModel;

public interface UserService {

     void initializeUsers();

     boolean login(UserLoginServiceModel userLoginServiceModel);

     void logOut();
}
