package JDBC.conn.test;

import JDBC.conn.classes.Comprador;
import JDBC.conn.db.CompradorDB;

import java.util.List;

public class TesteConexão {
    public static void main(String[] args) {
        deletar();
        atualizar();
        List<Comprador> listaComprador = selecionarTudo();
        System.out.println(listaComprador);
    }

    public static void inserir() {
        Comprador comprador = new Comprador("116.754.458-12", "Aline Mendonça Ferreira");
        CompradorDB.save(comprador);


    }
    public static void deletar() {
        Comprador comprador = new Comprador();
        comprador.setId(2);
        CompradorDB.delete(comprador);


    }
    public static void atualizar() {
        Comprador comprador = new Comprador(1,"478.987.765-15","Maria Eduarda Costa");
        CompradorDB.update(comprador);


    }
    public static List<Comprador> selecionarTudo() {
        return CompradorDB.selectAll();
    }
}
