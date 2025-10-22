package com.dao;

import com.model.OrdemFechada;
import com.util.ConnectionDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class OrdemFechadaDAO {

    public void insert (OrdemFechada ordemFechada) throws SQLException {
        String query = """
                INSERT INTO OrdemFechada (id, valor) VALUES (?, ?)
                """;
        try(Connection conn = ConnectionDatabase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query) ) {
            System.out.println("a");
            stmt.setInt(1, ordemFechada.getId());
            System.out.println("b");
            stmt.setDouble(2, ordemFechada.getValor());
            System.out.println("c");
            stmt.executeUpdate();
        }
    }
}
