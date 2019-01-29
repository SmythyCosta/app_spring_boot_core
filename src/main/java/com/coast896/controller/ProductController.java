package com.coast896.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import com.coast896.response.Response;

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
	public ResponseEntity<Response<ProductDTO>> save(@Valid @RequestBody ProductDTO dto, BindingResult result) {
		
		Response<ProductDTO> response = new Response<ProductDTO>();
		
		// Check for DTO errors
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		// check if name already exists in DB 
		//if(objRepository.existsByName(dto.getName())) {
		//	return new ResponseEntity<String>("Fail -> Name already exists!", HttpStatus.BAD_REQUEST);
        //} 
		
		// Entity receives DTO date
		Product obj = new Product();
		obj.setName(dto.getName());
		obj.setActive(dto.getActive());
		obj.setCost(dto.getCost());
		obj.setDateCreated(dto.getDateCreated());
		obj.setStock(dto.getStock());
		objRepository.save(obj);
		
		
		// Set Data in response
		dto.setId(obj.getId());
		response.setData(dto);
		
		return ResponseEntity.ok(response);
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
