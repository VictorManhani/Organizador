/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import model.bean.Produto;

/**
 *
 * @author VITON W7
 */
public class ProdutoDAO {
    public static ArrayList<Produto> puxarTodosProdutos(){
        ArrayList<Produto> produtos = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            pst = con.prepareStatement("select * from produto");
            rs = pst.executeQuery();
            while(rs.next()){
                int idProduto = rs.getInt("idProduto");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                produtos.add(new Produto(idProduto, nome, preco));
            }
        }catch (SQLException ex) {
            throw new RuntimeException("Conexão não feita!");
        }finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return produtos;
    }
    
    public static void cadastrarProduto(Produto produto){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        
        try{
            pst = con.prepareStatement("insert into produto (nome, preco) values (?, ?);");
            pst.setString(1, produto.getNome());
            pst.setDouble(2, produto.getPreco());
            pst.executeUpdate();
        }catch(SQLException ex){
            throw new RuntimeException("Conexão não feita!");
        }finally{
            ConnectionFactory.closeConnection(con, pst);
        }
    }
    
    public static void deletarProduto(Produto produto){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        
        try{
            pst = con.prepareStatement("delete from produto where idProduto = ?;");
            pst.setInt(1, produto.getIdProduto());
            pst.executeUpdate();
        }catch(SQLException ex){
            throw new RuntimeException("Conexão não feita!");
        }finally{
            ConnectionFactory.closeConnection(con, pst);
        }
    }    
}
