package com.springboot.shopclother.converter;

import com.springboot.shopclother.entity.SanPhamBtEntity;
import com.springboot.shopclother.model.dto.SanPhamBtDTO;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SanPhamBtMapper {

    @Mapping(source = "sanPham.maSP", target = "maBT")
    SanPhamBtDTO toDTO(SanPhamBtEntity entity);

    @InheritInverseConfiguration
    @Mapping(target = "sanPham", ignore = true) // set trong service
    SanPhamBtEntity toEntity(SanPhamBtDTO dto);

    List<SanPhamBtDTO> toDTOList(List<SanPhamBtEntity> entities);

    List<SanPhamBtEntity> toEntityList(List<SanPhamBtDTO> dtos);
}
