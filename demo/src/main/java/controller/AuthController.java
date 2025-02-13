package controller;

import service.IAuth;
import service.iplm.AuthServiceIplm;
import view.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthController {
    private IAuth authService = new AuthServiceIplm();
    private Login login;

    public AuthController(Login login) {
        this.login = login;
        initAuthController();
    }

    public void initAuthController() {
        this.login.setBtnSignInAct(new SignIn());
        this.login.checkBoxShowPass();
    }

    private class SignIn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (authService.signIn(login.getUsername(), login.getPassword())) {
                JOptionPane.showMessageDialog(login, "Login is successfully");
            } else {
                JOptionPane.showMessageDialog(login, "Username or password is incorrect");
            }
        }
    }

}
