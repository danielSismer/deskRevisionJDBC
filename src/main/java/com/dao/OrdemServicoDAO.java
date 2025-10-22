package com.dao;

import com.model.OrdemServico;
import com.util.ConnectionDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoDAO {

    public void criarOrdemServico(OrdemServico ordemServico) throws SQLException {
        String query = """
                INSERT INTO OrdemServico (placaMoto, descricao, status) VALUES (?, ?, ?)
                """;
        try(Connection conn = ConnectionDatabase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, ordemServico.getPlacaMoto());
            stmt.setString(2, ordemServico.getObservacao());
            stmt.setString(3, "ABERTA");
            stmt.executeUpdate();
        }
    }

    public List<OrdemServico> select () throws SQLException {
        List<OrdemServico> ordemServicos = new ArrayList<>();
        String query = """
                SELECT id, descricao, data_abertura, status, placaMoto 
                FROM OrdemServico WHERE status = ?
                """;
        try(Connection conn = ConnectionDatabase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, "ABERTA");

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                Date data = rs.getDate("data_abertura");
                String status = rs.getString("status");
                String placa = rs.getString("placaMoto");
                ordemServicos.add(new OrdemServico(id, descricao, data, status, placa));
            }
        }

        return ordemServicos;
    }

    public void updateStatus (int id) throws SQLException {
        String query = "UPDATE OrdemServico SET status = ? WHERE id = ?";
        try(Connection conn = ConnectionDatabase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, "Finalizada");
            stmt.setInt(2, id);
        }
    }
}
