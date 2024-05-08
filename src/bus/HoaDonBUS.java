package bus;

import dao.HoaDonDAO;
import dto.HoaDonDTO;
import java.util.ArrayList;

public class HoaDonBUS {
    private ArrayList<HoaDonDTO> hdList;
    
    public HoaDonBUS() {
        
    }

    public ArrayList<HoaDonDTO> getHdList() {
        return hdList;
    }

    public void setHdList(ArrayList<HoaDonDTO> hdList) {
        this.hdList = hdList;
    }
    
    public void list() {
        HoaDonDAO hdDAO = new HoaDonDAO();
        hdList = new ArrayList<>();
        hdList = hdDAO.list();
    }
    
    public void addHoaDon(HoaDonDTO hd) {
        hdList.add(hd);
        HoaDonDAO hoaDonDAO = new HoaDonDAO();
        hoaDonDAO.addDB(hd);
    }
    
    public String createNewId() {
        String id = "HD";
        int new_id = hdList.size() + 1;
        
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
}
