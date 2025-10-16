package com.springboot.shopclother.converter;

import com.springboot.shopclother.entity.UserEntity;
import com.springboot.shopclother.model.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(UserEntity entity);
    UserEntity toEntity(UserDTO dto);
    List<UserDTO> toDTOList(List<UserEntity> entities);
}