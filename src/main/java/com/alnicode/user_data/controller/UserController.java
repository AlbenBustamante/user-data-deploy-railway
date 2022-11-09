package com.alnicode.user_data.controller;

import com.alnicode.user_data.dto.user.UserReq;
import com.alnicode.user_data.dto.user.UserResp;
import com.alnicode.user_data.service.ICrudService;
import com.alnicode.user_data.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController extends CrudController<UserReq, UserResp> {

    private final IUserService service;

    @Override
    protected ICrudService<UserReq, UserResp> service() {
        return service;
    }

}
