package bus;

import dao.NhanVienDAO;
import dto.NhanVienDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NhanVienBUS {
    private ArrayList<NhanVienDTO> nvList;

    public NhanVienBUS() {

    }

    public ArrayList<NhanVienDTO> getNvList() {
        return nvList;
    }

    public void setNvList(ArrayList<NhanVienDTO> nvList) {
        this.nvList = nvList;
    }
    
    public void list() {
        NhanVienDAO nvDAO = new NhanVienDAO();
        nvList = new ArrayList<>();
        nvList = nvDAO.list();
    }
    
    public void updateNhanVien(NhanVienDTO nv) {
        for (int i = 0; i < nvList.size(); i++) {
            if (nvList.get(i).getIdNhanVien().equals(nv.getIdNhanVien())) {
                nvList.set(i, nv);
                NhanVienDAO nhanVienDAO = new NhanVienDAO();
                nhanVienDAO.updateDB(nv);
                return;
            }
        }
    }
    
    public void addNhanVien(NhanVienDTO nv) {
        nvList.add(nv);
        NhanVienDAO nhanVienDAO = new NhanVienDAO();
        nhanVienDAO.addDB(nv);
    }
    
    public void deleteNhanVien(String id) {
        for (NhanVienDTO nv : nvList) {
            if (nv.getIdNhanVien().equals(id)) {
                nvList.remove(nv);
                NhanVienDAO nhanVienDAO = new NhanVienDAO();
                nhanVienDAO.deleteDB(id);
                return;
            }
        }
    }
    
    public boolean isExisted(String id) {
        for (NhanVienDTO nv : nvList) {
            if (nv.getIdNhanVien().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    public String createNewId() {
        String id = "NV";
        int new_id = nvList.size() + 1;
        
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
    
    public ArrayList<NhanVienDTO> filter(String gioitinh) {
        ArrayList<NhanVienDTO> res = new ArrayList<>();
        
        gioitinh = gioitinh.isEmpty() ? "" : gioitinh;
        for (NhanVienDTO nv : nvList) {
            if (nv.getGioiTinh().contains(gioitinh)) {
                res.add(nv);
            }
        }
        
        return res;
    }

}
