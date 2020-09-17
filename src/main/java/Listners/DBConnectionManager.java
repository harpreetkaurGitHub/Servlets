package Listners;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionManager {

    private String dbURL = "jdbc:mysql://localhost:3306/mydb";
    private String user = "harpreet";
    private String password = "00000000";
    private Connection conn;

    public DBConnectionManager(String dbUrl, String user, String password){
        this.dbURL=dbUrl;
        this.user=user;
        this.password=password;

    }

    public Connection getConnection(){
        return this.conn;
    }

    public void closeConnection(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
