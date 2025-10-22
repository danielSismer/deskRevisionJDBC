package com.dao;

import com.model.Moto;
import com.util.ConnectionDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotoDAO {

    public void CadastrarMoto(Moto moto) throws SQLException {
        String query = """
                INSERT INTO Moto (modelo, placa, ano)
                VALUES (?, ?, ?)
                """;
        try(Connection conn = ConnectionDatabase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(2, moto.getPlaca());
            stmt.setString(1, moto.getModelo());
            stmt.setInt(3, moto.getAno());
            stmt.executeUpdate();
        }
    }

    public List<Moto> select () throws SQLException {
        List<Moto> motos = new ArrayList<>();
        String query = """
                SELECT id, modelo, placa, ano FROM Moto;
                """;
        try(Connection conn = ConnectionDatabase.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String modelo = rs.getString("modelo");
                String placa = rs.getString("placa");
                int ano = rs.getInt("ano");
                Moto moto = new Moto(id, modelo, placa, ano);
                motos.add(moto);
            }
        }

        return motos;
    }
}
