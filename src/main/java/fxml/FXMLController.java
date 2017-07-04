//package com.mycompany.audiolibrary;
package fxml;

import com.mycompany.audiolibrary.Song;
import com.mycompany.audiolibrary.SongDao;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;


public class FXMLController implements Initializable {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="removeItem"
    private MenuItem removeItem; // Value injected by FXMLLoader

    @FXML // fx:id="searchButton"
    private Button searchButton; // Value injected by FXMLLoader

    @FXML // fx:id="trackNumber"
    private TableColumn<?, ?> trackNumber; // Value injected by FXMLLoader

    @FXML // fx:id="year"
    private TableColumn<?, ?> year; // Value injected by FXMLLoader

    @FXML // fx:id="filterYear"
    private ChoiceBox<?> filterYear; // Value injected by FXMLLoader

    @FXML // fx:id="album"
    private TableColumn<?, ?> album; // Value injected by FXMLLoader
    
    @FXML // fx:id="filterGenre"
    private ChoiceBox<?> filterGenre; // Value injected by FXMLLoader

    @FXML // fx:id="length"
    private TableColumn<?, ?> length; // Value injected by FXMLLoader

    @FXML // fx:id="filterInterpret"
    private ChoiceBox<?> filterInterpret; // Value injected by FXMLLoader

    @FXML // fx:id="interpret"
    private TableColumn<?, ?> interpret; // Value injected by FXMLLoader

    @FXML // fx:id="name"
    private TableColumn<?, ?> name; // Value injected by FXMLLoader

    @FXML // fx:id="genre"
    private TableColumn<?, ?> genre; // Value injected by FXMLLoader

    @FXML // fx:id="filterAlbum"
    private ChoiceBox<?> filterAlbum; // Value injected by FXMLLoader

    @FXML // fx:id="selectFile"
    private MenuItem selectFile; // Value injected by FXMLLoader

    @FXML // fx:id="searchBox"
    private TextField searchBox; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert removeItem != null : "fx:id=\"removeItem\" was not injected: check your FXML file 'Scene.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'Scene.fxml'.";
        assert trackNumber != null : "fx:id=\"trackNumber\" was not injected: check your FXML file 'Scene.fxml'.";
        assert year != null : "fx:id=\"year\" was not injected: check your FXML file 'Scene.fxml'.";
        assert filterYear != null : "fx:id=\"filterYear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert album != null : "fx:id=\"album\" was not injected: check your FXML file 'Scene.fxml'.";
        assert length != null : "fx:id=\"length\" was not injected: check your FXML file 'Scene.fxml'.";
        assert filterInterpret != null : "fx:id=\"filterInterpret\" was not injected: check your FXML file 'Scene.fxml'.";
        assert interpret != null : "fx:id=\"interpret\" was not injected: check your FXML file 'Scene.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'Scene.fxml'.";
        assert genre != null : "fx:id=\"genre\" was not injected: check your FXML file 'Scene.fxml'.";
        assert filterAlbum != null : "fx:id=\"filterAlbum\" was not injected: check your FXML file 'Scene.fxml'.";
        assert selectFile != null : "fx:id=\"selectFile\" was not injected: check your FXML file 'Scene.fxml'.";
        assert searchBox != null : "fx:id=\"searchBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert filterGenre != null : "fx:id=\"filterGenre\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filterInterpret = new SongDao() {};
        updatefilterInterpret();
        
        filterAlbum = new SongDao() {};
        updatefilterAlbum();
        
        filterYear = new SongDao() {};
        updatefilterYear();
        
        filterGenre = new SongDao() {};
        updatefilterGenre();
    }

    /**
     * Method of updating filter of Interprets.
     */
    private void updatefilterInterpret() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Method of updating filter of Albums.
     */
    private void updatefilterAlbum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Method of updating filter of years.
     */
    private void updatefilterYear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Method of updating filter of genres.
     */
    private void updatefilterGenre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
