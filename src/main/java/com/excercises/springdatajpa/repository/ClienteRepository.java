package com.excercises.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.excercises.springdatajpa.entidades.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    
}
