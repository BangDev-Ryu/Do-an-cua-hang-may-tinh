package dto;

public class ChiTietSanPhamDTO {
    private String idSanPham;
    private String serial;
    
    public ChiTietSanPhamDTO() {
        
    }

    public ChiTietSanPhamDTO(String idSanPham, String serial) {
        this.idSanPham = idSanPham;
        this.serial = serial;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
