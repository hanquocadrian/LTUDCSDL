
package uti;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectManager {
    //  vì là thư viện tạo kết nối -> dùng mọi nơi -> public static
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/2020?useUnicode=true&characterEncoding=UTF-8";
            String user= "root";
            String pass= "";
            Connection conn = DriverManager.getConnection(url, user, pass);
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
