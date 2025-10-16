package com.springboot.shopclother.sevice.impl;

import com.springboot.shopclother.entity.DanhMucConEntity;
import com.springboot.shopclother.entity.DanhMucEntity;
import com.springboot.shopclother.repository.DanhMucConRepository;
import com.springboot.shopclother.repository.DanhMucRepository;
import com.springboot.shopclother.sevice.DanhMucConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DanhMucConServiceImpl implements DanhMucConService {

    @Autowired
    private DanhMucConRepository danhMucConRepository;

    @Autowired
    private DanhMucRepository danhMucRepository;

    @Override
    public List<DanhMucConEntity> getAllDanhMucCon() {
        return danhMucConRepository.findAll();
    }

    @Override
    public DanhMucConEntity createDanhMucCon(Integer maDanhMuc, DanhMucConEntity danhMucCon) {
        DanhMucEntity danhMuc = danhMucRepository.findById(maDanhMuc)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy danh mục cha!"));
        if (danhMucConRepository.existsByTenDMC(danhMucCon.getTenDMC())) {
            throw new RuntimeException("Tên danh mục con đã tồn tại!");
        }
        danhMucCon.setDanhMuc(danhMuc);
        return danhMucConRepository.save(danhMucCon);
    }

    @Override
    public DanhMucConEntity updateDanhMucCon(Integer id, DanhMucConEntity danhMucCon) {
        DanhMucConEntity existing = danhMucConRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy danh mục con để cập nhật!"));
        existing.setTenDMC(danhMucCon.getTenDMC());
        return danhMucConRepository.save(existing);
    }

    @Override
    public void deleteDanhMucCon(Integer id) {
        if (!danhMucConRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy danh mục con để xóa!");
        }
        danhMucConRepository.deleteById(id);
    }

    @Override
    public DanhMucConEntity getDanhMucConById(Integer id) {
        return danhMucConRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy danh mục con!"));
    }
}
