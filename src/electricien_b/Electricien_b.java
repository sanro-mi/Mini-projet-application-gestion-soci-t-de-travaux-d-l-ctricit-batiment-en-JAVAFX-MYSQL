/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricien_b;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.ImageIcon;

/**
 *
 * @author sa
 */
public class Electricien_b extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
 Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
 
        Scene s = new Scene(root);
       Image imag=new Image("file:gen.png"); 
       stage.getIcons().removeAll();
       stage.getIcons().add(imag);
        stage.setScene(s);
        stage.setX(0);
        stage.setY(0);
       
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        launch(args);
    }
    
}
