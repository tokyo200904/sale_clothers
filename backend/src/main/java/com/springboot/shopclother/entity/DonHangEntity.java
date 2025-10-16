package com.springboot.shopclother.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "donhang")
public class DonHangEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dh")
    private Integer maDH;

    @ManyToOne
    @JoinColumn(name = "makh", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "ma_km")
    private KhuyenMaiEntity khuyenMai;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_lap")
    private Date ngayLap;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_giao")
    private Date ngayGiao;

    @Column(name = "noi_giao", length = 255)
    private String noiGiao;

    // Getters & Setters
    public Integer getMaDH() { return maDH; }
    public void setMaDH(Integer maDH) { this.maDH = maDH; }
    public UserEntity getUser() { return user; }
    public void setUser(UserEntity user) { this.user = user; }
    public KhuyenMaiEntity getKhuyenMai() { return khuyenMai; }
    public void setKhuyenMai(KhuyenMaiEntity khuyenMai) { this.khuyenMai = khuyenMai; }
    public Date getNgayLap() { return ngayLap; }
    public void setNgayLap(Date ngayLap) { this.ngayLap = ngayLap; }
    public Date getNgayGiao() { return ngayGiao; }
    public void setNgayGiao(Date ngayGiao) { this.ngayGiao = ngayGiao; }
    public String getNoiGiao() { return noiGiao; }
    public void setNoiGiao(String noiGiao) { this.noiGiao = noiGiao; }
}
