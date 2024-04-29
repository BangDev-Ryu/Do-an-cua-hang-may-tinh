package Menu;

public class NhanVienDTO{

    private String idNhanVien;
    private String tenNhanVien;
    private String diaChi;
    private String sdt;
    private String gioiTinh;
    private String img;

    public NhanVienDTO() {

    }

    public NhanVienDTO(String idNhanVien, String tenNhanVien, String Diachi, String Sdt, String gioitinh, String img) {
        this.idNhanVien = idNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.diaChi = Diachi;
        this.sdt = Sdt;
        this.gioiTinh = gioitinh;
        this.img = img;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}