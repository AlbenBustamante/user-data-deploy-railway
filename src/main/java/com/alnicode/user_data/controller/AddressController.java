package com.alnicode.user_data.controller;

import com.alnicode.user_data.dto.address.AddressReq;
import com.alnicode.user_data.dto.address.AddressResp;
import com.alnicode.user_data.service.IAddressService;
import com.alnicode.user_data.service.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController extends CrudController<AddressReq, AddressResp> {

    private final IAddressService service;

    @Override
    protected ICrudService<AddressReq, AddressResp> service() {
        return service;
    }

}
