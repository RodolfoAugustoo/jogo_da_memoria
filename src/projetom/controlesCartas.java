/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetom;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import static projetom.Estados.ENCONTRADO;

/**
 *
 * @author RodolfoAugustodeOliv
 */
public class controlesCartas {

    private String nomeCarta;
    private ArrayList<Carta> regrasCartas;

    

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

    /*
    private void alteraVisualCartas(Carta carta) {
        //PRECISO SABER A CARTA QUE ESTOU ALTERANDO
        Estados estado = this.regrasCartas.get(carta);

        switch (estado) {
            case INICIAL:
                carta.setCor(Color.LIGHT_GRAY);
                break;
            case SELECIONADO:
                carta.setCor(Color.YELLOW);
                break;
            case ENCONTRADO:
                carta.setBorda(Color.PINK);
                break;
        }
    }*/

    /*
    public void zerarCartas() {
        alterarTodasCartas(Estados.INICIAL);
    }*/

    /*
    public void alterarTodasCartas(Estados estado) {
        //PERCORRE A LISTA DE CARTAS E ALTERA TODOS ESTADOS
        // E O VISUAL
        for (Carta carta : this.regrasCartas.keySet()) {
            selecaoCarta(carta, estado);
            alteraVisualCartas(carta);
        }
    }*/

    /*
    AÇÃO DOS ESTADOS DAS CARTAS
     */
    /*
    public void executarAcaoCartas(Carta carta, Estados estado) {
        selecaoCarta(carta, estado);
        if (verificaTodasCartas()) {
            alterarTodasCartas(ENCONTRADO);
        } else {
            alteraVisualCartas(carta);
        }
    }*/

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

    public boolean clique(Point cursor) {
        //Rectangle r = new Rectangle();
        System.out.println(regrasCartas.size());
        for (Carta carta : this.regrasCartas) {
            /*
                VERIFICA SE O CLIQUE FOI DENTRO DA AREA DE ALGUMA CARTA
             */
            System.out.println(carta.x + " " + carta.largura + carta.x);
            System.out.println(carta.y + " " + carta.altura + carta.y);
            System.out.println(cursor.x);
            System.out.println(cursor.y);

            if (carta.rect.contains(cursor)) {
                return true;
            }
        }
        return false;
    }

}
