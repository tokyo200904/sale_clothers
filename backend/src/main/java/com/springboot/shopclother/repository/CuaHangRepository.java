package com.springboot.shopclother.repository;


import com.springboot.shopclother.entity.CuaHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuaHangRepository extends JpaRepository<CuaHangEntity, Integer> {
}