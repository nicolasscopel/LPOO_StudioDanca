/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 20222PF.CC0019
 */

@Entity
@Table (name = "tb_contratos")
public class Contratos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar dataInicio;
    
    @Column(nullable = false, precision = 2)
    private Double valorDesconto;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FormaPgto formapgto; // ASSOCIAÇÃO
    
    @OneToMany(mappedBy = "contrato")
    private Collection<ItensContrato> itenscontratos; //AGREGAÇÃO

    public Contratos() {
        dataInicio = Calendar.getInstance();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public FormaPgto getFormapgto() {
        return formapgto;
    }

    public void setFormapgto(FormaPgto formapgto) {
        this.formapgto = formapgto;
    }

    //public Collection<ItensContrato> getItenscontrato() {
    //    return itenscontratos;
    //}

   // public void setItenscontrato(Collection<ItensContrato> itenscontrato) {
   //     this.itenscontratos = itenscontrato;
   // }
    
    
}
