package com.alnicode.user_data.service;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ICrudService<Req, Resp> {
    CrudRepository<?, Long> repository();
    Resp create(Req request) throws Exception;
    List<Resp> getAll();
    Optional<Resp> get(long id);
    Optional<Resp> update(long id, Req request) throws Exception;

    default boolean delete(long id) {
        try {
            repository().deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
