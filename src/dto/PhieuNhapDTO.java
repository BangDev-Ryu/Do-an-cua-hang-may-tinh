package dto;

import java.time.LocalDate;

public class PhieuNhapDTO {
    private String idPhieuNHap;
    private String idNHaCungCap;
    private String idUser;
    private LocalDate ngayNhap;
    private int tongTien;

    public PhieuNhapDTO() {
    }

    public PhieuNhapDTO(String idPhieuNHap, String idNHaCungCap, String idUser, LocalDate ngayNhap, int tongTien) {
        this.idPhieuNHap = idPhieuNHap;
        this.idNHaCungCap = idNHaCungCap;
        this.idUser = idUser;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }

    public String getIdPhieuNHap() {
        return idPhieuNHap;
    }

    public String getIdNHaCungCap() {
        return idNHaCungCap;
    }

    public String getIdUser() {
        return idUser;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setIdPhieuNHap(String idPhieuNHap) {
        this.idPhieuNHap = idPhieuNHap;
    }

    public void setIdNHaCungCap(String idNHaCungCap) {
        this.idNHaCungCap = idNHaCungCap;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
    
}
