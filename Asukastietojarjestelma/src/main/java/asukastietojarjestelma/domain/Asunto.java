
package asukastietojarjestelma.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Luokka sisältää asuntojen tiedot ja metodeja niiden muokkaamiseen
 */
public class Asunto {
    /* ... */
    private String talo;
    private String asuntonro;
    private int huonemaara;
    private double pA;
    private int vuokra;
    private boolean onkoVuokrattu;
    private Vuokrasopimus sopimus;
    private List<Vuokrasopimus> vuokrasopimukset;
    
    public Asunto(String talo, String asuntonro, int huonemaara, double pA) {
        this.talo = talo;
        this.asuntonro = asuntonro;
        this.huonemaara = huonemaara;
        this.pA = pA;
        this.vuokra = 0;
        this.onkoVuokrattu = false;
        this.sopimus = null;
        this.vuokrasopimukset = new ArrayList<Vuokrasopimus>();
    }
    
    // GETTERIT
    public String getOsoite() {
        return this.talo + " " + this.asuntonro;
    }
    
    public String getTalo() {
        return this.talo;
    }
    
    public String getAsuntonro() {
        return this.asuntonro;
    }
    
    public int getVuokra() {
        return this.vuokra;
    }
    
    public boolean onkoVuokrattu() {
        return this.onkoVuokrattu;
    }
    
    public Vuokrasopimus getVuokrasopimus() {
        return this.sopimus;
    }
    
    public int getHuonemaara() {
        return this.huonemaara;
    }
    
    public double getpA() {
        return this.pA;
    }
    
    //SETTERIT
    public void setVuokra(int vuokra) {
        this.vuokra = vuokra;
    }
    
    public String vuokraa(Vuokrasopimus sopimus) {
        if (this.onkoVuokrattu == false) {
            this.sopimus = sopimus;
            this.onkoVuokrattu = true;
            this.vuokrasopimukset.add(sopimus);
            return "Vuokraus onnistui!";
        } else {
            return "Asunto on jo vuokrattu! Päätä edellinen vuokrasopimus.";
        } 
    }
    
    public void paataVuokrasopimus() {
        if (this.onkoVuokrattu) {
            this.sopimus = null;
            this.onkoVuokrattu = false;
        } else {
            System.out.println("Asuntoa ei ole vuokrattu, vuokrasopimusta ei voida päättää.");
        }
    }
    
    // MUUT
    
    @Override
    public String toString() {
        if (this.onkoVuokrattu) {
            return this.talo + " " + this.asuntonro + 
                   "\n pohjaratkaisu: "+ this.huonemaara + "h " + this.pA + "m2" +
                   "\n vuokra: " + this.vuokra +" euroa" +
                   "\n " + this.sopimus.tiedotIlmanAsuntoa();
        }
        return this.talo + " " + this.asuntonro + 
                   "\n pohjaratkaisu: "+ this.huonemaara + "h " + this.pA + "m2" +
                   "\n vuokra: " + this.vuokra +" euroa" +
                   "\n Asunto on vapaa";
    }
    
}
