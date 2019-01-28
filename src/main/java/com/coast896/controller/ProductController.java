package com.coast896.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Product> listar(){
		return objRepository.findAll();
	}
	
	@ApiOperation(value="Find Product")
	@GetMapping("/product/{id}")
	public Product detalher(@PathVariable(value="id") long id){
		return objRepository.findById(id);
	}
	
	@ApiOperation(value="Salve Product")
	@PostMapping("/product")
	public Product salvar(@RequestBody @Valid Product obj) {
		return objRepository.save(obj);
	}
	
	@ApiOperation(value="Delete Product")
	@DeleteMapping("/product")
	public void deletar(@RequestBody @Valid Product obj) {
		objRepository.delete(obj);
	}
	
	@ApiOperation(value="Update Product")
	@PutMapping("/product")
	public Product atualizar(@RequestBody @Valid Product obj) {
		return objRepository.save(obj);
	}
	 

}
