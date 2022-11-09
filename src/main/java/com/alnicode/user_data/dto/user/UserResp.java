package com.alnicode.user_data.dto.user;

import com.alnicode.user_data.dto.address.AddressResp;

public record UserResp(long id, String name, String email, String username, AddressResp address) {
}
