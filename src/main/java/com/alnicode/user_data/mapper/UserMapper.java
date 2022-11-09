package com.alnicode.user_data.mapper;

import com.alnicode.user_data.dto.user.UserReq;
import com.alnicode.user_data.dto.user.UserResp;
import com.alnicode.user_data.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResp toResponse(User entity);

    List<UserResp> toResponses(List<User> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "registerAt", ignore = true)
    User toEntity(UserReq request);

}
