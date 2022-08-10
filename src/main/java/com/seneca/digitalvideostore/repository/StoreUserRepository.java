package com.seneca.digitalvideostore.repository;

import com.seneca.digitalvideostore.model.StoreUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreUserRepository extends MongoRepository<StoreUser, String> {
    Optional<StoreUser> findByEmail(String emailId);
}
