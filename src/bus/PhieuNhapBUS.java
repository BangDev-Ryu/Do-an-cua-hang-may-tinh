package bus;

import dao.PhieuNhapDAO;
import dto.PhieuNhapDTO;
import java.util.ArrayList;

public class PhieuNhapBUS {

    private ArrayList<PhieuNhapDTO> pnList;

    public ArrayList<PhieuNhapDTO> getPnList() {
        return pnList;
    }

    public void setPnList(ArrayList<PhieuNhapDTO> pnList) {
        this.pnList = pnList;
    }
    
    public void list() {
        PhieuNhapDAO pnDAO = new PhieuNhapDAO();
        pnList = new ArrayList<>();
        pnList = pnDAO.list();
    }
}
