package cz.inventi.admin.mapper;

import cz.inventi.admin.db.model.UserEntity;
import cz.inventi.admin.dto.UserDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userEntityToUserDto(UserEntity userEntity);

    @InheritInverseConfiguration
    UserEntity userDtoToUserEntity(UserDto userDto);
}
