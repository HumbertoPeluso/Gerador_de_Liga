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
    public Grupo(ArrayList<Time> times){
        this.listaDeTimes = times;
    }
    
    public String geraConfronto(){
        ArrayList<Time> timeLocal = new ArrayList();
        ArrayList<Time> timeVisitante = new ArrayList();
        Time apoio=null;
        String resultado = "";
        
        if(!qntdeDeTimesEhPar(listaDeTimes))
            listaDeTimes.add(new Time("fake", true));
        
        for(int i=0; i<listaDeTimes.size()/2;i++)
            timeLocal.add(listaDeTimes.get(i));
                    
        for(int i=listaDeTimes.size()/2;i<listaDeTimes.size();i++)
            timeVisitante.add(listaDeTimes.get(i));
        
        for(int i = 1;i<listaDeTimes.size();i++){
            
            for(int j = 0; j<timeLocal.size();j++){
                if(!timeLocal.get(j).ehFake() && !timeVisitante.get(j).ehFake())
                    resultado = resultado + timeLocal.get(j).obtemNome() + " " + "X" + " " + timeVisitante.get(j).obtemNome() + "\n";
            }
            
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
    
    
    private boolean qntdeDeTimesEhPar(ArrayList<Time> t){
        if(t.size()%2 == 0)
            return true;
        return false;
    }
}
