package service.iplm;

import model.User;
import service.IAuth;
import service.IUser;

import static common.EcryptionPassword.checkPassword;

public class AuthServiceIplm implements IAuth {
    private IUser userService = new UserServiceIplm();
    @Override
    public boolean signIn(String username, String password) {
        for (User user:userService.getAllUser()) {
            if (!(user.getUsername().equals(username)) && !(checkPassword(password,user.getPassword()))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean signUp(User user) {
            for (User u:userService.getAllUser()) {
                if (!user.getUsername().equals(u.getUsername()) && !user.getEmail().equals(u.getEmail()) && !user.getId().equals(u.getId())) {
                    userService.addUser(user);
                    return true;
                }
            }
            return false;
    }
}
