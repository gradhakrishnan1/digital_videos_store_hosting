package com.seneca.digitalvideostore.controller;

import com.seneca.digitalvideostore.model.StoreUser;
import com.seneca.digitalvideostore.service.StoreUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@CrossOrigin
@Validated
@RestController
@RequestMapping("storeUser")
public class StoreUserController {

    private final StoreUserService service;

    public StoreUserController(StoreUserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StoreUser> createStoreUser(@RequestBody @Valid StoreUser storeUser) {
        return ResponseEntity.ok(service.createStoreUser(storeUser));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Void> authenticateStoreUser(@Email @RequestParam String email,
                                                        @RequestParam String password) {
        if (service.authenticateStoreUser(email, password)) {
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
