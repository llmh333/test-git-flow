package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Login extends JFrame {

    private JPanel panelScreen;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JButton btnSignIn;
    private JCheckBox boxShowPassword;
    private JLabel labelRegister;

    public void addFormLogin() {
        panelScreen = new JPanel();
        panelScreen.setLayout(null);
        panelScreen.setBounds(0,0,600,600);

        labelUsername = new JLabel("Username");
        labelUsername.setFont(new Font("Time New Romans", Font.BOLD, 14));
        labelUsername.setBounds(100,100,400,30);

        txtUsername = new JTextField();
        txtUsername.setBounds(100,132,400,40);

        labelPassword = new JLabel("Password");
        labelPassword.setFont(new Font("Time New Romans", Font.BOLD, 14));
        labelPassword.setBounds(100,190,400,30);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(100,222,400,40);

        boxShowPassword = new JCheckBox("Show password");
        boxShowPassword.setFont(new Font("Time New Romans", Font.PLAIN, 12));
        boxShowPassword.setBounds(100,264,120,20);

        btnSignIn = new JButton("Sign In");
        btnSignIn.setFont(new Font("Time New Romans", Font.BOLD, 12));
        btnSignIn.setBounds(100,320 , 400, 30);
        btnSignIn.setFocusPainted(false);

        labelRegister = new JLabel("I haven't account? Register now");
        labelRegister.setFont(new Font("Time New Romans", Font.PLAIN,10));
        labelRegister.setForeground(Color.blue);
        labelRegister.setBounds(100,352,200,15);

        panelScreen.add(labelUsername);
        panelScreen.add(labelPassword);
        panelScreen.add(txtUsername);
        panelScreen.add(txtPassword);
        panelScreen.add(boxShowPassword);
        panelScreen.add(btnSignIn);
        panelScreen.add(labelRegister);
        this.add(panelScreen);
    }

    public String getUsername() {
        return txtUsername.getText();
    }

    public String getPassword() {
        return txtPassword.getText();
    }

    public void checkBoxShowPass() {
        if (!boxShowPassword.isSelected()) {
            txtPassword.setEchoChar('*');
        }
        else txtPassword.setEchoChar((char) 0);
    }
    public void setBtnSignInAct(ActionListener listener) {
        btnSignIn.addActionListener(listener);
    }

    public void setLabelRegister(MouseListener listener) {
        labelRegister.addMouseListener(listener);
    }



    public Login() {
        this.setSize(new Dimension(600,600));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("My App");
        addFormLogin();
    }

    public static void main(String[] args) {
        new Login();
    }
}
