package com.alnicode.user_data.controller;

import com.alnicode.user_data.service.ICrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class CrudController<Req, Resp> {

    protected abstract ICrudService<Req, Resp> service();

    @GetMapping
    public ResponseEntity<List<Resp>> getAll() {
        return ResponseEntity.ok(service().getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resp> get(@PathVariable("id") long id) {
        return ResponseEntity.of(service().get(id));
    }

    @PostMapping
    public ResponseEntity<Resp> register(@RequestBody Req request) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(service().create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resp> update(@PathVariable("id") long id, @RequestBody Req request) throws Exception {
        return ResponseEntity.of(service().update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Resp> delete(@PathVariable("id") long id) {
        return service().delete(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
