/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetom;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author RodolfoAugustodeOliv
 */
public class controlesCartas {

    private String nomeCarta;
    private ArrayList<Carta> regrasCartas = new ArrayList();
    private ArrayList<Carta> selecionados = new ArrayList();

    public String getNomeCarta() {
        return nomeCarta;
    }

    public void setNomeCarta(String nomeCarta) {
        this.nomeCarta = nomeCarta;
    }

    public ArrayList<Carta> getRegrasCartas() {
        return regrasCartas;
    }

    public void setRegrasCartas(ArrayList<Carta> regrasCartas) {
        this.regrasCartas = regrasCartas;
    }

    public void criaCartas(Carta carta) {
        //INICIA A CARTA COMO INICIAL
        this.regrasCartas.add(carta);
    }

    public void selecaoCarta(Carta carta) {
        //altera seleção das cartas
        this.regrasCartas.add(carta);
    }

    public ArrayList<Carta> getSelecionados() {
        return selecionados;
    }

    public void setSelecionados(ArrayList<Carta> selecionados) {
        this.selecionados = selecionados;
    }

    public boolean verificaTodasCartas() {
        for (Carta c : this.regrasCartas) {
            /*
            nem todas cartas foram selecionadas
             */
            if (c.getEstado() != Estados.SELECIONADO) {
                return false;
            }
        }
        /*
        todas cartas já foram selecionadas
         */
        return true;
    }

    public void alteraEstado(Estados estado) {
        for (Carta c : selecionados) {
            c.setEstado(estado);
            c.alteraImg();
        }
    }

    public boolean clique(Point cursor) {
        //Rectangle r = new Rectangle();
        System.out.println(regrasCartas.size());

        for (Carta carta : this.regrasCartas) {
            /*
                VERIFICA SE O CLIQUE FOI DENTRO DA AREA DE ALGUMA CARTA
             */            
            if (carta.rect.contains(cursor)) {
                selecionados.add(carta);
                return true;
            }
        }
        return false;
    }

    public boolean comparaCarta(ArrayList<Carta> cartas) {

        if (cartas.get(0).caminho.equals(cartas.get(1).caminho)) {

            cartas.get(0).setEstado(Estados.ENCONTRADO);
            cartas.get(0).imgEncontrado();
            
            cartas.get(1).setEstado(Estados.ENCONTRADO);
            cartas.get(1).imgEncontrado();

            return true;
        } else {
            
            cartas.get(0).setEstado(Estados.INICIAL);
            cartas.get(1).setEstado(Estados.INICIAL);
            return false;
        }
    }
    
   

}
