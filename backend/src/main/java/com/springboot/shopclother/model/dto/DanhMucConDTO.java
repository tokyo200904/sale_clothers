package com.springboot.shopclother.model.dto;
public class DanhMucConDTO {
    private Integer maDMC;
    private String tenDMC;
    private Integer maDanhMuc; // chỉ trả id của danh mục cha
    private String tenDanhMuc; // và tên của danh mục cha

    public Integer getMaDMC() { return maDMC; }
    public void setMaDMC(Integer maDMC) { this.maDMC = maDMC; }

    public String getTenDMC() { return tenDMC; }
    public void setTenDMC(String tenDMC) { this.tenDMC = tenDMC; }

    public Integer getMaDanhMuc() { return maDanhMuc; }
    public void setMaDanhMuc(Integer maDanhMuc) { this.maDanhMuc = maDanhMuc; }

    public String getTenDanhMuc() { return tenDanhMuc; }
    public void setTenDanhMuc(String tenDanhMuc) { this.tenDanhMuc = tenDanhMuc; }
}