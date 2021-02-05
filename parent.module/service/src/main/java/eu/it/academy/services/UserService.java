package eu.it.academy.services;

import eu.it.academy.dao.UserDao;
import eu.it.academy.entity.User;

public class UserService {

    UserDao dao = new UserDao();
    
    User user = new User("Ivan", 26);
}
