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
    
    @Override
    public void desenhar(Graphics g){
        g.setColor(cor);
        g.fillRect(x, y, largura, altura);
        g.setColor(borda);
        g.drawRect(x, y, largura, altura);
        estado = Estados.INICIAL;
        
    } 

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }
    
    
}
