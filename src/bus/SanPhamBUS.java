package bus;

import dao.SanPhamDAO;
import dto.SanPhamDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SanPhamBUS {
    private ArrayList<SanPhamDTO> spList;

    public SanPhamBUS() {

    }

    public ArrayList<SanPhamDTO> getSpList() {
        return spList;
    }

    public void setSpList(ArrayList<SanPhamDTO> spList) {
        this.spList = spList;
    }
    
    public void list() {
        SanPhamDAO spDAO = new SanPhamDAO();
        spList = new ArrayList<>();
        spList = spDAO.list();
    }
    
    public void updateSanPham(SanPhamDTO sp) {
        for (int i = 0; i < spList.size(); i++) {
            if (spList.get(i).getIdSanPham().equals(sp.getIdSanPham())) {
                spList.set(i, sp);
                SanPhamDAO sanPhamDAO = new SanPhamDAO();
                sanPhamDAO.updateDB(sp);
                return;
            }
        }
    }
    
    public void addSanPham(SanPhamDTO sp) {
        spList.add(sp);
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        sanPhamDAO.addDB(sp);
    }
    
    public void deleteSanPham(String id) {
        for (SanPhamDTO sp : spList) {
            if (sp.getIdSanPham().equals(id)) {
                spList.remove(sp);
                SanPhamDAO sanPhamDAO = new SanPhamDAO();
                sanPhamDAO.deleteDB(id);
                return;
            }
        }
    }
    
    public boolean isExisted(String id) {
        for (SanPhamDTO sp : spList) {
            if (sp.getIdSanPham().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    public String createNewId() {
        String id = "SP";
        int new_id = spList.size() + 1;
        
        if (new_id <= 9) {
            id += "00" + new_id;
        }
        else if (new_id <= 99) {
            id += "0" + new_id;
        }
        else {
            id += new_id;
        }
        
        return id;
    }
    
    public ArrayList<SanPhamDTO> filter(String hang, int min, int max) {
        ArrayList<SanPhamDTO> res = new ArrayList<>();
        
        hang = hang.isEmpty() ? "" : hang;
        for (SanPhamDTO sp : spList) {
            if (sp.getHang().contains(hang) && sp.getGiaBan() >= min && sp.getGiaBan() <= max) {
                res.add(sp);
            }
        }
        
        return res;
    }
    
    public boolean checkSoLuong(String id, int so_luong) {
        for (SanPhamDTO sp : spList) {
            if (sp.getIdSanPham().equals(id) && sp.getSoLuong() < so_luong) {
                JOptionPane.showMessageDialog(null, "Không đủ hàng!");
                return false;
            }
        }
        return true;
    }
}
