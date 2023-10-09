package repositories;

import java.sql.*;

public class Mysql {
    private Connection connexion;
    private Statement stmt;

    public void connexion() {
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb",
                    "mydbuser", "mydbuser");

        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public void executerSelect() {

        try {
            stmt = connexion.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String sql = "SELECT id, nom, age, adresse FROM inscription";
        try {
            ResultSet res = stmt.executeQuery(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void executeUpdate(){
        
    }

}
