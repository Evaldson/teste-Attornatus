package com.attornatus.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attornatus.model.Cliente;

@Repository
public interface ClienteRespository extends JpaRepository<Cliente, Long>{

}
