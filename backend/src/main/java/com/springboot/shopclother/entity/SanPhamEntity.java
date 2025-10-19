package com.springboot.shopclother.entity;

import jakarta.persistence.*;
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

    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_tao")
    private Date ngayTao;

    @ManyToOne
    @JoinColumn(name = "ma_dmc", nullable = false)
    private DanhMucConEntity danhMucCon;

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
    public void setMoTaSanPham(String moTaSanPham) { this.moTaSanPham = moTaSanPham; }
    public Double getPhanTramKhuyenMai() { return phanTramKhuyenMai; }
    public void setPhanTramKhuyenMai(Double phanTramKhuyenMai) { this.phanTramKhuyenMai = phanTramKhuyenMai; }
    public Date getNgayTao() { return ngayTao; }
    public void setNgayTao(Date ngayTao) { this.ngayTao = ngayTao; }
    public DanhMucConEntity getDanhMucCon() { return danhMucCon; }
    public void setDanhMucCon(DanhMucConEntity danhMucCon) { this.danhMucCon = danhMucCon; }

}
