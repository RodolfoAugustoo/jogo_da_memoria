/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetom;

import java.awt.Graphics;

/**
 *
 * @author RodolfoAugustodeOliv
 */
public class Carta extends Base{ 
    
    public Estados estado;
    
   
    public Carta(String frente) {
        super("IMG/standard.png",frente);        
        estado = Estados.INICIAL;
    }  

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }
    
    
}
