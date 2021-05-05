package ru.ui;
import ru.util.BaseForm;
import javax.swing.*;

public class LoginForm extends BaseForm {
    private JPanel mainForm;
    private JTextField nameForm;
    private JPasswordField passwordField;
    private JButton listOfUserButton;
    private JButton registrationButton;
    private JButton loginButton;

    public LoginForm() {
        setContentPane(mainForm);
        setVisible(true);
        initButtons();
    }
    private void initButtons(){
        registrationButton.addActionListener(e -> {
            new registrForm();
            dispose();
        });
        loginButton.addActionListener(e -> {
            new ClientTableForm();
        });
    }

    @Override
    public int getFormWidth() {
        return 800;
    }

    @Override
    public int getFormHeight() {
        return 400;
    }
}
