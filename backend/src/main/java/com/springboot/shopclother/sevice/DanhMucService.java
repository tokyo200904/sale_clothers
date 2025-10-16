package com.springboot.shopclother.sevice;

import com.springboot.shopclother.entity.DanhMucEntity;
import java.util.List;

public interface DanhMucService {
    List<DanhMucEntity> getAllDanhMuc();
    DanhMucEntity createDanhMuc(DanhMucEntity danhMuc);
    DanhMucEntity updateDanhMuc(Integer id, DanhMucEntity danhMuc);
    void deleteDanhMuc(Integer id);
}