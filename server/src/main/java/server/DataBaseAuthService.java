package server;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseAuthService implements AuthService{

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement psInsert;

//    private class UserData {
//        String login;
//        String password;
//        String nickname;
//
//        public UserData(String login, String password, String nickname) {
//            this.login = login;
//            this.password = password;
//            this.nickname = nickname;
//        }
//    }

//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        connect();
//        clearTable();
//        prepareAllStatements();
//        fillDataBase();
//    }

    public void fillDataBase() throws SQLException {
        psInsert.setString(1, "qwe");
        psInsert.setString(2, "qwe");
        psInsert.setString(3, "qwe");
        psInsert.executeUpdate();
        psInsert.setString(1, "asd");
        psInsert.setString(2, "asd");
        psInsert.setString(3, "asd");
        psInsert.executeUpdate();
        psInsert.setString(1, "zxc");
        psInsert.setString(2, "zxc");
        psInsert.setString(3, "zxc");
        psInsert.executeUpdate();
    }

    public void prepareAllStatements() throws SQLException {
        psInsert = connection.prepareStatement("INSERT INTO clients (login, nick, password) VALUES (? ,?, ?);");
    }


    public void clearTable() throws SQLException {
        statement.executeUpdate("DELETE FROM clients;");
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT login, nick, password FROM clients;");
        while (rs.next()){
            if(rs.getString(1).equals(login) && rs.getString(3).equals(password)){
                return rs.getString(2);
            }
            rs.close();
        }
        return null;
    }

    @Override
    public boolean registration(String login, String password, String nickname) {
        return false;
    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:databasechat.db");
        statement = connection.createStatement();
    }

    public void disconnect() {
        try {
            psInsert.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
