package com.shubham.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shubham.entities.EncryptionDecryptionModel;

@Repository
public interface EncryptionDecryptionRepository extends MongoRepository<EncryptionDecryptionModel, Integer> {

}
