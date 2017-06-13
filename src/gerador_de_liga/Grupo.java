/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador_de_liga;

import java.util.ArrayList;

/**
 *
 * @author Humberto
 */
public class Grupo {
    private ArrayList<Time> listaDeTimes;
    private ArrayList<String> confrontoSegundoTurno = new ArrayList();
    
    public Grupo(ArrayList<Time> times){
        this.listaDeTimes = times;
    }
    
    public String geraConfronto(){
        //Serão criados duas listas: uma com os times que inicialmente jogarão em casa e outra com os times que jogarão fora
        ArrayList<Time> timeLocal = new ArrayList();
        ArrayList<Time> timeVisitante = new ArrayList();
        Time apoio=null;
        String resultado = "";
        
        //Caso o grupo tenha uma quantidade ímpar de times, será acrescentado um time falso para facilitar o cálculo.
        //Os jogos com o time falso não será contado
        if(!qntdeDeTimesEhPar(listaDeTimes))
            listaDeTimes.add(new Time("fake", true));
        
        //preenche a lista com a primeira metade da lista de times que são os que jogarão em casa inicialmente
        for(int i=0; i<listaDeTimes.size()/2;i++)
            timeLocal.add(listaDeTimes.get(i));
        
        //preenche com a segunda metade da lista que são os que jogarão fora inicialmente            
        for(int i=listaDeTimes.size()/2;i<listaDeTimes.size();i++)
            timeVisitante.add(listaDeTimes.get(i));
        
        //Este loop reprenta quantas rodadas terá a liga deste grupo. Ex: em uma liga com 20 times
        //terá 19 rodadas cada turno
        for(int i = 1;i<listaDeTimes.size();i++){
            
            //este loop captura os confrontos de cada rodada
            for(int j = 0; j<timeLocal.size();j++){
                if(!timeLocal.get(j).ehFake() && !timeVisitante.get(j).ehFake()){
                    resultado = resultado + timeLocal.get(j).obtemNome() + " " + "X" + " " + timeVisitante.get(j).obtemNome() + "\n";
                    this.confrontoSegundoTurno.add(timeVisitante.get(j).obtemNome() + " " + "X" + " " + timeLocal.get(j).obtemNome());
                }  
            }
            
            //Aqui serão realocados os objetos na lista 
            for(int j=0;j<timeLocal.size();j++){
                   if((j!=0) && (j!=timeLocal.size()-1)){
                        Time aloca = timeLocal.get(j);
                        timeLocal.remove(j);
                        timeLocal.add(j, apoio);
                        apoio = aloca;
                        timeVisitante.remove(j);
                        timeVisitante.add(j, timeVisitante.get(j));
                        continue;
                    }
                    if(j==timeLocal.size()-1){
                        timeVisitante.remove(j);
                        timeVisitante.add(j, timeLocal.get(j));
                        timeLocal.remove(j);
                        timeLocal.add(j, apoio);
                        continue;
                        
                    }
                    if(j==0){
                        apoio = timeVisitante.get(j);
                        timeVisitante.remove(j);
                        timeVisitante.add(j, timeVisitante.get(j));
                        
                    }
            }
        }
         
         return resultado;   
    }
    
    public String geraconfrontoSegundoTurno(){
        String resultado = "";
        for(int i=confrontoSegundoTurno.size()-1; i>=0; i-- ){
            resultado = resultado + confrontoSegundoTurno.get(i) + "\n";
        }
        return resultado;
    }
    
    
    private boolean qntdeDeTimesEhPar(ArrayList<Time> t){
        if(t.size()%2 == 0)
            return true;
        return false;
    }
}
