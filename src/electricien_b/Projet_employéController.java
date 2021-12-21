/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricien_b;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author sa
 */
public class Projet_employéController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Circle imgUser1;
    @FXML
    private TableView<?> tabV;
    @FXML
    private TableColumn<?, ?> id_t;
    @FXML
    private TableColumn<?, ?> adresse_t;
    @FXML
    private TableColumn<?, ?> entreprenete_t;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField prenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        img.setImage(new Image("/img/t.PNG"));
    }    

    @FXML
    private void table(MouseEvent event) {
    }
    
}
