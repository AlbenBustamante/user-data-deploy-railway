package com.alnicode.user_data.dto.json;

public record UserDto(long id, String name, String email, String website, String phone, AddressDto address, CompanyDto company) { }
