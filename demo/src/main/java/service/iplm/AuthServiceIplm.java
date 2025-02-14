package service.iplm;

import model.User;
import service.IAuth;
import service.IUser;

import java.util.ArrayList;
import java.util.List;

import static common.EcryptionPassword.checkPassword;

public class AuthServiceIplm implements IAuth {
    private IUser userService = new UserServiceIplm();
    @Override
    public boolean signIn(String username, String password) {
        System.out.println(userService.getAllUser());
        for (User user:userService.getAllUser()) {
            if ((user.getUsername().equals(username)) && (checkPassword(password,user.getPassword()))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean signUp(User newUser) {
        List<User> users = new ArrayList<>();
        users = userService.getAllUser();
        User username = users.stream().filter(user -> user.getUsername().equals(newUser.getUsername())).findFirst().orElse(null);
        User email = users.stream().filter(user -> user.getEmail().equals(newUser.getEmail())).findFirst().orElse(null);
        if(username == null && email == null) {
            newUser.setId(String.valueOf(users.size()+1));
            userService.addUser(newUser);
            System.out.println(users);
            return true;
        }
        return false;
    }
}
