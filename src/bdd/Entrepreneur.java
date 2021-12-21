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
public class Entrepreneur {
 String name, prenom,source_ing, adresse,email;
 int    id, tlf;

    public Entrepreneur() {
    }

    public Entrepreneur(int id, String name, String prenom, String adresse,  String email,String source_ing, int tlf) {
        this.name = name;
        this.prenom = prenom;
        this.source_ing = source_ing;
        this.adresse = adresse;
        this.email = email;
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

    public String getEmail() {
        return email;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }
    
    
  
}
