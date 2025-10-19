package com.springboot.shopclother.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "danhmuccon")
public class DanhMucConEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dmc")
    private Integer maDMC;

    @Column(name = "ten_dmc", nullable = false, length = 100)
    private String tenDMC;

    @ManyToOne
    @JoinColumn(name = "ma_danhmuc", nullable = false)
    private DanhMucEntity danhMuc;

    @OneToMany(mappedBy = "danhMucCon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SanPhamEntity> sanPhams;

    // Getters & Setters
    public Integer getMaDMC() { return maDMC; }
    public void setMaDMC(Integer maDMC) { this.maDMC = maDMC; }
    public String getTenDMC() { return tenDMC; }
    public void setTenDMC(String tenDMC) { this.tenDMC = tenDMC; }
    public DanhMucEntity getDanhMuc() { return danhMuc; }
    public void setDanhMuc(DanhMucEntity danhMuc) { this.danhMuc = danhMuc; }
}
