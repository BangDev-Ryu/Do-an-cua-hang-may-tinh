package dao;

import dto.NhanVienDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVienDAO {
    private MySQLConnect db = new MySQLConnect();


    public ArrayList<NhanVienDTO> list() {
        ArrayList<NhanVienDTO> nvList = new ArrayList<>();

        try {            
            String sql = "SELECT * FROM nhanvien";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String ten = rs.getString("ten");
                String dia_chi = rs.getString("dia_chi");
                String sdt = rs.getString("sdt");
                String gioitinh = rs.getString("gioi_tinh");
                String img = rs.getString("img");

                NhanVienDTO nhanVien = new NhanVienDTO(id, ten, dia_chi, sdt, gioitinh, img);
                nvList.add(nhanVien);
            }
            rs.close();
            db.disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


        return nvList;
    }

    public void updateDB(NhanVienDTO nv) {
        String sql = "UPDATE nhanvien SET ";
        sql += "ten='" + nv.getTenNhanVien() + "', ";
        sql += "dia_chi='" + nv.getDiaChi() + "', ";
        sql += "sdt='" + nv.getSdt() + "', "; 
        sql += "gioi_tinh='" + nv.getGioiTinh() + "' "; 
        sql += "WHERE id='" + nv.getIdNhanVien() + "'";
        db.executeUpdate(sql);
    }


    public void addDB(NhanVienDTO nv) {
        String sql = "INSERT INTO nhanvien VALUES (";
        sql += "'" +  nv.getIdNhanVien() + "', ";
        sql += "N'" + nv.getTenNhanVien() + "', ";
        sql += "N'" + nv.getDiaChi() + "', ";
        sql += "'" +  nv.getSdt() + "', ";
        sql += "'" +  nv.getGioiTinh() + "', ";
        sql += "'" +  nv.getImg() + "')";

        db.executeUpdate(sql);
    }


    public void deleteDB(String id) {
        String sql = "DELETE FROM nhanvien WHERE id='" + id + "'";
        db.executeUpdate(sql);
    }
}