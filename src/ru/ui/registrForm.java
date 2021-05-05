package ru.ui;
import ru.Application;
import ru.database.Entity.ClientEntity;
import ru.database.Manager.ClientManager;
import ru.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;
public class registrForm extends BaseForm {
    private JTextField NameField;
    private JTextField lastNameField;
    private JTextField patronomycField;
    private JTextField birthdayField;
    private JTextField registrationDateField;
    private JTextField emailField;
    private JButton cancelButton;
    private JButton registerButton;
    private JTextField phoneField;
    private JTextField genderField;
    private JTextField pathField;
    private JPanel mainPanel;
    private final ClientManager clientManager = Application.getInstance().getClientManager();
    public registrForm(){
        setContentPane(mainPanel);
        initButtons();
        setVisible(true);
    }
    public void initButtons() {
        cancelButton.addActionListener(e -> {
            dispose();
        });
        registerButton.addActionListener(e -> {
                ClientEntity client = new ClientEntity(
                        0,
                        NameField.getText(),
                        lastNameField.getText(),
                        patronomycField.getText(),
                        birthdayField.getText(),
                        registrationDateField.getText(),
                        emailField.getText(),
                        phoneField.getText(),
                        'ж',
                        pathField.getText()
                );
                try {
                    clientManager.add(client);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
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
