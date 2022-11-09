package com.alnicode.user_data.dto.user;

public record UserReq(String name, String email, String username, String password, String passwordConfirmed, long addressId) {

    public boolean passwordsMatch() {
        return !password.isBlank() && !passwordConfirmed.isBlank() && passwordConfirmed.equals(password);
    }

}
