package service;

import model.User;

import java.util.List;

public interface IUser {

    public boolean addUser(User user);

    public boolean changeInfoUser();

    public boolean deleteUser();

    public List<User> getAllUser();
}
