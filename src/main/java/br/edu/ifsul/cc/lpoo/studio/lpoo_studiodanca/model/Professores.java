/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 20222PF.CC0019
 */

@Entity
@Table(name = "tb_professores")
@DiscriminatorValue("P")
public class Professores extends Pessoas {
    
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar dataAdmissao;
    
    
    @OneToMany(mappedBy = "professor")
    private List<FolhaPagamento> folhasPagamento;

    public Professores() {
    }

    public Calendar getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Calendar dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public List<FolhaPagamento> getFolhasPagamento() {
        return folhasPagamento;
    }

    public void setFolhasPagamento(List<FolhaPagamento> folhasPagamento) {
        this.folhasPagamento = folhasPagamento;
    }
    
    
    
    
    
}


