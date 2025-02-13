package service.iplm;

import model.User;
import service.IUser;

import java.util.ArrayList;
import java.util.List;

public class UserServiceIplm implements IUser {
    public List<User> users = new ArrayList<>();


    @Override
    public boolean addUser(User user) {
        if (users.contains(user)) {
            return false;
        }
        else users.add(user);
        return true;
    }

    @Override
    public boolean changeInfoUser() {
        return false;
    }

    @Override
    public boolean deleteUser() {
        return false;
    }

    @Override
    public List<User> getAllUser() {
        return users;
    }


}
