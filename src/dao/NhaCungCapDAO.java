package dao;

import dto.NhaCungCapDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhaCungCapDAO {
    private MySQLConnect db = new MySQLConnect();

    public ArrayList<NhaCungCapDTO> list() {
        ArrayList<NhaCungCapDTO> nccList = new ArrayList<>();

        try {            
            String sql = "SELECT * FROM NHACUNGCAP";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String ten = rs.getString("ten");
                String dia_chi = rs.getString("dia_chi");
                String sdt = rs.getString("sdt");

                NhaCungCapDTO nhaCungCap  = new NhaCungCapDTO(id, ten, dia_chi, sdt);
                nccList.add(nhaCungCap);
            }
            rs.close();
            db.disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nccList;
    }

    public void updateDB(NhaCungCapDTO ncc) {
        String sql = "UPDATE NHACUNGCAP SET ";
        sql += "ten='" + ncc.getTenNhaCungCap() + "', ";
        sql += "dia_chi='" + ncc.getDiachi() + "', ";
        sql += "sdt='" + ncc.getSdt() + "' "; 
        sql += "WHERE id='" + ncc.getIdNhaCungCap() + "'";
        db.executeUpdate(sql);
    }

    public void addDB(NhaCungCapDTO ncc) {
        String sql = "INSERT INTO NHACUNGCAP VALUES (";
        sql += "'" + ncc.getIdNhaCungCap() + "', ";
        sql += "N'" + ncc.getTenNhaCungCap() + "', ";
        sql += "N'" + ncc.getDiachi() + "', ";
        sql += "'" + ncc.getSdt() + "')";
        db.executeUpdate(sql);
    }

    public void deleteDB(String id) {
        String sql = "DELETE FROM NHACUNGCAP WHERE id='" + id + "'";
        db.executeUpdate(sql);
    }
}