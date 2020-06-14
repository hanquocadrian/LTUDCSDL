
package dao;
import model.Customer;
import uti.ConnectManager;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAO {
    //  CRUD cho 1 Object:
    public List<Customer> findAll(){
        List<Customer> ArrCus = new ArrayList<Customer>();
        Connection conn = ConnectManager.getConnection();
        try {
            Statement smt = conn.createStatement();
            String sql = "select* from customer";
            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setAge(rs.getInt(3));
                ArrCus.add(c);
            }
            return ArrCus;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean insert(Customer c){
        Connection conn = ConnectManager.getConnection();
        try {
            String sql = "INSERT INTO customer(name, age) VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getName());
            ps.setInt(2, c.getAge());
            
            //  thay đổi ok ko
            if(ps.executeUpdate() != 0){
                //  lấy lại id đc cấp auto từ mySQL khi insert cho customer đó
                ResultSet keyResultSet = ps.getGeneratedKeys();
                int newCustomerId = 0;
                if(keyResultSet.next()){
                    newCustomerId = keyResultSet.getInt(1);
                    c.setId(newCustomerId);
                }
                return true;
            }
            else 
                return false;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }    
    public boolean delete(int id){
        Connection conn = ConnectManager.getConnection();
        try {
            String sql = "DELETE FROM customer WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate() != 0)
                return true;
            else 
                return false;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }    
    public boolean update(Customer c){
        Connection conn = ConnectManager.getConnection();
        String sql = "UPDATE customer SET name=?, age=? WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setInt(2, c.getAge());
            ps.setInt(3, c.getId());
            
            return (ps.executeUpdate() != 0) ? true : false;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }    
}
