/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

/**
 *
 * @author sa
 */
public class Employé {
 String name, prenom,source_ing, adresse;
 int    id, tlf; 

    public Employé() {
    }

    public Employé( int id,String name, String prenom, String adresse, String source_ing, int tlf) {
        this.name = name;
        this.prenom = prenom;
        this.source_ing = source_ing;
        this.adresse = adresse;
        this.id = id;
        this.tlf = tlf;
    }

    public String getName() {
        return name;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSource_ing() {
        return source_ing;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getId() {
        return id;
    }

    public int getTlf() {
        return tlf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSource_ing(String source_ing) {
        this.source_ing = source_ing;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }
 
}
