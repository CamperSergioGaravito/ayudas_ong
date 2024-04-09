package com.ayudas.ong.controllers.director;

import org.springframework.web.bind.annotation.RestController;

import com.ayudas.ong.repositories.entities.Director;
import com.ayudas.ong.repositories.entities.Rol;
import com.ayudas.ong.repositories.enums.Roles;
import com.ayudas.ong.services.DirectorServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/v1/admin")

public class DirectorControllerRestApi {
    public DirectorServices directorServices;

    @GetMapping("/")
    public void getMethodName() {
        Director director = new Director(123456, "Marco", null, "Polo", null, new Rol(Roles.ADMIN,null), "marco@mail.com", "asd123");
        System.out.println("++++++ " + director.toString());
        directorServices.guardar(director);
    }
    

}
