/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.test;

import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model.Modalidade;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicolas Scopel
 */
public class TestePersistenciaModalidade {
    
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public TestePersistenciaModalidade() {
    }
    
    @Before
    public void setUp() {
        
        jpa.conexaoAberta();
    }
    
    @After
    public void tearDown() {
        
        jpa.fecharConexao();
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void testePersistenciaModalidade() throws Exception {
     
     Modalidade m = new Modalidade();
     
     m.setDescricao("FitDance");
     
     jpa.persist(m);
     
     //buscar objeto persistido
        Modalidade persistidoModalidade = (Modalidade)jpa.find(Modalidade.class, m.getId());
        
        //verificar se objeto persistido é igual ao
        Assert.assertEquals(m.getDescricao(), persistidoModalidade.getDescricao());
     
     
     }
}
