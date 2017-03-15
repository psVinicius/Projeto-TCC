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
    
    private int id;
    private int id_Cliente;
    private String nome_pesquisa;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the id_Cliente
     */
    public int getId_Cliente() {
        return id_Cliente;
    }

    /**
     * @param id_Cliente the id_Cliente to set
     */
    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

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
    
}
