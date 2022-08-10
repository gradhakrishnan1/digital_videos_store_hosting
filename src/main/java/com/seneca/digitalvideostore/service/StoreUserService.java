package com.seneca.digitalvideostore.service;

import com.seneca.digitalvideostore.model.StoreUser;
import com.seneca.digitalvideostore.repository.StoreUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreUserService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final StoreUserRepository repository;

    public StoreUserService(BCryptPasswordEncoder passwordEncoder, StoreUserRepository repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    public StoreUser createStoreUser(StoreUser storeUser) {
        String encodedPassword = passwordEncoder.encode(storeUser.getPassword());

        storeUser.setPassword(encodedPassword);
        return repository.save(storeUser);
    }

    public boolean authenticateStoreUser(String email, String password) {
        Optional<StoreUser> storeUserOptional = repository.findByEmail(email);
        if (storeUserOptional.isEmpty()) {
            throw new RuntimeException("No user found with emailId: " + email);
        }
        return passwordEncoder.matches(password, storeUserOptional.get().getPassword());
    }
}
