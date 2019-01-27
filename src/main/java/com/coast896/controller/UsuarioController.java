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

import com.coast896.model.Usuario;
import com.coast896.repository.UsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository objRepository;
	
	@ApiOperation(value="Retorna uma lista de usuarios")
	@GetMapping("/usuarios")
	public List<Usuario> listar(){
		return objRepository.findAll();
	}
	
	@ApiOperation(value="Retorna um usuarios em detales")
	@GetMapping("/usuarios/{id}")
	public Usuario detalher(@PathVariable(value="id") long id){
		return objRepository.findById(id);
	}
	
	@ApiOperation(value="Salva um usuarios")
	@PostMapping("/usuarios")
	public Usuario salvar(@RequestBody @Valid Usuario obj) {
		return objRepository.save(obj);
	}
	
	@ApiOperation(value="Deleta um usuarios")
	@DeleteMapping("/usuarios")
	public void deletar(@RequestBody @Valid Usuario obj) {
		objRepository.delete(obj);
	}
	
	@ApiOperation(value="Atualizar um usuarios")
	@PutMapping("/usuarios")
	public Usuario atualizar(@RequestBody @Valid Usuario obj) {
		return objRepository.save(obj);
	}
	 

}
