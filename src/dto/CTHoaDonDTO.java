package dto;

public class CTHoaDonDTO {
    private String idHoaDon;
    private String idSanPham;
    private String serialSP;
    private int soLuong;
    private int donGia;
    
    public CTHoaDonDTO() {
        
    }

    public CTHoaDonDTO(String idHoaDon, String idSanPham, String serialSP, int soLuong, int donGia) {
        this.idHoaDon = idHoaDon;
        this.idSanPham = idSanPham;
        this.serialSP = serialSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getSerialSP() {
        return serialSP;
    }

    public void setSerialSP(String serialSP) {
        this.serialSP = serialSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
}
