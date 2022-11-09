package com.alnicode.user_data.mapper;

import com.alnicode.user_data.dto.address.AddressReq;
import com.alnicode.user_data.dto.address.AddressResp;
import com.alnicode.user_data.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressResp toResponse(Address entity);

    List<AddressResp> toResponses(List<Address> entities);

    @Mapping(target = "id", ignore = true)
    Address toEntity(AddressReq request);

}
