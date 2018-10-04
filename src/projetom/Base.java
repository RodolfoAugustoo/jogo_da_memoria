/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetom;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author RodolfoAugustodeOliv
 */
public abstract class Base {
    protected int x = 0;
    protected int y = 0;
    protected int incX = 1;
    protected int incY = 1;
    protected Color cor = Color.BLACK;
    protected Color borda = Color.GREEN;
    protected int largura = 100;
    protected int altura = 100;
    protected Rectangle rect = new Rectangle(0, 0, 100, 100);
    protected ImageIcon img;
    public String caminho;
    public String fundo;
    public String virou = "IMG/verso.png";
    
    
    public Base(String url,String frente){
        
       img     = new ImageIcon(this.getClass().getResource("/"+ url));
       largura = img.getIconWidth();
       altura  = img.getIconHeight();      
       rect.height = altura;
       rect.width = largura;
       this.caminho = frente;
       this.fundo = url;
    }
    
    public void alteraImg(){
      img = new ImageIcon(this.getClass().getResource("/"+ caminho));

    }
    
    public void esconde(){
      img = new ImageIcon(this.getClass().getResource("/"+ fundo));
    }
    
    public void imgEncontrado(){
        img = new ImageIcon(this.getClass().getResource("/"+ virou));
    }

    public int getX() {
        return x;
        
    }

    public void setX(int x) {
        this.x = x;
        rect.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        rect.y = y;
    }

    public int getIncX() {
        return incX;
    }

    public void setIncX(int incX) {
        this.incX = incX;
    }

    public int getIncY() {
        return incY;
    }

    public void setIncY(int incY) {
        this.incY = incY;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public Color getBorda() {
        return borda;
    }

    public void setBorda(Color borda) {
        this.borda = borda;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
        this.rect.width = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
        this.rect.height = altura;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }
    
    public void desenhar(Graphics g){       
        if(img != null){
         g.drawImage(img.getImage(), x, y, largura,altura,null);
        }
    }
}
