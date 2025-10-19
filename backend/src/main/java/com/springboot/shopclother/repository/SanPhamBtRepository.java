package com.springboot.shopclother.repository;

import com.springboot.shopclother.entity.SanPhamBtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamBtRepository extends JpaRepository<SanPhamBtEntity, Integer> {
    List<SanPhamBtEntity> findBySanPham_MaSP(Integer maSP);
}