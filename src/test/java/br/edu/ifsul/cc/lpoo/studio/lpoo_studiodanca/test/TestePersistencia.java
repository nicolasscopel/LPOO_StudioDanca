/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.test;

import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model.Contratos;
import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model.FormaPgto;
import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model.Modalidade;
import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model.Pacotes;
import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model.Pagamentos;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicolas Scopel
 */

public class TestePersistencia {
    
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public TestePersistencia() {
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
    //@Test
     public void testePersistenciaModalidade() throws Exception {
     
     Modalidade m = new Modalidade();
     
     m.setDescricao("Dança Livre");
     
     jpa.persist(m);
     
     //buscar objeto persistido
        Modalidade persistidoModalidade = (Modalidade)jpa.find(Modalidade.class, m.getId());
        
        //verificar se objeto persistido é igual ao
        Assert.assertEquals(m.getDescricao(), persistidoModalidade.getDescricao());
     
     
     }
     
     
    //@Test
     public void testePersistenciaPagamento() throws Exception{
         
         Pagamentos p = new Pagamentos();
         
         String data =  "10/04/2024";
         
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         Calendar c = Calendar.getInstance();     
         c.setTime(sdf.parse(data));
         
         p.setDataPgto(c);
         p.setDataVcto(c);
         p.setValor(140.00);
         p.setValorPgto(140.00);
         
         jpa.persist(p);
         
     }
     
     
      //@Test 
      public void testePersistenciaPacoteModalidade() throws Exception{
         
         
         Pacotes p = new Pacotes();
         p.setDescricao("Pacote Nicolas");
         p.setValor(140.00);
         
         Modalidade m = new Modalidade();
         m.setDescricao("Dança Livre");
         
         jpa.persist(m);
       
         p.setModalidade(m);
         
   
         
         jpa.persist(p);
     }
      
      
      //@Test 
      public void testePersistenciaContratosPagamentos() throws Exception{
         
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         
         
         Contratos c = new Contratos();
         c.setFormapgto(FormaPgto.PIX);
         c.setValorDesconto(10.00);
         
         c.setDataInicio(Calendar.getInstance());
         
        
         jpa.persist(c); //PERSISTIU CONTRATO
         
         
         Pagamentos p = new Pagamentos();
         p.setContrato(c);
      
         String data =  "16/04/2024";
         
        
         Calendar cal = Calendar.getInstance();     
         cal.setTime(sdf.parse(data));
         
         p.setDataPgto(cal);
         p.setDataVcto(cal);
         
         p.setValor(140.00);
         p.setValorPgto(140.00);
        
        jpa.persist(p); //PERSISTIU PAGAMENTO
     }
}
