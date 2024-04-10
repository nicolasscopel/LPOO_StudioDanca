/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 20222PF.CC0019
 */

@Entity
@Table(name = "tb_alunos")
@DiscriminatorValue("A")
public class Alunos extends Pessoas {
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar dataInicio;
    
    @Column(nullable = false)
    private Integer dataPgto;

    
    
    
    public Alunos() {
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Integer getDataPgto() {
        return dataPgto;
    }

    public void setDataPgto(Integer dataPgto) {
        this.dataPgto = dataPgto;
    }
    
    
    
}
