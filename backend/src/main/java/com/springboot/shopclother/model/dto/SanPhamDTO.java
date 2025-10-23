package com.springboot.shopclother.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamDTO {
    private String tenSP;
    private String moTaSanPham;
    private Double phanTramKhuyenMai;
    private Integer ma_DanhMuc;
    private String anhSanPham;
    private BigDecimal gia;

    public String getAnhSanPham() {
        return anhSanPham;
    }

    public void setAnhSanPham(String anhSanPham) {
        this.anhSanPham = anhSanPham;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public String getTenSP() { return tenSP; }
    public void setTenSP(String tenSP) { this.tenSP = tenSP; }
    public String getMoTaSanPham() { return moTaSanPham; }
    public void setMoTaSanPham(String moTaSanPham) { this.moTaSanPham = moTaSanPham; }
    public Double getPhanTramKhuyenMai() { return phanTramKhuyenMai; }
    public void setPhanTramKhuyenMai(Double phanTramKhuyenMai) { this.phanTramKhuyenMai = phanTramKhuyenMai; }

    public Integer getMa_DanhMuc() {
        return ma_DanhMuc;
    }

    public void setMa_DanhMuc(Integer ma_DanhMuc) {
        this.ma_DanhMuc = ma_DanhMuc;
    }
}