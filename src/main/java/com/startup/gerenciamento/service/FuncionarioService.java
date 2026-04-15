
package com.startup.gerenciamento.service;

import com.startup.gerenciamento.model.FuncionarioDTO;
import com.startup.gerenciamento.repository.FuncionarioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioDAO repository;
    
    public List<FuncionarioDTO> lerTodos(){
        return repository.lerTodos();
    }
    
    public FuncionarioDTO getPerfilFuncionario(int id) {
        return repository.getPerfilFuncionario(id);
    }
}
