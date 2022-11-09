package com.alnicode.user_data.service.impl;

import com.alnicode.user_data.dto.user.UserReq;
import com.alnicode.user_data.dto.user.UserResp;
import com.alnicode.user_data.entity.User;
import com.alnicode.user_data.mapper.UserMapper;
import com.alnicode.user_data.repository.IAddressRepository;
import com.alnicode.user_data.repository.IUserRepository;
import com.alnicode.user_data.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository repository;
    private final IAddressRepository addressRepository;
    private final UserMapper mapper;

    @Override
    public CrudRepository<User, Long> repository() {
        return repository;
    }

    @Override
    public UserResp create(UserReq request) throws Exception {
        if (!request.passwordsMatch()) {
            throw new Exception("The passwords do not match!");
        }

        final var address = addressRepository.findById(request.addressId())
                .orElseThrow(() -> new Exception("Address not found with ID: #" + request.addressId() + "!"));

        final var user = mapper.toEntity(request);
        user.setAddress(address);

        return mapper.toResponse(repository.save(user));
    }

    @Override
    public List<UserResp> getAll() {
        return mapper.toResponses(repository.findAll());
    }

    @Override
    public Optional<UserResp> get(long id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    @Override
    public Optional<UserResp> update(long id, UserReq request) throws Exception {
        final var user = repository.findById(id);

        if (user.isEmpty()) {
            return Optional.empty();
        }

        final var address = addressRepository.findById(request.addressId())
                .orElseThrow(() -> new Exception("Address not found with ID: #" + request.addressId()));

        user.get().setId(id);
        user.get().setName(request.name());
        user.get().setEmail(request.email());
        user.get().setUsername(request.username());
        user.get().setPassword(request.password());
        user.get().setAddress(address);

        return Optional.of(mapper.toResponse(repository.save(user.get())));
    }

}
