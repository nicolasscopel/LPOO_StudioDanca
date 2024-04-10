/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 20222PF.CC0019
 */

@Entity
@Table (name = "tb_pagamentos")
public class Pagamentos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id; 
    
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar dataVcto;
    
    @Column(nullable = false, precision = 2)
    private Double valor;
    
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar dataPgto;
    
    @Column(nullable = false, precision = 2)
    private Double valorPgto;

    
    
    
    
    public Pagamentos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataVcto() {
        return dataVcto;
    }

    public void setDataVcto(Calendar dataVcto) {
        this.dataVcto = dataVcto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getDataPgto() {
        return dataPgto;
    }

    public void setDataPgto(Calendar dataPgto) {
        this.dataPgto = dataPgto;
    }

    public Double getValorPgto() {
        return valorPgto;
    }

    public void setValorPgto(Double valorPgto) {
        this.valorPgto = valorPgto;
    }
    
    
    
    
    
}
