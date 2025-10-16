package com.springboot.shopclother.model.dto;

import java.util.List;

public class DanhMucDTO {
    private Integer maDanhMuc;
    private String tenDanhMuc;

    // Chỉ hiển thị danh sách tên các danh mục con (nếu cần)
    private List<DanhMucConDTO> danhMucConList;

    public Integer getMaDanhMuc() { return maDanhMuc; }
    public void setMaDanhMuc(Integer maDanhMuc) { this.maDanhMuc = maDanhMuc; }

    public String getTenDanhMuc() { return tenDanhMuc; }
    public void setTenDanhMuc(String tenDanhMuc) { this.tenDanhMuc = tenDanhMuc; }

    public List<DanhMucConDTO> getDanhMucConList() { return danhMucConList; }
    public void setDanhMucConList(List<DanhMucConDTO> danhMucConList) { this.danhMucConList = danhMucConList; }
}