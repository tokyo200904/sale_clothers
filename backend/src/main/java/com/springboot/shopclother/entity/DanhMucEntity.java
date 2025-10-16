package com.springboot.shopclother.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "danhmuc")
public class DanhMucEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_danhmuc")
    private Integer maDanhMuc;

    @Column(name = "ten_danhmuc", nullable = false, length = 100)
    private String tenDanhMuc;

    @OneToMany(mappedBy = "danhMuc", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<DanhMucConEntity> danhMucCons;

    // Getters & Setters
    public Integer getMaDanhMuc() { return maDanhMuc; }
    public void setMaDanhMuc(Integer maDanhMuc) { this.maDanhMuc = maDanhMuc; }
    public String getTenDanhMuc() { return tenDanhMuc; }
    public void setTenDanhMuc(String tenDanhMuc) { this.tenDanhMuc = tenDanhMuc; }
    public List<DanhMucConEntity> getDanhMucCons() { return danhMucCons; }
    public void setDanhMucCons(List<DanhMucConEntity> danhMucCons) { this.danhMucCons = danhMucCons; }
}
