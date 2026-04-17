/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.startup.gerenciamento.controller;

import com.startup.gerenciamento.model.FuncionarioDTO;
import com.startup.gerenciamento.service.FuncionarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FuncionarioController {
    
    @Autowired 
    private FuncionarioService service;
    
    @GetMapping("/funcionarios")
    public String getFuncionarios(Model model) {
        List<FuncionarioDTO> lista = service.lerTodos();
        model.addAttribute("lista", lista);
        return "funcionarios";
    }
    
    @GetMapping("/perfil")
    public String getPerfil(@RequestParam int id, Model model){
        FuncionarioDTO perfil = service.getPerfilFuncionario(id);
        model.addAttribute("funcionario", perfil);
        return "perfil";
    }
    
    @GetMapping("/adicionar-novo")
    public String adicionarNovo(Model model){
        FuncionarioDTO funcionario = new FuncionarioDTO();
        model.addAttribute("funcionario", funcionario);
        return "adicionar-novo";
    }
    
    @PostMapping("/atualizar")
    public String atualizarDados(@ModelAttribute FuncionarioDTO funcionario){
        service.editPerfil(funcionario);
        return "redirect:/funcionarios";
    }
    
    @PostMapping("/adicionar")
    public String adicionarFuncionario(@ModelAttribute FuncionarioDTO funcionario){
        service.save(funcionario);
        return "redirect:/funcionarios";
    }
}