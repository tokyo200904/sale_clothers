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
    @OneToMany(mappedBy = "danhMuc", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SanPhamEntity> sanPhams;

    public List<SanPhamEntity> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(List<SanPhamEntity> sanPhams) {
        this.sanPhams = sanPhams;
    }

    // Getters & Setters
    public Integer getMaDanhMuc() { return maDanhMuc; }
    public void setMaDanhMuc(Integer maDanhMuc) { this.maDanhMuc = maDanhMuc; }
    public String getTenDanhMuc() { return tenDanhMuc; }
    public void setTenDanhMuc(String tenDanhMuc) { this.tenDanhMuc = tenDanhMuc; }

}
