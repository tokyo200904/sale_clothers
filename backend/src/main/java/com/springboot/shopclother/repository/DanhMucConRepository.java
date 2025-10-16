package com.springboot.shopclother.repository;
import com.springboot.shopclother.entity.DanhMucConEntity;
import com.springboot.shopclother.entity.DanhMucEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhMucConRepository extends JpaRepository<DanhMucConEntity, Integer> {
    List<DanhMucConEntity> findByDanhMuc(DanhMucEntity danhMuc);
    boolean existsByTenDMC(String tenDMC);
}