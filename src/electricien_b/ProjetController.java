/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricien_b;

import bdd.ConexionBD;
import bdd.projet;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * FXML Controller class
 *
 * @author sa
 */
public class ProjetController implements Initializable {
 DecimalFormat da = new DecimalFormat("###0.00 ");
    public static Image image1;
    @FXML
    private AnchorPane imag;
    @FXML
    private TableView<projet> tabV;
    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField adresse;
    @FXML
    private JFXTextField cout;
    @FXML
    private JFXTextField source_ing;
    @FXML
    private JFXButton img;
    @FXML
    private TableColumn<projet, Integer> id_t;
    @FXML
    private TableColumn<projet, String> name_t;
    @FXML
    private TableColumn<projet, String> adresse_t;
    @FXML
    private TableColumn<projet, String> entreprenete_t;
    @FXML
    private TableColumn<projet, Double> cout_t;
    @FXML
    private TableColumn<projet, String> photo_t;
    @FXML
    private ImageView im;

    ObservableList<projet> data = FXCollections.observableArrayList();
    @FXML
    private JFXComboBox<String> Combo;
    @FXML
    private Label total;
    @FXML
    private JFXButton logout1111;
    @FXML
    private JFXButton logout11111;
    @FXML
    private JFXButton logout11112;
    @FXML
    private JFXButton logout11113;
    @FXML
    private Pane pane;
    @FXML
    private ScrollPane scroll;
    @FXML
    private AnchorPane pane_home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            initializ();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void table(MouseEvent event) {
        if(event.getClickCount()==2){
                imag.setVisible(true);
                
        pane.setVisible(true);
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("projet_employé.fxml"));
            scroll.setContent(root);
            scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }    
        }else{
        projet isselect = tabV.getSelectionModel().getSelectedItem();
        id.setText(String.valueOf(isselect.getId()));
        name.setText(isselect.getName());
        adresse.setText(isselect.getAdresse());
        cout.setText(String.valueOf(isselect.getCout()));      
        source_ing.setText(isselect.getImg());
        System.out.println("" + isselect.getImg());
        im.setImage(new Image("file:" + isselect.getImg()));
        }
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

    void com() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        ObservableList<String> type = FXCollections.observableArrayList();

        try {
            con = ConexionBD.Conexion();
            String reque = "SELECT  `nom`, `prenom` FROM `entrepreneur` WHERE 1";
            ps = con.prepareStatement(reque);
            rs = ps.executeQuery();
            while (rs.next()) {
                type.addAll(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjetController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ps.close();
            rs.close();
        }
        Combo.setItems(type);
    }

    void initializ() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        double to=0;
        com();
        try {
            con = ConexionBD.Conexion();
            String reque = "SELECT  `id`,`nom`, `adresse`, `entrepreneur`, `cout`, `photo` FROM `pojet` WHERE 1";
            ps = con.prepareStatement(reque);
            rs = ps.executeQuery();
            while (rs.next()) {
                data.add(new projet(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getDouble(5)));
           to=to+rs.getDouble(5);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjetController.class.getName()).log(Level.SEVERE, null, ex);
        }

        id_t.setCellValueFactory(new PropertyValueFactory<projet, Integer>("id"));
        name_t.setCellValueFactory(new PropertyValueFactory<projet, String>("name"));
        adresse_t.setCellValueFactory(new PropertyValueFactory<projet, String>("adresse"));
        entreprenete_t.setCellValueFactory(new PropertyValueFactory<projet, String>("entrepreneur"));
        cout_t.setCellValueFactory(new PropertyValueFactory<projet, Double>("cout"));
        photo_t.setCellValueFactory(new PropertyValueFactory<projet, String>("img"));
        tabV.setItems(data);
        total.setText(String.valueOf(da.format(to)));
    }

    @FXML
    private void nouveau(MouseEvent event) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = ConexionBD.Conexion();
            String requete = "insert into  pojet (`nom`, `adresse`, `entrepreneur`, `cout`, `photo`) values (?,?,?,?,?)";
            ps = con.prepareStatement(requete);

            ps.setString(1, name.getText());
            ps.setString(2, adresse.getText());
            ps.setString(3, Combo.getSelectionModel().getSelectedItem().toString());
            ps.setString(4, cout.getText());
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

                String requete = "DELETE FROM `pojet` WHERE `id` = '" + id.getText() + "'";
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
        String requete = "update pojet set `nom`=?, `adresse`=?, `entrepreneur`=?, `cout`=?, `photo`=? where  id='" + id.getText() + "'";
        try {
            con = ConexionBD.Conexion();
            ps = con.prepareStatement(requete);

            ps.setString(1, name.getText());
            ps.setString(2, adresse.getText());
            ps.setString(3, Combo.getSelectionModel().getSelectedItem().toString());
            ps.setString(4, cout.getText());
            ps.setString(5, source_ing.getText());
            ps.execute();
             JOptionPane.showMessageDialog(null, "Modification avec succès");
            data.clear();
            initializ();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void z(MouseEvent event) {

    }
}
