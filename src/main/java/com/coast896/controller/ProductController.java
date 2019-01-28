package com.coast896.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coast896.DTO.ProductDTO;
import com.coast896.model.Product;
import com.coast896.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Product")
public class ProductController {
	
	@Autowired
	ProductRepository objRepository;
	
	@ApiOperation(value="List Product")
	@GetMapping("/product")
	public List<Product> list(){
		return objRepository.findAll();
	}
	
	@ApiOperation(value="Find Product")
	@GetMapping("/product/{id}")
	public Product find(@PathVariable(value="id") long id){
		return objRepository.findById(id);
	}
	
	@ApiOperation(value="Save Product")
	@PostMapping("/product")
	public ResponseEntity<String> save(@Valid @RequestBody ProductDTO dto) {
		
		if(objRepository.existsByName(dto.getName())) {
			return new ResponseEntity<String>("Fail -> Name already exists!", HttpStatus.BAD_REQUEST);
        } 
		
		Product obj = new Product();
		obj.setName(dto.getName());
		obj.setActive(dto.getActive());
		obj.setCost(dto.getCost());
		obj.setDateCreated(dto.getDateCreated());
		obj.setStock(dto.getStock());
		
		objRepository.save(obj);
		
		//return objRepository.save(product);
		return ResponseEntity.ok().body("ok may persist in db!");
		
	}
	
	@ApiOperation(value="Delete Product")
	@DeleteMapping("/product")
	public void delete(@RequestBody @Valid Product obj) {
		objRepository.delete(obj);
	}
	
	@ApiOperation(value="Update Product")
	@PutMapping("/product")
	public Product update(@RequestBody @Valid Product obj) {
		return objRepository.save(obj);
	}
	
	 

}
