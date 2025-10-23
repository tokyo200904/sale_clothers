package com.springboot.shopclother.converter;

import com.springboot.shopclother.entity.SanPhamEntity;
import com.springboot.shopclother.model.dto.SanPhamDTO;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring", uses = {SanPhamBtMapper.class})
public interface SanPhamMapper {

    // Entity → DTO
    @Mapping(source = "danhMuc.maDanhMuc", target = "ma_DanhMuc")

    SanPhamDTO toDTO(SanPhamEntity entity);

    // DTO → Entity
    @InheritInverseConfiguration
    @Mapping(target = "danhMuc", ignore = true) // set trong service
    SanPhamEntity toEntity(SanPhamDTO dto);

    List<SanPhamDTO> toDTOList(List<SanPhamEntity> entities);

    List<SanPhamEntity> toEntityList(List<SanPhamDTO> dtos);
}
