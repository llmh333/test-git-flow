package service;

import model.User;

public interface IAuth {

    public boolean signIn(String username, String password);

    public boolean signUp(User user);
}
