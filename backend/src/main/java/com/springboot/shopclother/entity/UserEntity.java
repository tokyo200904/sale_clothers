package com.springboot.shopclother.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "makh")
    private Integer maKH;

    @Column(name = "ten_khachhang", nullable = false, length = 100)
    private String tenKhachHang;

    @Column(name = "so_dienthoai", unique = true, length = 15)
    private String soDienThoai;

    @Column(name = "matkhau", nullable = false, length = 255)
    private String matKhau;

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Column(name = "diachi", length = 255)
    private String diaChi;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "role", length = 20)
    private String role;

    // Getters & Setters
    public Integer getMaKH() { return maKH; }
    public void setMaKH(Integer maKH) { this.maKH = maKH; }
    public String getTenKhachHang() { return tenKhachHang; }
    public void setTenKhachHang(String tenKhachHang) { this.tenKhachHang = tenKhachHang; }
    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }
    public String getMatKhau() { return matKhau; }
    public void setMatKhau(String matKhau) { this.matKhau = matKhau; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
    public Date getNgayTao() { return ngayTao; }
    public void setNgayTao(Date ngayTao) { this.ngayTao = ngayTao; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
