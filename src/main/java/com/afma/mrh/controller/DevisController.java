package com.afma.mrh.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.afma.mrh.entity.Devis;
import com.afma.mrh.exception.ResourceNotFoundException;
import com.afma.mrh.service.DevisService;


@RestController
@RequestMapping("/api/v1")
public class DevisController {
	

	@Autowired
	private DevisService devisService;

	
	@GetMapping("/devis")
	public List<Devis> getAllDevis() {
		return devisService.loadAllDeviss();
	}

	@GetMapping("/devis/{id}")
	public ResponseEntity<Devis> getDevisById(@PathVariable(value = "id") Long devisId)
			throws ResourceNotFoundException {
		Devis devis = devisService.getDevisById(devisId);
		return ResponseEntity.ok().body(devis);
	}

	@PostMapping("/devis")
	public Devis createDevis(@Valid @RequestBody Devis devis, Principal p) {
		return devisService.createDevis(devis);
	}

	@PutMapping("/devis/{id}")
	public ResponseEntity<Devis> updateDevis(
			@PathVariable(value = "id") Long devisId,
			@Valid @RequestBody Devis devisDetails) throws ResourceNotFoundException {

		//final Devis updatedDevis = devisService.UpdateDevis(devisDetails);
		return ResponseEntity.ok(devisDetails);
	}

	@PatchMapping("/devis/{id}")
	public ResponseEntity<Devis> updateDevispatch(
			@PathVariable(value = "id") Long devisId,
			@Valid @RequestBody Devis devisDetails) throws ResourceNotFoundException {
	//	final Devis updatedDevis = devisService.UpdateDevis(devisDetails);
		return ResponseEntity.ok(devisDetails);
	}

	
	// @PreAuthorize("hasAnyRole('ROLE_admin')")
	@ResponseBody
	@DeleteMapping("/devis/{id}")
	public Map<String, Boolean> deleteDevis(@PathVariable(value = "id") Long devisId) throws ResourceNotFoundException {
		return devisService.deleteDevis(devisId);
	}

}
