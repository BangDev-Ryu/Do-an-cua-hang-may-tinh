package dao;

import dto.PhieuNhapDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuNhapDAO {
    private MySQLConnect db = new MySQLConnect();
    
    public ArrayList<PhieuNhapDTO> list() {
        ArrayList<PhieuNhapDTO> hdList = new ArrayList<>();
        
        try {            
            String sql = "SELECT * FROM phieunhap";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                String id_hd = rs.getString("id_hd");
                String id_kh = rs.getString("id_kh");
                String id_user = rs.getString("id_user");
                java.sql.Date sqlDate = rs.getDate("ngay_xuat");
                LocalDate ngay_xuat = sqlDate.toLocalDate();
                int tong_tien = rs.getInt("tong_tien");
                
                PhieuNhapDTO hoaDon = new PhieuNhapDTO(id_hd, id_kh, id_user, ngay_xuat, tong_tien);
                hdList.add(hoaDon);
            }
            rs.close();
            db.disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hdList;
    } 
}
