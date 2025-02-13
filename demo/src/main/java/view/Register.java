package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static common.FontView.fontLabel;

public class Register extends JFrame {
    private JPanel panelScreen;
    private JTextField txtUsername;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtOTP;
    private JPasswordField txtPassword;
    private JPasswordField txtRepeatPassword;
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JLabel labelRepeatPassword;
    private JLabel labelName;
    private JLabel labelEmail;
    private JLabel labelOTP;
    private JButton btnSignIn;
    private JButton btnBack;
    private JButton btnGetOTP;
    private JCheckBox boxShowPassword;

    public void addFormRegister() {
        panelScreen = new JPanel();
        panelScreen.setLayout(null);
        panelScreen.setBounds(0,0,this.getWidth(), this.getHeight());

        labelUsername = new JLabel("Username");
        labelUsername.setFont(fontLabel);
        labelUsername.setBounds(100,50,100,30);

        txtUsername = new JTextField();
        txtUsername.setBounds(100,82,400,40);

        labelPassword = new JLabel("Password");
        labelPassword.setFont(fontLabel);
        labelPassword.setBounds(100,132,100,30);


        txtPassword = new JPasswordField();
        txtPassword.setBounds(100,164,400,40);

        labelRepeatPassword = new JLabel("Repeat password");
        labelRepeatPassword.setFont(fontLabel);
        labelRepeatPassword.setBounds(100,214,150,30);

        txtRepeatPassword = new JPasswordField();
        txtRepeatPassword.setBounds(100,246,400,40);

        boxShowPassword = new JCheckBox("Show password");
        boxShowPassword.setFont(new Font("Time New Romans", Font.PLAIN, 12));
        boxShowPassword.setBounds(100,288,120,20);

        labelName = new JLabel("Full name");
        labelName.setFont(fontLabel);
        labelName.setBounds(100,318,100,30);

        txtName = new JTextField();
        txtName.setBounds(100,350,400,40);

        labelEmail = new JLabel("Email");
        labelEmail.setFont(fontLabel);
        labelEmail.setBounds(100,400,100,30);

        txtEmail = new JTextField();
        txtEmail.setBounds(100,432,260,40);

        btnGetOTP = new JButton("Get OTP Code");
        btnGetOTP.setFont(new Font("Time New Romans", Font.PLAIN, 12));
        btnGetOTP.setBounds(370,432,130,40);
        btnGetOTP.setFocusPainted(false);

        labelOTP = new JLabel("OTP");
        labelOTP.setFont(fontLabel);
        labelOTP.setBounds(100,482,50,30);

        txtOTP = new JTextField();
        txtOTP.setBounds(100,514,150,40);

        btnSignIn = new JButton("Sign Up");
        btnSignIn.setFont(new Font("Time New Romans", Font.BOLD, 12));
        btnSignIn.setBounds(100,574 , 400, 40);
        btnSignIn.setFocusPainted(false);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Time New Romans", Font.BOLD, 12));
        btnBack.setFocusPainted(false);
        btnBack.setBounds(2,2,70,40);

        panelScreen.add(labelUsername);
        panelScreen.add(labelPassword);
        panelScreen.add(txtUsername);
        panelScreen.add(txtPassword);
        panelScreen.add(labelRepeatPassword);
        panelScreen.add(txtRepeatPassword);
        panelScreen.add(labelEmail);
        panelScreen.add(txtEmail);
        panelScreen.add(labelName);
        panelScreen.add(txtName);
        panelScreen.add(labelOTP);
        panelScreen.add(txtOTP);
        panelScreen.add(boxShowPassword);
        panelScreen.add(btnSignIn);
        panelScreen.add(btnGetOTP);
        panelScreen.add(btnBack);

        this.add(panelScreen);
    }

    public String getUsername() {
        return txtUsername.getText();
    }

    public String getPassword() {
        return txtPassword.getText();
    }

    public String getEmail() {
        return txtEmail.getText();
    }

    public String getFullName() {
        return txtName.getText();
    }

    public String getOTP() {
        return txtOTP.getText();
    }

    public String getRepeatPassword() {
        return txtRepeatPassword.getText();
    }
    public void checkBoxShowPass() {
        if (!boxShowPassword.isSelected()) {
            txtPassword.setEchoChar('*');
            txtRepeatPassword.setEchoChar('*');
        }
        else
        {
            txtPassword.setEchoChar((char) 0);
            txtRepeatPassword.setEchoChar((char) 0);
        }
    }
    public void setBtnSignInAct(ActionListener listener) {
        btnSignIn.addActionListener(listener);
    }

    public void setBtnGetOTPAct(ActionListener listener) {
        btnGetOTP.addActionListener(listener);
    }

    public void setBtnBackAct(ActionListener listener) {
        btnBack.addActionListener(listener);
    }

    public Register() {
        this.setSize(new Dimension(600,750));
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        addFormRegister();
    }
    public static void main(String[] args) {
        new Register().setVisible(true);
    }
}
