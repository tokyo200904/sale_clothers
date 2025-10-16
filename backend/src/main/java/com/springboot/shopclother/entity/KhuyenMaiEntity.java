package com.springboot.shopclother.entity;

import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "khuyenmai")
public class KhuyenMaiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_km")
    private Integer maKM;

    @Column(name = "ma_code", unique = true, nullable = false, length = 50)
    private String maCode;

    @Column(name = "gia_tri_giam")
    private Double giaTriGiam;

    @Column(name = "gioi_han_su_dung")
    private Integer gioiHanSuDung;

    @Temporal(TemporalType.DATE)
    @Column(name = "km_tu_ngay")
    private Date kmTuNgay;

    @Temporal(TemporalType.DATE)
    @Column(name = "km_den_ngay")
    private Date kmDenNgay;

    // Getters & Setters
    public Integer getMaKM() { return maKM; }
    public void setMaKM(Integer maKM) { this.maKM = maKM; }
    public String getMaCode() { return maCode; }
    public void setMaCode(String maCode) { this.maCode = maCode; }
    public Double getGiaTriGiam() { return giaTriGiam; }
    public void setGiaTriGiam(Double giaTriGiam) { this.giaTriGiam = giaTriGiam; }
    public Integer getGioiHanSuDung() { return gioiHanSuDung; }
    public void setGioiHanSuDung(Integer gioiHanSuDung) { this.gioiHanSuDung = gioiHanSuDung; }
    public Date getKmTuNgay() { return kmTuNgay; }
    public void setKmTuNgay(Date kmTuNgay) { this.kmTuNgay = kmTuNgay; }
    public Date getKmDenNgay() { return kmDenNgay; }
    public void setKmDenNgay(Date kmDenNgay) { this.kmDenNgay = kmDenNgay; }
}
