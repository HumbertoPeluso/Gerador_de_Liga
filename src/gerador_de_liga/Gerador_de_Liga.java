/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador_de_liga;

import java.text.ParseException;
import java.util.Scanner;

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
             //Este bloco captura as entradas pelo teclado do usuário.
        Scanner entradaArquivoTexto = new Scanner(System.in);
        Scanner entradaJogosDeIdaEVolta = new Scanner(System.in);
        System.out.print("Digite o caminho do arquivo com os times: ");
        String caminho =entradaArquivoTexto.next();
        System.out.print("Confronto de jogos de ida e volta? s/n: ");
        String idaEVolta = entradaJogosDeIdaEVolta.next();
        System.out.println();
        
        //Aqui é inciado o objeto arquivo onde será lido o arquivo txt e os dados necessários capturados.
        ArquivoTexto arquivo = new ArquivoTexto();
        arquivo.ler(caminho);
        
        //Só será gerado os confrontos se houver pelo menos três times no grupo
        if(arquivo.obtemListaDeTimes().size()>2){
            Grupo grupo = new Grupo(arquivo.obtemListaDeTimes());
            System.out.println(grupo.geraConfronto());
            
            System.out.println("-----------------------------------------------");
            //Verifica se será necessário gerar os confrontos do segundo turno
            if(idaEVolta.equals("s"))
            System.out.print(grupo.geraconfrontoSegundoTurno());
        }
        else{
            System.out.println("Não há times suficientes");
        }
       
    }
    
}
