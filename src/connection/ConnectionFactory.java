/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.*;
/**
 *
 * @author VITON W7
 */
public class ConnectionFactory {
    public final static String driver = "com.mysql.jdbc.Driver";
    public final static String url = "jdbc:mysql://localhost/globalreciclagem?useSSL=false";
    public final static String user = "root";
    public final static String pass = "root";
    
    public static Connection getConnection(){
        try{
            Class.forName(driver);
            return DriverManager.getConnection(url, user, pass);
        }catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException("Erro de conexão com o Banco de Dados!");
        }
    }
    
    /**
     * 
     * @param con É o parâmetro de conexão aberta.
     * Este método fecha a conexão que está aberta.
     */
    public static void closeConnection(Connection con){
        try{
            if(con != null)con.close();
        }catch(SQLException e){
            throw new RuntimeException("Erro de desconexão com o Banco de Dados!");
        }
    }
    
    /**
     * 
     * @param con É o parâmetro de conexão aberta.
     * @param pst É o parâmetro de preparamento das querys do sql.
     * Este método fecha a conexão que está aberta.
     */
    public static void closeConnection (Connection con, PreparedStatement pst) {
        try {
            if (pst != null) pst.close();
            closeConnection(con);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro de desconexão com o BD.");
        }
    }

    /**
     * 
     * @param con É o parâmetro de conexão aberta.
     * @param pst É o parâmetro de preparamento das querys do sql.
     * @param rs  É o parâmetro que nos retorna a tabela de arquivo do nosso banco de dados.
     * Este método fecha a conexão que está aberta.
     */
    public static void closeConnection (Connection con, PreparedStatement pst, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            closeConnection(con,pst);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro de desconexão com o BD.");
        }
    }
}
