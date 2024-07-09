/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author 20222PF.CC0019
 */

@Entity
@Table (name = "tb_itenscontrato")
public class ItensContrato implements Serializable{

   @Id
   private Integer idContrato;
   
   @Id
   private Integer idPacode;

    @ManyToOne
    @JoinColumn(name = "pacote_id", nullable = false)
    private Pacotes pacote;
   
    public ItensContrato() {
    }

    
    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public Integer getIdPacode() {
        return idPacode;
    }

    public void setIdPacode(Integer idPacode) {
        this.idPacode = idPacode;
    }

    public Pacotes getPacote() {
        return pacote;
    }

    public void setPacote(Pacotes pacote) {
        this.pacote = pacote;
    }
   
   
    
}
