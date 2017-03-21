/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTabela;

/**
 *
 * @author Vinicius Alves
 */
public class ItemPesquisa {
    
    private int id_pesquisa;
    private Cliente cliente;
    private String nome_pesquisa;

    /**
     * @return the id
     */
    public int getId() {
        return id_pesquisa;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id_pesquisa = id;
    }

    /**
     * @return the id_Cliente
     */
  
    /**
     * @return the nome_pesquisa
     */
    public String getNome_pesquisa() {
        return nome_pesquisa;
    }

    /**
     * @param nome_pesquisa the nome_pesquisa to set
     */
    public void setNome_pesquisa(String nome_pesquisa) {
        this.nome_pesquisa = nome_pesquisa;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
