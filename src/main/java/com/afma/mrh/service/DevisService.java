package com.afma.mrh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afma.mrh.entity.Devis;
import com.afma.mrh.exception.ResourceNotFoundException;
import com.afma.mrh.repository.DevisRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DevisService {

	@Autowired
	DevisRepository devisRepository;

	public List<Devis> loadAllDeviss() {
		List<Devis> deviss = devisRepository.findAll();
		return deviss;
	}

	public Devis getDevisById(Long devisId) throws ResourceNotFoundException {
		return  devisRepository.findById(devisId)
				.orElseThrow(() -> new ResourceNotFoundException("Devis not found for this id :: " + devisId));
	}

	public Devis createDevis(Devis devis) {
		Devis createddevis = devisRepository.save(devis);
		return createddevis;
	}

	public Devis UpdateDevis(Long devisId) throws ResourceNotFoundException {
		Devis devis = devisRepository.findById(devisId)
				.orElseThrow(() -> new ResourceNotFoundException("Devis not found for this id :: " + devisId ));

		final Devis updatedDevis = devisRepository.save(devis);
		return updatedDevis;
	}

	public Map<String, Boolean> deleteDevis(Long devisId) throws ResourceNotFoundException {
		Devis devis = devisRepository.findById(devisId)
				.orElseThrow(() -> new ResourceNotFoundException("Devis not found for this id :: " + devisId));

		devisRepository.delete(devis);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
