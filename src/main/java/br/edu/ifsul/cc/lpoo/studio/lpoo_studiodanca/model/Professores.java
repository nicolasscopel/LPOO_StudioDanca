/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model;

import java.io.Serializable;
import java.util.ArrayList;
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
public class Professores extends Pessoas implements Serializable {
    
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar dataAdmissao;
    
    
   //    Validação do Mapeamento Bidirecional: Garantir que o mapeamento @OneToMany em Professor 
   //    e @ManyToOne em FolhaPagamento estejam corretamente configurados para refletir o relacionamento bidirecional.
    @OneToMany(mappedBy = "professor")
    private List<FolhaPagamento> holerites= new ArrayList<>();
    
    
    //    Validação do Mapeamento Bidirecional: Garantir que o mapeamento @OneToMany em Professor 
    //    e @ManyToOne em Modalidade estejam corretamente configurados para refletir o relacionamento bidirecional.
    @OneToMany(mappedBy = "professor")
    private List<Modalidade> modalidades = new ArrayList<>();

    
    public Professores() {
        //inicialização das listas holerites e modalidades no construtor para evitar NullPointerException
        holerites = new ArrayList<>();    
    }

    
    
     public Calendar getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Calendar dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public List<FolhaPagamento> getHolerites() {
        return holerites;
    }

    public void addFolhaPagamentoMes(FolhaPagamento f) {
        holerites.add(f);
    }
    
    
    public List<Modalidade> getModalidades() {
        return modalidades;
    }

    public void addModalidade(Modalidade m) {
        modalidades.add(m);
        m.setProfessor(this);
       
    }
    
   
    
    
    
    
}


