package dao;

import dto.UserDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {
    private MySQLConnect db = new MySQLConnect();
    
    public ArrayList<UserDTO> list() {
        ArrayList<UserDTO> userList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM USER WHERE 1";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                String idUser = rs.getString("id_user");
                String password = rs.getString("password");
                String username = rs.getString("username");
                String role = rs.getString("role");
                boolean enable = rs.getBoolean("enable");
                
                UserDTO user = new UserDTO(idUser, password, username, role, enable);
                userList.add(user);
            }
            rs.close();
            db.disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userList;
    }
}
