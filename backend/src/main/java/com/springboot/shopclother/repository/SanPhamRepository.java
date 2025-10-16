package com.springboot.shopclother.repository;

import com.springboot.shopclother.entity.SanPhamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPhamEntity, Integer> {
}
