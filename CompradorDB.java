package JDBC.conn.db;

import JDBC.conn.ConexaoFactory;
import JDBC.conn.classes.Comprador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompradorDB {
    public static void save(Comprador comprador) {
        String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('"+comprador.getCpf()+"', '"+comprador.getNome()+"');";
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConexaoFactory.close(conn, stmt);
            System.out.println("Registro inserído com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void delete(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível excluir o registro");
        return;
        }
        String sql = "DELETE FROM `agencia`.`comprador` WHERE `id` ='" + comprador.getId() + "'";
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConexaoFactory.close(conn, stmt);
            System.out.println("Registro excluído com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update (Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível atualizar o registro");
            return;
        }
        String sql = "UPDATE `agencia`.`comprador` SET `cpf` = '"+ comprador.getCpf() +"',  `nome` = '" + comprador.getNome() + "' WHERE `id` = '" + comprador.getId() + "';";
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConexaoFactory.close(conn, stmt);
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Comprador>  selectAll(){
        String sql = "SELECT id, nome, cpf FROM agencia.comprador";
        Connection conn = ConexaoFactory.getConexao();
        List<Comprador> compradorList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
             compradorList.add(new Comprador(rs.getInt("id"),rs.getString("cpf"),rs.getString("nome")));
            }
            ConexaoFactory.close(conn, stmt);
           return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
