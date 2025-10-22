package com.dao;

import com.model.Cliente;
import com.util.ConnectionDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class ClienteDAO {


    public void cadastrarCliente(Cliente cliente) throws SQLException {
        String query = """
                INSERT INTO Cliente (nome, telefone, cpf)
                VALUES (?, ?, ?)
                """;
        try(Connection conn = ConnectionDatabase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getCpf());
            stmt.executeUpdate();
            System.out.println("Cadastrado com sucesso");
        } catch (SQLIntegrityConstraintViolationException e ){
            System.out.println("CPF já cadastrado!!!");
        }
    }
}
