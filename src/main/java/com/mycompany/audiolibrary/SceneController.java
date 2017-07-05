//package com.mycompany.audiolibrary;
package com.mycompany.audiolibrary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.cell.PropertyValueFactory;

public class SceneController implements Initializable {

    //Create an instance to get tracks
    private SongDao sd;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="searchButton"
    private Button searchButton; // Value injected by FXMLLoader

    @FXML // fx:id="trackNumber"
    private TableColumn<Song, String> trackNumber; // Value injected by FXMLLoader

    @FXML // fx:id="year"
    private TableColumn<Song, String> year; // Value injected by FXMLLoader

    @FXML // fx:id="filterYear"
    private ChoiceBox<?> filterYear; // Value injected by FXMLLoader

    @FXML // fx:id="album"
    private TableColumn<Song, String> album; // Value injected by FXMLLoader

    @FXML // fx:id="filterGenre"
    private ChoiceBox<?> filterGenre; // Value injected by FXMLLoader

    @FXML // fx:id="length"
    private TableColumn<Song, String> length; // Value injected by FXMLLoader

    @FXML // fx:id="filterInterpret"
    private ChoiceBox<?> filterInterpret; // Value injected by FXMLLoader

    @FXML // fx:id="interpret"
    private TableColumn<Song, String> interpret; // Value injected by FXMLLoader

    @FXML // fx:id="name"
    private TableColumn<Song, String> name; // Value injected by FXMLLoader

    @FXML // fx:id="genre"
    private TableColumn<Song, String> genre; // Value injected by FXMLLoader

    @FXML // fx:id="filterAlbum"
    private ChoiceBox<?> filterAlbum; // Value injected by FXMLLoader

    @FXML // fx:id="searchBox"
    private TextField searchBox; // Value injected by FXMLLoader

    @FXML // fx:id="tableView"
    private TableView<?> tableView; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
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
        assert searchBox != null : "fx:id=\"searchBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert filterGenre != null : "fx:id=\"filterGenre\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'Scene.fxml'.";
    }

    /**
     * Methods following the action in the graphical interface
     */
    @FXML
    void handleSearchButton(ActionEvent event) {
        ObservableList data = FXCollections.observableArrayList(sd.findByName(searchBox.getText()));
        tableView.setItems(data);
        filterAlbum.setValue(null);
        filterInterpret.setValue(null);
        filterYear.setValue(null);
        filterGenre.setValue(null);
    }

    @FXML
    void handleSearch(ActionEvent event) {
        handleSearchButton(event);
    }

    /**
     * Method to initialize options at startup
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sd = new SongDaoImpl();
        updatefilterInterpret();
        updatefilterAlbum();
        updatefilterYear();
        updatefilterGenre();

        /**
         * Listeners for selection changes of choicebox
         */
        filterInterpret.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> selectInterpret());
        filterAlbum.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> selectAlbum());
        filterGenre.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> selectGenre());
        filterYear.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> selectYear());

        searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList data = FXCollections.observableArrayList(sd.findByName(searchBox.getText()));
            tableView.setItems(data);
            filterAlbum.setValue(null);
            filterInterpret.setValue(null);
            filterYear.setValue(null);
            filterGenre.setValue(null);
        });

        /**
         * Set values for individual columns of the song table
         */
        trackNumber.setCellValueFactory(new PropertyValueFactory<Song, String>("songNumber"));
        year.setCellValueFactory(new PropertyValueFactory<Song, String>("year"));
        album.setCellValueFactory(new PropertyValueFactory<Song, String>("album"));
        length.setCellValueFactory(new PropertyValueFactory<Song, String>("length"));
        interpret.setCellValueFactory(new PropertyValueFactory<Song, String>("interpret"));
        name.setCellValueFactory(new PropertyValueFactory<Song, String>("name"));
        genre.setCellValueFactory(new PropertyValueFactory<Song, String>("genre"));

        ObservableList data = FXCollections.observableArrayList(sd.findAll());
        tableView.setItems(data);
    }

    /**
     * Method of updating filter of Interprets. Calls a method to get a list of
     * interprets and displays them in the selection
     */
    private void updatefilterInterpret() {
        filterInterpret.getItems().clear();
        filterInterpret.setItems((ObservableList) FXCollections.observableList(sd.getInterprets()));
    }

    /**
     * Method of updating filter of Albums. Calls a method to get a list of
     * albums and displays them in the selection
     */
    private void updatefilterAlbum() {
        filterAlbum.getItems().clear();
        filterAlbum.setItems((ObservableList) FXCollections.observableList(sd.getAlbums()));
    }

    /**
     * Method of updating filter of years. Calls a method to get a list of years
     * and displays them in the selection
     */
    private void updatefilterYear() {
        filterYear.getItems().clear();
        filterYear.setItems((ObservableList) FXCollections.observableList(sd.getYears()));
    }

    /**
     * Method of updating filter of genres. Calls a method to get a list of
     * genres and displays them in the selection
     */
    private void updatefilterGenre() {
        filterGenre.getItems().clear();
        filterGenre.setItems((ObservableList) FXCollections.observableList(sd.getGenres()));
    }

    /**
     * Method of select Interpret for filter output Fills the data into a table
     * according to the selected Interpret
     */
    void selectInterpret() {
        if (filterInterpret.getValue() != null) {
            ObservableList data = FXCollections.observableArrayList(sd.findByInterpret(filterInterpret.getValue().toString()));
            tableView.setItems(data);
            filterAlbum.setValue(null);
            filterYear.setValue(null);
            filterGenre.setValue(null);
        }
    }

    /**
     * Method of select Album for filter output Fills the data into a table
     * according to the selected Album
     */
    private void selectAlbum() {
        if (filterAlbum.getValue() != null) {
            ObservableList data = FXCollections.observableArrayList(
                    sd.findByAlbum(filterAlbum.getValue().toString()));
            tableView.setItems(data);
            filterInterpret.setValue(null);
            filterYear.setValue(null);
            filterGenre.setValue(null);
        }
    }

    /**
     * Method of select Year for filter output Fills the data into a table
     * according to the selected year
     */
    private void selectYear() {
        if (filterYear.getValue() != null) {
            ObservableList data = FXCollections.observableArrayList(sd.findByYear(Integer.valueOf(filterYear.getValue().toString())));
            tableView.setItems(data);
            filterInterpret.setValue(null);
            filterAlbum.setValue(null);
            filterGenre.setValue(null);
        }
    }

    /**
     * Method of select Genre for filter output Fills the data into a table
     * according to the selected genre
     */
    private void selectGenre() {
        if (filterGenre.getValue() != null) {
            ObservableList data = FXCollections.observableArrayList(
                    sd.findByGenre(filterGenre.getValue().toString())
            );
            tableView.setItems(data);
            filterInterpret.setValue(null);
            filterAlbum.setValue(null);
            filterYear.setValue(null);

        }
    }
}
