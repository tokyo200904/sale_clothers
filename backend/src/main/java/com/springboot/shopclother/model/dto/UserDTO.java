package com.springboot.shopclother.model.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class UserDTO {

    private Integer maKH;
    private String tenKhachHang;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private String role;
    private boolean enabled;
    private Date ngayTao;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    // Getters & Setters
    public Integer getMaKH() { return maKH; }
    public void setMaKH(Integer maKH) { this.maKH = maKH; }
    public String getTenKhachHang() { return tenKhachHang; }
    public void setTenKhachHang(String tenKhachHang) { this.tenKhachHang = tenKhachHang; }
    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
    public Date getNgayTao() { return ngayTao; }
    public void setNgayTao(Date ngayTao) { this.ngayTao = ngayTao; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}