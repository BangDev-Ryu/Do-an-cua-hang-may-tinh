package bus;

import dao.HoaDonDAO;
import dto.HoaDonDTO;
import java.util.ArrayList;

public class HoaDonBUS {
    private ArrayList<HoaDonDTO> hdList;

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
}
