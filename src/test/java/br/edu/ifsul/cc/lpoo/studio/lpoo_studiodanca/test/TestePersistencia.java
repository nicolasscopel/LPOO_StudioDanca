/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.test;

import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model.Alunos;
import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model.Contratos;
import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model.FolhaPagamento;
import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model.FormaPgto;
import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model.Modalidade;
import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model.Pacotes;
import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model.Pagamentos;
import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model.Pessoas;
import br.edu.ifsul.cc.lpoo.studio.lpoo_studiodanca.model.Professores;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
         
         //c.setDataInicio(Calendar.getInstance()); //COMENTADO POIS FOI SETADO NO CONSTRUTOR
         
        
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
      
      
      //@Test
      public void testePersistenciaAlunoProfessorPessoas () throws Exception{
          
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          Alunos a = new Alunos();
         
          
          String dataAniver = "20/12/2002";
          String dataInicio = "01/03/2024";
          
          a.setNome("Nicolas"); //NOME PESSOA
            
          a.setEmail("teste@teste.com"); // EMAIL PESSOA
          
          Calendar cal = Calendar.getInstance();
          cal.setTime(sdf.parse(dataAniver));
          a.setDataAniver(cal); //DATA ANIVERSARIO PESSOA
          
          a.setEndereco("Rua dos Andradas"); //ENDEREÇO PESSOA
          
          a.setFone("54999887766"); //TELEFONE PESSOA
          
          cal = Calendar.getInstance();
          cal.setTime(sdf.parse(dataInicio));
          a.setDataInicio(cal); //DATA  ALUNO INICIO
          
          a.setDataPgto(10); //DATA ALUNO PAGAMENTO
          
          jpa.persist(a);

        
        
          Professores p = new Professores();
          //List folhasPagamento = new ArrayList();
          
          String dataAdms = "10/01/2024";
          String dataAniverProf = "30/04/1990";
          
          Calendar calAdms = Calendar.getInstance();
          calAdms.setTime(sdf.parse(dataAdms));
          p.setDataAdmissao(calAdms); //DATA ADMISSAO PROFESSOR
          
          Calendar dataAnProf = Calendar.getInstance();
          dataAnProf.setTime(sdf.parse(dataAniverProf));
          p.setDataAniver(dataAnProf); //ANIVERSARIO PESSOA
          
          p.setNome("Professor"); //NOME PESSOA
          
          p.setEmail("professor@teste.com"); // EMAIL PESSOA
          
          p.setEndereco("Rua dos Professores"); //ENDEREÇO PESSOA
          
          p.setFone("54999887766"); //TELEFONE PESSOA
            
 
          jpa.persist(p);
          
      }
      
      //@Test
      public void testePersistenciaFolhasPagamentos () throws Exception{
          
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          
          Professores p =  new Professores();
           
          
          p.setDataAdmissao(Calendar.getInstance());
         
          p.setNome("Professor Teste Find"); //NOME PESSOA
          
          p.setEmail("professor@teste.com"); // EMAIL PESSOA
          
          p.setEndereco("Rua dos Professores"); //ENDEREÇO PESSOA
          
          p.setFone("54999887766"); //TELEFONE PESSOA
          
       
          p.setDataAniver(Calendar.getInstance());
          
          FolhaPagamento f =  new FolhaPagamento();
          
          f.setValorReceber(200.00);
          
          Calendar cal = Calendar.getInstance();
          cal.setTime(sdf.parse("05/05/2024"));
          f.setDataPagamento(cal);
          
          f.setProfessor(p);
          
         
          jpa.persist(p);
          
          jpa.persist(f);
          
        
          
          //Professores teste = (Professores)jpa.find(Professores.class, 1);
          //System.out.println("Nome professor: " + teste.getNome());
      }
      
      
}
