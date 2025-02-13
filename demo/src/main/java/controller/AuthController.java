package controller;

import service.IAuth;
import service.iplm.AuthServiceIplm;
import view.Login;
import view.Register;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AuthController {
    private IAuth authService = new AuthServiceIplm();
    private Login login;
    private Register register;

    public AuthController(Login login) {
        this.login = login;
        initLogin();
    }

    public AuthController(Register register) {
        this.register = register;
        initRegister();
    }

    public void initLogin() {
        showLogin();
        this.login.setBtnSignInAct(new SignIn());
        this.login.checkBoxShowPass();
        this.login.setLabelRegister(new SignUp());
    }

    public void showLogin() {
        if (this.login != null) {
            this.login.setVisible(true);
        }
    }

    public void showRegister() {
        if (this.register != null) {
            this.register.setVisible(true);
        }
    }
    public void initRegister() {
        showRegister();
        this.register.setBtnBackAct(e -> back());
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

    private class SignUp implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            Register register = new Register();
            AuthController authController = new AuthController(register);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private void back() {
        register.dispose();
    }

}
