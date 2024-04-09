package com.ayudas.ong.controllers.socio;

import org.springframework.web.bind.annotation.RestController;

import com.ayudas.ong.services.socios.SocioServices;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/socio")
public class SocioControllerRestApi {

    public final SocioServices socioServices;

    @GetMapping("/socios")
    public ResponseEntity<Map<String,Object>> mostrarSocios() {
        Map<String,Object> response = new HashMap<>();
        response.put("Socio", socioServices.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    
}
