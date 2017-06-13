/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador_de_liga;

import java.text.ParseException;

/**
 *
 * @author Humberto
 */
public class Gerador_de_Liga {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        String caminho = "times.txt";
        ArquivoTexto arquivo = new ArquivoTexto();
        arquivo.Ler(caminho);
        
        if(arquivo.obtemListaDeTimes().size()>2){
            Grupo grupo = new Grupo(arquivo.obtemListaDeTimes());
          System.out.println(grupo.geraConfronto());
        }
        else{
            System.out.println("Não há times suficientes");
        }
       
    }
    
}
