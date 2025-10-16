package com.springboot.shopclother.sevice.impl;
import com.springboot.shopclother.entity.DanhMucEntity;
import com.springboot.shopclother.repository.DanhMucRepository;
import com.springboot.shopclother.sevice.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DanhMucServiceImpl implements DanhMucService {
    @Autowired
    private DanhMucRepository danhMucRepository;

    @Override
    public List<DanhMucEntity> getAllDanhMuc() {
        return danhMucRepository.findAll();
    }

    @Override
    public DanhMucEntity createDanhMuc(DanhMucEntity danhMuc) {
        if (danhMucRepository.existsByTenDanhMuc(danhMuc.getTenDanhMuc())) {
            throw new RuntimeException("Tên danh mục đã tồn tại!");
        }
        return danhMucRepository.save(danhMuc);
    }

    @Override
    public DanhMucEntity updateDanhMuc(Integer id, DanhMucEntity danhMuc) {
        DanhMucEntity existing = danhMucRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy danh mục!"));
        existing.setTenDanhMuc(danhMuc.getTenDanhMuc());
        return danhMucRepository.save(existing);
    }

    @Override
    public void deleteDanhMuc(Integer id) {
        if (!danhMucRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy danh mục để xóa!");
        }
        danhMucRepository.deleteById(id);
    }

}
