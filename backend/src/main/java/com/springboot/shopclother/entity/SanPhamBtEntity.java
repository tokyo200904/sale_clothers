package com.springboot.shopclother.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sanphambt")
public class SanPhamBtEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mabt")
    private Integer maBT;

    @ManyToOne
    @JoinColumn(name = "masp", nullable = false)
    private SanPhamEntity sanPham;

    @Column(name = "chatlieu_sanpham", length = 100)
    private String chatLieuSanPham;

    @Column(name = "kich_co", length = 50)
    private String kichCo;

    @Column(name = "mausac", length = 50)
    private String mauSac;

    @Column(name = "soluong_trongkho")
    private Integer soLuongTrongKho;

    @Column(name = "anh", length = 255)
    private String anh;

    @Column(name = "gia_sanpham")
    private Double giaSanPham;

    // Getters & Setters
    public Integer getMaBT() { return maBT; }
    public void setMaBT(Integer maBT) { this.maBT = maBT; }
    public SanPhamEntity getSanPham() { return sanPham; }
    public void setSanPham(SanPhamEntity sanPham) { this.sanPham = sanPham; }
    public String getChatLieuSanPham() { return chatLieuSanPham; }
    public void setChatLieuSanPham(String chatLieuSanPham) { this.chatLieuSanPham = chatLieuSanPham; }
    public String getKichCo() { return kichCo; }
    public void setKichCo(String kichCo) { this.kichCo = kichCo; }
    public String getMauSac() { return mauSac; }
    public void setMauSac(String mauSac) { this.mauSac = mauSac; }
    public Integer getSoLuongTrongKho() { return soLuongTrongKho; }
    public void setSoLuongTrongKho(Integer soLuongTrongKho) { this.soLuongTrongKho = soLuongTrongKho; }
    public String getAnh() { return anh; }
    public void setAnh(String anh) { this.anh = anh; }
    public Double getGiaSanPham() { return giaSanPham; }
    public void setGiaSanPham(Double giaSanPham) { this.giaSanPham = giaSanPham; }
}
