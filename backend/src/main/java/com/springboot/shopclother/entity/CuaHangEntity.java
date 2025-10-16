package com.springboot.shopclother.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cuahang")
public class CuaHangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_ch")
    private Integer maCH;

    @Column(name = "ten_ch", nullable = false, length = 100)
    private String tenCH;

    @Column(name = "dia_chi", length = 255)
    private String diaChi;

    @Column(name = "sodienthoai", length = 10)
    private String soDienThoai;

    @Column(name = "email", length = 100)
    private String email;

    // Getters & Setters
    public Integer getMaCH() { return maCH; }
    public void setMaCH(Integer maCH) { this.maCH = maCH; }
    public String getTenCH() { return tenCH; }
    public void setTenCH(String tenCH) { this.tenCH = tenCH; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

