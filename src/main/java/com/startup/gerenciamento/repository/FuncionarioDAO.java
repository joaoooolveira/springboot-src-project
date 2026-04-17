/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.startup.gerenciamento.repository;

import com.startup.gerenciamento.model.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioDAO {
    public List<FuncionarioDTO> lerTodos() {
        List<FuncionarioDTO> dados = new ArrayList();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM funcionarios");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                FuncionarioDTO funcionario = new FuncionarioDTO();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setDepartamento(rs.getString("departamento"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setDataContratacao(rs.getDate("data_contratacao"));
                dados.add(funcionario);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return dados;
    }
    
    public FuncionarioDTO getPerfilFuncionario(int id) {
        FuncionarioDTO funcionario = new FuncionarioDTO();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM funcionarios WHERE id = ?");
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            if (rs.next()){
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setDepartamento(rs.getString("departamento"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setDataContratacao(rs.getDate("data_contratacao"));
            }
            
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return funcionario;
    }
    
    public void editPerfil(FuncionarioDTO funcionario){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("update funcionarios set nome = ?, email = ?, cargo = ?, departamento = ? where id = ?");
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getEmail());
            stmt.setString(3, funcionario.getCargo());
            stmt.setString(4, funcionario.getDepartamento());
            stmt.setInt(5, funcionario.getId());
            
            stmt.executeUpdate();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void saveFuncionario(FuncionarioDTO funcionario){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("insert into funcionarios (nome, cargo, departamento, email, data_contratacao) values (?, ?, ?, ?, ?)");
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3, funcionario.getDepartamento());
            stmt.setString(4, funcionario.getEmail());
            stmt.setDate(5, funcionario.getDataContratacao());
            
            stmt.executeUpdate();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
