package com.springboot.shopclother.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sanpham")
public class SanPhamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "masp")
    private Integer maSP;

    @Column(name = "tensp", nullable = false, length = 150)
    private String tenSP;

    @Column(name = "mota_sanpham", columnDefinition = "TEXT")
    private String moTaSanPham;

    @Column(name = "phantram_khuyenmai")
    private Double phanTramKhuyenMai;

    @Column(name = "gia", precision = 10, scale = 2)
    private BigDecimal gia;

    @Column(name = "anh_sanpham", length = 255)
    private String anhSanPham;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_tao")
    private Date ngayTao;

    public DanhMucEntity getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMucEntity danhMuc) {
        this.danhMuc = danhMuc;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_danhmuc")
    private DanhMucEntity danhMuc;

    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SanPhamBtEntity> sanPhamBts;

    public List<SanPhamBtEntity> getSanPhamBts() {
        return sanPhamBts;
    }

    public void setSanPhamBts(List<SanPhamBtEntity> sanPhamBts) {
        this.sanPhamBts = sanPhamBts;
    }
    public Integer getMaSP() { return maSP; }
    public void setMaSP(Integer maSP) { this.maSP = maSP; }
    public String getTenSP() { return tenSP; }
    public void setTenSP(String tenSP) { this.tenSP = tenSP; }
    public String getMoTaSanPham() { return moTaSanPham; }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public String getAnhSanPham() {
        return anhSanPham;
    }

    public void setAnhSanPham(String anhSanPham) {
        this.anhSanPham = anhSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) { this.moTaSanPham = moTaSanPham; }
    public Double getPhanTramKhuyenMai() { return phanTramKhuyenMai; }
    public void setPhanTramKhuyenMai(Double phanTramKhuyenMai) { this.phanTramKhuyenMai = phanTramKhuyenMai; }
    public Date getNgayTao() { return ngayTao; }
    public void setNgayTao(Date ngayTao) { this.ngayTao = ngayTao; }


}
