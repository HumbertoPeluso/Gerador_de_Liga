/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador_de_liga;

/**
 *
 * @author Humberto
 */
public class Time {
    private String nome;
    private boolean ehFake = false;
    
    public Time(String nome){
        this.nome = nome;
    }
    public Time(String nome, boolean t){
        this.nome = nome;
        this.ehFake = t;
    }
    
    public String obtemNome(){
        return this.nome;
    }
    public boolean ehFake(){
        return this.ehFake;
    }
    
}
