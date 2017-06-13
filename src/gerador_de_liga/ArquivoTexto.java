/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador_de_liga;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Humberto
 */
public class ArquivoTexto {
    
    private ArrayList<Time> times = new ArrayList();
    public void ler(String caminho) throws ParseException{
      
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            
            try {
                linha = lerArq.readLine();
                
                while(linha!=null){
                    // Loop onde se captura os dados do arquivo texto e instancia as classes em seus respectivos objetos
                    String time = linha;
                    if(!ehRepetido(time))
                        times.add(new Time(time));                 
                    
                    linha = lerArq.readLine();
                }
                arq.close();
            
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            
        }
       
    }
    
    public ArrayList<Time> obtemListaDeTimes(){
        return this.times;
    }
    
    private boolean ehRepetido(String time){
        
        for(Time t: times)
            if(t.obtemNome().equals(time))
                return true;
        return false;
    }
}
