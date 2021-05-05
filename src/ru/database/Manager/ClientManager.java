package ru.database.Manager;

import ru.Application;
import ru.database.Entity.ClientEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static ru.Application.getConnection;
public class ClientManager {
    public int add(ClientEntity client) throws SQLException {
        try (Connection c = Application.getConnection()) {
            String sql = "INSERT INTO client(FirstName, LastName, Patronymic, Birthday, RegistrationDate, Email, Phone, GenderCode, PhotoPath) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getName());
            ps.setString(2, client.getLastname());
            ps.setString(3, client.getPatronymic());
            ps.setString(4, client.getBirthday());
            ps.setString(5, client.getDateOfRegistration());
            ps.setString(6, client.getEmail());
            ps.setString(7, client.getPhone());
            ps.setString(8, String.valueOf(client.getGender()));
            ps.setString(9, client.getPhotoPath());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                ps.setInt(1, client.getId());
            }
        }
        return client.getId();
    }

    public List<ClientEntity> getAll() throws SQLException
    {
        try(Connection c = Application.getConnection())
        {
            String sql = "SELECT * FROM client";
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);
            List<ClientEntity> clients = new ArrayList<>();
            while (resultSet.next()){
                clients.add(new ClientEntity(
                        //ID, FirstName, LastName, Patronymic, Birthday, RegistrationDate, Email, Phone, GenderCode, PhotoPath
                        resultSet.getInt("ID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Patronymic"),
                        resultSet.getString("Birthday"),
                        resultSet.getString("RegistrationDate"),
                        resultSet.getString("Email"),
                        resultSet.getString("Phone"),
                        resultSet.getString( "GenderCode").charAt(0),
                        resultSet.getString("PhotoPath")
                ));
            }
            return clients;
        }
    }
}
