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
public class projet {
      int id;
   String name,adresse,img,entrepreneur;
   double cout;

    public projet() {
    }

    public projet(int id, String name, String adresse, String entrepreneur, String img, double cout) {
        this.id = id;
        this.name = name;
        this.adresse = adresse;
        this.img = img;
        this.entrepreneur = entrepreneur;
        this.cout = cout;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getImg() {
        return img;
    }

    public String getEntrepreneur() {
        return entrepreneur;
    }

    public double getCout() {
        return cout;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setEntrepreneur(String entrepreneur) {
        this.entrepreneur = entrepreneur;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }
   
}
