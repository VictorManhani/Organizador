/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import model.bean.Cliente;

/**
 *
 * @author Victor G Manhani
 */
public class ClienteDAO {
    public static ArrayList<Cliente> puxarTodosClientes(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            pst = con.prepareStatement("select * from cliente");
            rs = pst.executeQuery();
            while(rs.next()){
                int idCliente = rs.getInt("idCliente");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String celular = rs.getString("celular");
                String bairro = rs.getString("bairro");
                String zona = rs.getString("zona");
                String produto = rs.getString("produto");
                String data = rs.getString("data");
                String hora = rs.getString("hora");
                clientes.add(new Cliente(idCliente, nome, telefone, celular, bairro, zona, produto, data, hora));
            }
        }catch (SQLException ex) {
            throw new RuntimeException("Conexão não feita!");
        }finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return clientes;
    }
    
    public static void cadastrarCliente(Cliente cliente){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        
        try {
            pst = con.prepareStatement("insert into cliente values(0, ?, ?, ?, ?, ?, ?, ?, ?);");
            
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getTelefone());
            pst.setString(3, cliente.getCelular());
            pst.setString(4, cliente.getBairro());
            pst.setString(5, cliente.getZona());
            pst.setString(6, cliente.getProduto());
            pst.setString(7, cliente.getData());
            pst.setString(8, cliente.getHora());
            
            pst.executeUpdate();
        }catch (SQLException ex) {
            throw new RuntimeException("Conexão não feita!");
        }finally {
            ConnectionFactory.closeConnection(con, pst);
        }
    }
    
    public static void atualizarCliente(Cliente cliente, int idCliente, String data){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        
        try {
            pst = con.prepareStatement("update cliente set nome = ?, telefone = ?, celular = ?, bairro = ?, zona = ?, produto = ?, data = ?, hora = ? where idCliente = ?;");
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getTelefone());
            pst.setString(3, cliente.getCelular());
            pst.setString(4, cliente.getBairro());
            pst.setString(5, cliente.getZona());
            pst.setString(6, cliente.getProduto());
            pst.setString(7, data);
            pst.setString(8, cliente.getHora());
            pst.setInt(9, idCliente);
            
            pst.execute();
        }catch (SQLException ex) {
            throw new RuntimeException("Conexão não feita!");
        }finally {
            ConnectionFactory.closeConnection(con, pst);
        }
    }
    
    public static void excluirCliente(int idCliente){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        
        try {
            pst = con.prepareStatement("delete from cliente where idCliente = ?;");
            pst.setInt(1, idCliente);
            pst.execute();
        }catch (SQLException ex) {
            throw new RuntimeException("Conexão não feita!");
        }finally {
            ConnectionFactory.closeConnection(con, pst);
        }
    }
}
