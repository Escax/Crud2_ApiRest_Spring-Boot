package com.crud.es.controller;


import ch.qos.logback.core.net.server.Client;
import com.crud.es.model.dao.ClienteDao;
import com.crud.es.model.entity.Cliente;
import com.crud.es.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "api/v1/")
public class ClienteController {

    @Autowired
    private ICliente clienteService;

    @PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
         try{
             Cliente cliente_delete = clienteService.findById(id);
             clienteService.delete(cliente_delete);
             return new ResponseEntity<>(cliente_delete, HttpStatus.NO_CONTENT);

         }catch (DataAccessException exDT){
             response.put("Mensaje", exDT.getMessage());
             response.put("Cliente", null);
             return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }

    @GetMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente showById(@PathVariable Integer id){
        return clienteService.findById(id);
    }

}
