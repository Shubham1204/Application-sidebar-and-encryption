package com.shubham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.entities.EncryptionDecryptionModel;
import com.shubham.service.EncryptionDecryptionService;

@RestController
@CrossOrigin("*")
public class EncryptionDecryptionController {

	@Autowired
	private EncryptionDecryptionService encryptionDecryptionService;

	@PostMapping("/encrypt")
	public ResponseEntity<?> encrypt(@RequestBody EncryptionDecryptionModel encryptionDecryptionModel) {
		String encryptData = encryptionDecryptionService.encryptData(encryptionDecryptionModel.getData());
		return ResponseEntity.ok(encryptData);
	}

	@PostMapping("/decrypt")
	public ResponseEntity<?> decrypt(@RequestBody EncryptionDecryptionModel encryptionDecryptionModel) {
		String decryptData = encryptionDecryptionService.decryptData(encryptionDecryptionModel.getData());
		return ResponseEntity.ok(decryptData);
	}

	@PostMapping("/secret/add")
	public ResponseEntity<?> addSecret(@RequestBody EncryptionDecryptionModel encryptionDecryptionModel) {
		encryptionDecryptionService.saveSecretKey(encryptionDecryptionModel.getSecretKey());
		return ResponseEntity.ok("saved");
	}
	
	@GetMapping("/secret/getall")
	public ResponseEntity<?> getAllSecret() {
		List<EncryptionDecryptionModel> allSecretKeys = encryptionDecryptionService.getAllSecretKeys();
		return ResponseEntity.ok(allSecretKeys);
	}
	
	@GetMapping("/secret/get")
	public ResponseEntity<?> getSecret() {
		String secretKey = encryptionDecryptionService.getSecretKey();
		return ResponseEntity.ok(secretKey);
	}
}
