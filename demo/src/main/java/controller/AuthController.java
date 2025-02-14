package controller;

import common.EcryptionPassword;
import model.User;
import respone.OTPCodeRespone;
import service.IAuth;
import service.IEmail;
import service.IOTPService;
import service.iplm.AuthServiceIplm;
import service.iplm.EmailServiceIplm;
import service.iplm.OTPServiceIplm;
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
    private OTPCodeRespone otpCodeRespone;

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
        this.login.setLabelRegister(new SignUpView());
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
        SignUp signUp = new SignUp();
        this.register.setBtnBackAct(e -> back());
        this.register.setBtnSignInAct(e -> signUp.confirmSignUp());
        this.register.setBtnGetOTPAct(e -> signUp.getOTP());
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

    private class SignUpView implements MouseListener,ActionListener {

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


        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class SignUp {

        IEmail emailSerivce = new EmailServiceIplm();
        IOTPService otpService = new OTPServiceIplm();
        public void getOTP() {
            otpCodeRespone = emailSerivce.sendMail(register.getEmail());
        }

        public void confirmSignUp() {
            if (register.getUsername().isBlank() || register.getPassword().isBlank() || register.getEmail().isBlank() || register.getOTP().isBlank() || register.getRepeatPassword().isBlank()){
                JOptionPane.showMessageDialog(register, "Please fill full out complete information");
            }
            else {
                if (otpService.checkOTP(otpCodeRespone, register.getOTP())) {
                    User user = User.builder()
                            .name(register.getFullName())
                            .email(register.getEmail())
                            .username(register.getUsername())
                            .password(EcryptionPassword.hashPassword(register.getPassword()))
                            .build();
                    authService.signUp(user);
                    JOptionPane.showMessageDialog(register,"Register account is successfully");
                } else {
                    System.out.println(otpCodeRespone.getOtpCode());
                    JOptionPane.showMessageDialog(register, "OTP Code is incorrect");
                }
            }

        }


    }

    private void back() {
        register.dispose();
    }



}
