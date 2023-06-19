package com.excercises.springdatajpa.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excercises.springdatajpa.entidades.Cliente;
import com.excercises.springdatajpa.services.ClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/clientes")
@CrossOrigin(origins = "*")
public class ClienteApi {
        private final ClienteService clienteService;
        @GetMapping({"","/"})
        public ResponseEntity<List<Cliente>> get(){
            return ResponseEntity.ok(clienteService.obtenerTodos());
        }
}
