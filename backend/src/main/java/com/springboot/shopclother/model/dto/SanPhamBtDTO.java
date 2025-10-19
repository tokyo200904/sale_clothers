package com.springboot.shopclother.model.dto;

public class SanPhamBtDTO {
    private Integer maBT;
    private String chatLieuSanPham;
    private String kichCo;
    private String mauSac;
    private Integer soLuongTrongKho;
    private String anh;
    private Double giaSanPham;

    public Integer getMaBT() {
        return maBT;
    }

    public void setMaBT(Integer maBT) {
        this.maBT = maBT;
    }

    // Getters & Setters
    public String getChatLieuSanPham() { return chatLieuSanPham; }
    public void setChatLieuSanPham(String chatLieuSanPham) { this.chatLieuSanPham = chatLieuSanPham; }
    public String getKichCo() { return kichCo; }
    public void setKichCo(String kichCo) { this.kichCo = kichCo; }
    public String getMauSac() { return mauSac; }
    public void setMauSac(String mauSac) { this.mauSac = mauSac; }
    public Integer getSoLuongTrongKho() { return soLuongTrongKho; }
    public void setSoLuongTrongKho(Integer soLuongTrongKho) { this.soLuongTrongKho = soLuongTrongKho; }
    public Double getGiaSanPham() { return giaSanPham; }
    public void setGiaSanPham(Double giaSanPham) { this.giaSanPham = giaSanPham; }
    public String getAnh() { return anh; }
    public void setAnh(String anh) { this.anh = anh; }
}
