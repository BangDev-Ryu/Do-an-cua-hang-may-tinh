package dto;

public class SanPhamDTO {
    private String idSanPham;
    private String tenSanPham;
    private int soLuong;
    private int giaBan;
    private String hang;
    private String imgSanPham;

    public SanPhamDTO() {
        
    }

    public SanPhamDTO(String idSanPham, String tenSanPham, int soLuong, int giaBan, String hang, String imgSanPham) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.hang = hang;
        this.imgSanPham = imgSanPham;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getImgSanPham() {
        return imgSanPham;
    }

    public void setImgSanPham(String imgSanPham) {
        this.imgSanPham = imgSanPham;
    }
}
