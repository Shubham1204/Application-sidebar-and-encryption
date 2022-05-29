package com.shubham.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.dao.EncryptionDecryptionRepository;
import com.shubham.entities.EncryptionDecryptionModel;
import com.shubham.util.EncryptionDecryptionHelper;

@Service
public class EncryptionDecryptionService {

	@Autowired
	private EncryptionDecryptionHelper encryptionDecryptionHelper;
	
	@Autowired
	private EncryptionDecryptionRepository encryptionDecryptionRepository;
	
	EncryptionDecryptionModel encryptDecryptModel = new EncryptionDecryptionModel();
	
	public String saveSecretKey(String secret) {
		encryptDecryptModel.setSecretKey(secret);
		encryptDecryptModel.setDate(new Date());
		EncryptionDecryptionModel saved = encryptionDecryptionRepository.save(encryptDecryptModel);
		return saved.getSecretKey();
	}
	
	public List<EncryptionDecryptionModel> getAllSecretKeys() {
		List<EncryptionDecryptionModel> findAll = encryptionDecryptionRepository.findAll();
		return findAll;
	}
	
	public String getSecretKey() {
		List<EncryptionDecryptionModel> allSecretKeys = getAllSecretKeys();
		EncryptionDecryptionModel encryptionDecryptionModel = allSecretKeys.get(allSecretKeys.size()-1);
		return encryptionDecryptionModel.getSecretKey();
	}
	
	public String encryptData(String data) {
		String encryptedData = encryptionDecryptionHelper.encrypt(data, getSecretKey());
		return encryptedData;
	}

	public String decryptData(String data) {
		String decryptedData = encryptionDecryptionHelper.decrypt(data, getSecretKey());
		return decryptedData;
	}
}
