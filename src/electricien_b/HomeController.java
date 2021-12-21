/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricien_b;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author sa
 */
public class HomeController implements Initializable {

    @FXML
    private AnchorPane pane_home;
    @FXML
    private ScrollPane scroll;
    @FXML
    private JFXButton acc;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("accueil.fxml"));
            scroll.setContent(root);
            scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void accueil(ActionEvent event){
        Parent root;
        try {
           
            root = FXMLLoader.load(getClass().getResource("projet_employé.fxml"));
            scroll.setContent(root);
            scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }

    @FXML
    private void Paramètres(ActionEvent event) {
    }

    @FXML
    private void employé(ActionEvent event) {
        
        Parent root;
        try {
           
            root = FXMLLoader.load(getClass().getResource("employé.fxml"));
            scroll.setContent(root);
            scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        img1.setImage(new Image("/img/za.gif"));
        img2.setImage(null);
        img3.setImage(null);
        img4.setImage(null);
        img5.setImage(null);    
    }

    @FXML
    private void projet(ActionEvent event) {
     
        Parent root;
        try {
           
            root = FXMLLoader.load(getClass().getResource("projet.fxml"));
            scroll.setContent(root);
            scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        img1.setImage(new Image("/img/unnamed.gif"));
        img2.setImage(null);
        img3.setImage(null);
        img4.setImage(null);
        img5.setImage(null);
    }

    @FXML
    private void entrepreneur(ActionEvent event) {
     
        Parent root;
        try {
           
            root = FXMLLoader.load(getClass().getResource("entrepreneur.fxml"));
            scroll.setContent(root);
            scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        img1.setImage(new Image("/img/em.gif"));
        img2.setImage(null);
        img3.setImage(null);
        img4.setImage(null);
        img5.setImage(null);
    }

    @FXML
    private void hom(MouseEvent event) {
      
        Parent root;
        try {
           
            root = FXMLLoader.load(getClass().getResource("accueil.fxml"));
            scroll.setContent(root);
            scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
   img1.setImage(new Image("/img/e.jpg"));
        img2.setImage(new Image("/img/e1.jpg"));
        img3.setImage(new Image("/img/e3.jpg"));
        img4.setImage(new Image("/img/e4.jpg"));
        img5.setImage(new Image("/img/e5.jpg"));
    }
    
}
