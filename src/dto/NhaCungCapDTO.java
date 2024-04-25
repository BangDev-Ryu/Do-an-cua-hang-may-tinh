package dto;

public class NhaCungCapDTO {


    private String idNhaCungCap;
    private String tenNhaCungCap;
    private String Diachi;
    private String Sdt;

    public NhaCungCapDTO() {
        
    }

    public NhaCungCapDTO(String idNhaCungCap, String tenNhaCungCap, String Diachi, String Sdt) {
        this.idNhaCungCap = idNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.Diachi = Diachi;
        this.Sdt = Sdt;
    }

    public String getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public String getDiachi() {
        return Diachi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setIdNhaCungCap(String idNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    
}
