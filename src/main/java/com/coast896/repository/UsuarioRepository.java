package com.coast896.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coast896.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findById(long id);

}
