package com.springboot.shopclother.repository;

import com.springboot.shopclother.entity.DanhMucEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMucEntity, Integer> {
    boolean existsByTenDanhMuc(String tenDanhMuc);
}