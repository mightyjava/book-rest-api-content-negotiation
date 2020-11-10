package com.mightyjava.resource;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface Resource<T> {
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	ResponseEntity<Collection<T>> findAll();

	@GetMapping(value = "{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	ResponseEntity<T> findById(@PathVariable Long id);

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	ResponseEntity<T> save(@RequestBody T t);

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	ResponseEntity<T> update(@RequestBody T t);

	@DeleteMapping("{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id);

	@GetMapping("/invalid")
	ResponseEntity<String> invalid();
}
