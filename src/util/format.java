/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author VITON W7
 */
public class format {
    
    /**
     * 
     * @param formatar verifica se é para formatar o numero ou para tirar a formatacao
     * @param telefone telefone a ser formatado ou retirado a formatacao
     * @return 
     */
    public static String telefone(boolean formatar, String telefone){
        String tel = null;
        
        if(formatar == true){
            
        }
        
        if(formatar == false){
                tel = telefone.replace('(', ' ');
                tel = tel.replace(')', ' ');
                tel = tel.replace('-', ' ');
                tel = tel.replaceAll(" ", "");
        }
        return tel;
    }
    
    /**
     * 
     * @param formatar verifica se é para formatar o numero ou para tirar a formatacao
     * @param telefone telefone a ser formatado ou retirado a formatacao
     * @return 
     */
    public static String celular(boolean formatar, String celular){
        String cel = null;
        
        if(formatar == true){
            
        }
        
        if(formatar == false){
                cel = celular.replace('(', ' ');
                cel = cel.replace(')', ' ');
                cel = cel.replace('-', ' ');
                cel = cel.replaceAll(" ", "");
        }
        return cel;
    }
}
