/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricien_b;

import bdd.ConexionBD;
import bdd.Employé;
import bdd.Entrepreneur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import static electricien_b.ProjetController.image1;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author sa
 */
public class EmployéController implements Initializable {

    @FXML
    private AnchorPane imag;
    @FXML
    private TableView<Employé> tabV;
    @FXML
    private TableColumn<Employé, Integer> id_t;
    @FXML
    private TableColumn<Employé, String> name_t;
    @FXML
    private TableColumn<Employé,String> prenom_t;
    @FXML
    private TableColumn<Employé,String> adresse_t;
    @FXML
    private TableColumn<Employé, Integer> tlf_t;
    @FXML
    private TableColumn<Employé,String> photo_t;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField id;
    @FXML
    private ImageView im;
    @FXML
    private JFXTextField source_ing;
    @FXML
    private JFXButton img;
    @FXML
    private JFXTextField adresse;
    @FXML
    private JFXTextField tlf;
 ObservableList<Employé> data = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO.
            initializ();
        } catch (SQLException ex) {
            Logger.getLogger(EmployéController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
   void initializ() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = ConexionBD.Conexion();
            String reque = "SELECT `id`, `nom`, `prenom`, `adresse`, `num_tlf`, `photo` FROM `employé` WHERE 1";
            ps = con.prepareStatement(reque);
            rs = ps.executeQuery();
            while (rs.next()) {
                data.add(new Employé(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getInt(5)));
       
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployéController.class.getName()).log(Level.SEVERE, null, ex);
        }

        id_t.setCellValueFactory(new PropertyValueFactory<Employé, Integer>("id"));
        name_t.setCellValueFactory(new PropertyValueFactory<Employé, String>("name"));
        prenom_t.setCellValueFactory(new PropertyValueFactory<Employé, String>("prenom"));
        adresse_t.setCellValueFactory(new PropertyValueFactory<Employé, String>("adresse"));
        tlf_t.setCellValueFactory(new PropertyValueFactory<Employé,Integer>("tlf"));
        photo_t.setCellValueFactory(new PropertyValueFactory<Employé, String>("source_ing"));
        tabV.setItems(data);
    }
    @FXML
    private void table(MouseEvent event) {
                id.setEditable(false);
           Employé isselect = tabV.getSelectionModel().getSelectedItem();
        id.setText(String.valueOf(isselect.getId()));
        name.setText(isselect.getName());
        prenom.setText(isselect.getPrenom());
        adresse.setText(isselect.getAdresse());
        tlf.setText(String.valueOf(isselect.getTlf()));
        source_ing.setText(isselect.getSource_ing());
        System.out.println("" + isselect.getSource_ing());
        im.setImage(new Image("file:" + isselect.getSource_ing())); 
    }

    @FXML
    private void bu_imag(ActionEvent event) throws IOException {
        imagess();
    }
        public void imagess() throws IOException {
        FileChooser fv = new FileChooser();
        fv.setTitle("my file chooser");
        File f = fv.showOpenDialog(null);
        BufferedImage bufferedImage = null;
        bufferedImage = ImageIO.read(f);
        image1 = SwingFXUtils.toFXImage(bufferedImage, null);
        source_ing.setText(f.getPath());
        im.setImage(image1);
    }

    @FXML
    private void nouveau(MouseEvent event) {
                        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = ConexionBD.Conexion();
            String requete = "INSERT INTO `employé`( `nom`, `prenom`, `adresse`, `num_tlf`, `photo`) values (?,?,?,?,?)";
            ps = con.prepareStatement(requete);

            ps.setString(1, name.getText());
            ps.setString(2, prenom.getText());
            ps.setString(3, adresse.getText());
            ps.setString(4, tlf.getText());
            ps.setString(5, source_ing.getText());
            ps.execute();

            JOptionPane.showMessageDialog(null, "Enregistrement avec succès");
            data.clear();
            initializ();
        } catch (Exception e) {
            System.out.println("--> SQLException : " + e);
            Logger.getLogger(ProjetController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void supprimer(MouseEvent event) {
                        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
                try {
                     con = ConexionBD.Conexion();
            if (JOptionPane.showConfirmDialog(null, "attention vous devez suprimer un projet,est ce que tu es sur?",
                    "Supprimer Moniteur", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

                String requete = "DELETE FROM `employé` WHERE `id`= '" + id.getText() + "'";
                ps = con.prepareStatement(requete);

                ps.execute();
                data.clear();
            initializ();
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "erreur de supprimer \n" + e.getMessage());
        }
    }

    @FXML
    private void Imprimer(MouseEvent event) {
        
    }

    @FXML
    private void modifier(MouseEvent event) {
                        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        String requete = "UPDATE `employé` SET `nom`=?,`prenom`=?,`adresse`=?,`num_tlf`=?,`photo`=? where  id='" + id.getText() + "'";
        try {
            con = ConexionBD.Conexion();
            ps = con.prepareStatement(requete);

           ps.setString(1, name.getText());
            ps.setString(2, prenom.getText());
            ps.setString(3, adresse.getText());
            ps.setString(4, tlf.getText());
            ps.setString(5, source_ing.getText());
            ps.execute();
             JOptionPane.showMessageDialog(null, "Modification avec succès");
            data.clear();
            initializ();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
}
