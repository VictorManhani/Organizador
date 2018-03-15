/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Victor G Manhani
 */
public class Cliente {
    
    /**
     * atributos do cliente
     */
    private String nome, telefone, celular, bairro, zona, produto, data, hora;
    private int idCliente;
    private Date data2;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    /**
     * Dados dos Clientes com Data (usado para obter clientes do banco de dados e atualizar eles)
     * @param idCliente recebe o idCliente do cliente
     * @param nome recebe o nome do cliente
     * @param telefone recebe o telefone fixo do cliente
     * @param celular recebe o celular do cliente
     * @param bairro recebe o bairro do cliente
     * @param zona recebe a zona do cliente
     * @param produto recebe o produto que o cliente quer comprar
     * @param data recebe a data que o cliente ligou
     * @param hora recebe a hora que o cliente ligou
     */
    public Cliente(int idCliente, String nome, String telefone, String celular, String bairro, String zona, String produto, String data, String hora){
        this.setIdCliente(idCliente);
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setCelular(celular);
        this.setBairro(bairro);
        this.setZona(zona);
        this.setProduto(produto);
        this.setData(data);
        this.setHora(hora);
    }
    
    /**
     * Dados dos Clientes (usado para cadastrar clientes)
     * @param nome recebe o nome do cliente
     * @param telefone recebe o telefone fixo do cliente
     * @param celular recebe o celular do cliente
     * @param bairro recebe o bairro do cliente
     * @param zona recebe a zona do cliente
     * @param produto recebe o produto que o cliente quer comprar
     * @param hora recebe a hora que o cliente ligou
     */
    public Cliente(String nome, String telefone, String celular, String bairro, String zona, String produto, String hora){
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setCelular(celular);
        this.setBairro(bairro);
        this.setZona(zona);
        this.setProduto(produto);
        this.setData(this.getData());
        this.setHora(hora);  
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }
    /**
     * @return the nome
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param nome the nome to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    /**
     * @return the zona
     */
    public String getZona() {
        return zona;
    }

    /**
     * @param zona the zona to set
     */
    public void setZona(String zona) {
        this.zona = zona;
    }

    /**
     * @return the produto
     */
    public String getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(String produto) {
        this.produto = produto;
    }

    /**
     * @return the data
     */
    public String getData() {
        this.data2 = new Date();
        this.data = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(this.data2);
        //LocalDate data3 = java.time.LocalDate.now();
        return this.data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    /**
     * @return o idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param hora O idCliente é modificado
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
