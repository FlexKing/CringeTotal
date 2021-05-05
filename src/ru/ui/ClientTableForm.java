package ru.ui;
import ru.Application;
import ru.database.Entity.ClientEntity;
import ru.database.Manager.ClientManager;
import ru.util.BaseForm;
import ru.util.CustomTableModule;
import javax.swing.*;
import java.sql.SQLException;
public class ClientTableForm extends BaseForm {
    private final ClientManager clientManager =Application.getInstance().getClientManager();
    private JPanel mainPanel;
    private JTable clientTable;
    private CustomTableModule<ClientEntity> model;
    public ClientTableForm (){
        setContentPane(mainPanel);
        initTable();
        setVisible(true);
    }
    private void initTable(){
        clientTable.getTableHeader().setReorderingAllowed(false);
        try {
            model = new CustomTableModule<ClientEntity>(ClientEntity.class, clientManager.getAll());
            clientTable.setModel(model);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public int getFormWidth() {
        return 1000;
    }

    @Override
    public int getFormHeight() {
        return 900;
    }
}
