package com.springboot.shopclother.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Chi_tiet_don_hang")
public class ChiTietDonHangEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_ctdh")
    private Integer maCTDH;

    @ManyToOne
    @JoinColumn(name = "ma_dh", nullable = false)
    private DonHangEntity donHang;

    @ManyToOne
    @JoinColumn(name = "mabt", nullable = false)
    private SanPhamBtEntity sanPhamBT;

    @Column(name = "size", length = 50)
    private String size;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "soluong")
    private Integer soLuong;

    @Column(name = "thanh_tien")
    private Double thanhTien;

    @Column(name = "don_gia")
    private Double donGia;

    @Column(name = "giam_gia")
    private Double giamGia;

    @Column(name = "anh", length = 255)
    private String anh;

    @Column(name = "trangthai", length = 20)
    private String trangThai;

    // Getters & Setters
    public Integer getMaCTDH() { return maCTDH; }
    public void setMaCTDH(Integer maCTDH) { this.maCTDH = maCTDH; }
    public DonHangEntity getDonHang() { return donHang; }
    public void setDonHang(DonHangEntity donHang) { this.donHang = donHang; }
    public SanPhamBtEntity getSanPhamBT() { return sanPhamBT; }
    public void setSanPhamBT(SanPhamBtEntity sanPhamBT) { this.sanPhamBT = sanPhamBT; }
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public Integer getSoLuong() { return soLuong; }
    public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; }
    public Double getThanhTien() { return thanhTien; }
    public void setThanhTien(Double thanhTien) { this.thanhTien = thanhTien; }
    public Double getDonGia() { return donGia; }
    public void setDonGia(Double donGia) { this.donGia = donGia; }
    public Double getGiamGia() { return giamGia; }
    public void setGiamGia(Double giamGia) { this.giamGia = giamGia; }
    public String getAnh() { return anh; }
    public void setAnh(String anh) { this.anh = anh; }
    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
}
