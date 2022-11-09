package com.alnicode.user_data.service.impl;

import com.alnicode.user_data.dto.address.AddressReq;
import com.alnicode.user_data.dto.address.AddressResp;
import com.alnicode.user_data.entity.Address;
import com.alnicode.user_data.mapper.AddressMapper;
import com.alnicode.user_data.repository.IAddressRepository;
import com.alnicode.user_data.service.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements IAddressService {

    private final IAddressRepository repository;
    private final AddressMapper mapper;

    @Override
    public CrudRepository<Address, Long> repository() {
        return repository;
    }

    @Override
    public AddressResp create(AddressReq request) throws Exception {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @Override
    public List<AddressResp> getAll() {
        return mapper.toResponses(repository.findAll());
    }

    @Override
    public Optional<AddressResp> get(long id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    @Override
    public Optional<AddressResp> update(long id, AddressReq request) throws Exception {
        final var address = repository.findById(id)
                .orElseThrow(() -> new Exception("Address not found with ID: " + id));

        address.setCity(request.city());
        address.setStreet(request.street());
        address.setCountry(request.country());

        return Optional.of(mapper.toResponse(repository.save(address)));
    }

}
