package dto;

public class KhachHangDTO {


    private String idKhachHang;
    private String tenKhachHang;
    private String Diachi;
    private String Sdt;

    public KhachHangDTO() {

    }

    public KhachHangDTO(String idKhachHang, String tenKhachHang, String Diachi, String Sdt) {
        this.idKhachHang = idKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.Diachi = Diachi;
        this.Sdt = Sdt;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public String getDiachi() {
        return Diachi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }



}