package com.springboot.shopclother.converter;

import com.springboot.shopclother.entity.SanPhamEntity;
import com.springboot.shopclother.entity.SanPhamBtEntity;
import com.springboot.shopclother.model.dto.SanPhamBtDTO;
import com.springboot.shopclother.model.dto.SanPhamDTO;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SanPhamMapper {

    @Mapping(source = "danhMucCon.maDMC", target = "maDmc")
    @Mapping(source = "cuaHang.maCH", target = "maCH")
    @Mapping(source = "sanPhamBts", target = "chiTietList")
    SanPhamDTO toDTO(SanPhamEntity entity);

    @Mapping(target = "maSP", ignore = true)
    @Mapping(source = "maDmc", target = "danhMucCon.maDMC")
    @Mapping(source = "maCH", target = "cuaHang.maCH")
    @Mapping(target = "sanPhamBts", ignore = true) // set sau
    SanPhamEntity toEntity(SanPhamDTO dto);

    List<SanPhamBtDTO> toDTOList(List<SanPhamBtEntity> entityList);

    List<SanPhamBtEntity> toEntityList(List<SanPhamBtDTO> dtoList);
}