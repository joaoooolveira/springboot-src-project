/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.startup.gerenciamento.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Joao Oliveira
 */
@RestController
@RequestMapping("/api")
public class FuncionarioAPIController {
    
    @GetMapping("/ola")
    public String ola(){
        return "Olá mundo, essa é minha primeira rota de API";
    }
    
    @GetMapping("/nome")
    public String nome(){
        return "Meu nome é: João";
    }
    
    @GetMapping("/dados")
    public String dados(){
        return "Nome: João\nIdade: 19\nCurso: Técnico em Desenvolvimento de Sistemas";
    }
}
