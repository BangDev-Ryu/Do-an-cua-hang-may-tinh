package dao;

import dto.CTHoaDonDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CTHoaDonDAO {
    private MySQLConnect db = new MySQLConnect();
    
    public ArrayList<CTHoaDonDTO> list() {
        ArrayList<CTHoaDonDTO> cthdList = new ArrayList<>();

        try {
            
            String sql = "SELECT * FROM CTHOADON";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                String id_hd = rs.getString("id_hd");
                String id_sp = rs.getString("id_sp");
                String serial_sp = rs.getString("serial_sp");
                int so_luong = rs.getInt("so_luong");
                int don_gia = rs.getInt("don_gia");
                
                CTHoaDonDTO ctHoaDon = new CTHoaDonDTO(id_hd, id_sp, serial_sp, so_luong, don_gia);
                cthdList.add(ctHoaDon);
            }
            rs.close();
            db.disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cthdList;
    }
}
