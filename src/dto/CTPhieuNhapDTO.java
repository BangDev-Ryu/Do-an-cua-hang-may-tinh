package dto;

public class CTPhieuNhapDTO {
     private String idPhieuNhap;
    private String idSanPham;
    private int soLuong;
    private int donGia;

    public CTPhieuNhapDTO() {
    }

    public CTPhieuNhapDTO(String idPhieuNhap, String idSanPham, int soLuong, int donGia) {
        this.idPhieuNhap = idPhieuNhap;
        this.idSanPham = idSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setIdPhieuNhap(String idPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
    
}
