package com.springboot.shopclother.sevice;


import com.springboot.shopclother.entity.DanhMucConEntity;

import java.util.List;

public interface DanhMucConService {
    List<DanhMucConEntity> getAllDanhMucCon();
    DanhMucConEntity createDanhMucCon(Integer maDanhMuc, DanhMucConEntity danhMucCon);
    DanhMucConEntity updateDanhMucCon(Integer id, DanhMucConEntity danhMucCon);
    void deleteDanhMucCon(Integer id);
    DanhMucConEntity getDanhMucConById(Integer id);
}