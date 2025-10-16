package com.springboot.shopclother.model.dto;

import java.util.List;

public class SanPhamDTO {
    private String tenSP;
    private String moTaSanPham;
    private Double phanTramKhuyenMai;
    private Integer maDmc;
    private Integer maCH;
    private List<SanPhamBtDTO> chiTietList;

    // Getters & Setters
    public String getTenSP() { return tenSP; }
    public void setTenSP(String tenSP) { this.tenSP = tenSP; }
    public String getMoTaSanPham() { return moTaSanPham; }
    public void setMoTaSanPham(String moTaSanPham) { this.moTaSanPham = moTaSanPham; }
    public Double getPhanTramKhuyenMai() { return phanTramKhuyenMai; }
    public void setPhanTramKhuyenMai(Double phanTramKhuyenMai) { this.phanTramKhuyenMai = phanTramKhuyenMai; }
    public Integer getMaDmc() { return maDmc; }
    public void setMaDmc(Integer maDmc) { this.maDmc = maDmc; }
    public Integer getMaCH() { return maCH; }
    public void setMaCH(Integer maCH) { this.maCH = maCH; }
    public List<SanPhamBtDTO> getChiTietList() { return chiTietList; }
    public void setChiTietList(List<SanPhamBtDTO> chiTietList) { this.chiTietList = chiTietList; }
}