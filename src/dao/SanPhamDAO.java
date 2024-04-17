package dao;

import dto.SanPhamDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SanPhamDAO {
    private MySQLConnect db = new MySQLConnect();
    
    public ArrayList<SanPhamDTO> list() {
        ArrayList<SanPhamDTO> spList = new ArrayList<>();
        
        try {            
            String sql = "SELECT * FROM SANPHAM";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String ten = rs.getString("ten");
                int so_luong = rs.getInt("so_luong");
                int gia_ban = rs.getInt("gia_ban");
                String hang = rs.getString("hang");
                String img = rs.getString("img");
                
                SanPhamDTO sanPham = new SanPhamDTO(id, ten, so_luong, gia_ban, hang, img);
                spList.add(sanPham);
            }
            rs.close();
            db.disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return spList;
    }
    
    public void updateDB(SanPhamDTO sp) {
        String sql = "UPDATE SANPHAM SET ";
        sql += "ten='" + sp.getTenSanPham() + "', ";
        sql += "so_luong='" + sp.getSoLuong() + "', ";
        sql += "gia_ban='" + sp.getGiaBan() + "', ";
        sql += "hang='" + sp.getHang() + "', ";
        sql += "img='" + sp.getImgSanPham() + "' ";
        sql += "WHERE id='" + sp.getIdSanPham() + "'";
        db.executeUpdate(sql);
    }
    
    public void addDB(SanPhamDTO sp) {
        String sql = "INSERT INTO SANPHAM VALUES (";
        sql += "'" + sp.getIdSanPham() + "', ";
        sql += "N'" + sp.getTenSanPham() + "', ";
        sql += "'" + sp.getSoLuong() + "', ";
        sql += "'" + sp.getGiaBan() + "', ";
        sql += "'" + sp.getHang() + "', ";
        sql += "'" + sp.getImgSanPham() + "')";
        db.executeUpdate(sql);
    }
    
    public void deleteDB(String id) {
        String sql = "DELETE FROM SANPHAM WHERE id='" + id + "'";
        db.executeUpdate(sql);
    }
}
