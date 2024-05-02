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
            String sql = "SELECT * FROM user";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String password = rs.getString("password");
                String ten = rs.getString("ten");
                String gioi_tinh = rs.getString("gioi_tinh");
                String sdt = rs.getString("sdt");
                String role = rs.getString("role");
                String img = rs.getString("img");
                boolean enable = rs.getBoolean("enable");
                
                UserDTO user = new UserDTO(id, password, ten, gioi_tinh, sdt, role, img, enable);
                userList.add(user);
            }
            rs.close();
            db.disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userList;
    }
    

    public void updateDB(UserDTO us) {
        String sql = "UPDATE user SET ";
        sql += "password='" + us.getPassword() + "', ";
        sql += "ten='" + us.getTenUser() + "', ";
        sql += "gioi_tinh='" + us.getGioiTinh() + "', ";
        sql += "sdt='" + us.getSdt() + "', ";
        sql += "role='" + us.getRole() + "', ";
        sql += "img='" + us.getImgUser() + "', ";
        sql += "enable='" + us.isEnable() + "' ";
        sql += "WHERE id='" + us.getIdUser() + "'";
        db.executeUpdate(sql);
    }
    
    public void addDB(UserDTO us) {
        String sql = "INSERT INTO user VALUES (";
        sql += "'" +  us.getIdUser() + "', ";
        sql += "'" +  us.getPassword() + "', ";
        sql += "N'" + us.getTenUser() + "', ";
        sql += "'" +  us.getGioiTinh() + "', ";
        sql += "'" +  us.getSdt() + "', ";
        sql += "'" +  us.getRole() + "', ";
        sql += "'" +  us.getImgUser() + "', ";
        sql += "'" +  us.isEnable() + "')";

        db.executeUpdate(sql);
    }
}
