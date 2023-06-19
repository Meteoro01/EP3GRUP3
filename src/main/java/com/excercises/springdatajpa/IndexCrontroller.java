package com.excercises.springdatajpa;

import com.excercises.springdatajpa.entidades.Cliente;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.excercises.springdatajpa.services.ClienteService;

import org.springframework.ui.Model;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/")
public class IndexCrontroller {


    private final ClienteService clienteService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("cliente", clienteService.obtenerTodos());
        return "index";
    }
    @RequestMapping("/otro")
    public  String otroindex(){
        return "otroindex";
    }
    @PostMapping("")
    public String registrar(@ModelAttribute("cliente")Cliente cliente){
        clienteService.registrarCliente(cliente);
        return "redirect:/";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id")Long id, Model model) throws Exception {
        model.addAttribute("cliente",clienteService.obtenerClienteId(id));
        return "/editar";
    }
@PutMapping("/editar")
public String actualizar(@ModelAttribute("cliente") Cliente cliente) throws Exception {
    Cliente clienteExistente = clienteService.obtenerClienteId(cliente.getId());
    cliente.setFechaCreacion(clienteExistente.getFechaCreacion()); // Mantener la fecha de creación original
    cliente.setFechaModificacion(LocalDateTime.now()); // Actualizar la fecha de modificación

    clienteService.registrarCliente(cliente); // Guarda los cambios en la base de datos

    return "redirect:/";
}
    /*
    @PutMapping("/editar")
    public String editar(@ModelAttribute("cliente") Cliente cliente){
        clienteService.registrarCliente(cliente);
        return "redirect:/cliente";
    }*/
    @DeleteMapping("/eliminar")
    public String eliminar(@RequestParam("id")Long id) throws Exception {
        clienteService.eliminarCliente(id);
        return"redirect:/";
    }

}
