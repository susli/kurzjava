//package com.mycompany.audiolibrary;
package com.mycompany.audiolibrary;

import com.mycompany.audiolibrary.Song;
import com.mycompany.audiolibrary.SongDao;
import com.mycompany.audiolibrary.SongDaoImpl;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//<<<<<<< HEAD
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
//=======
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.cell.PropertyValueFactory;
//>>>>>>> origin/master

public class SceneController implements Initializable {
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

	@FXML // fx:id="selectFile"
	private MenuItem selectFile; // Value injected by FXMLLoader

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
		assert selectFile != null : "fx:id=\"selectFile\" was not injected: check your FXML file 'Scene.fxml'.";
		assert searchBox != null : "fx:id=\"searchBox\" was not injected: check your FXML file 'Scene.fxml'.";
		assert filterGenre != null : "fx:id=\"filterGenre\" was not injected: check your FXML file 'Scene.fxml'.";
		assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'Scene.fxml'.";

	}

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
	private void handleSelectFile(ActionEvent event) throws MalformedURLException {
		System.out.println("SelectFile");
		FileChooser fc = new FileChooser();
		fc.setTitle("Choose audio file");
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("mp3", "*.mp3"));
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("wav", "*.wav"));
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("ALL Files", "*.*"));

		File workingDirectory = new File(System.getProperty("user.dir")); // aktuální složka programu
		fc.setInitialDirectory(workingDirectory);

		List<File> files = fc.showOpenMultipleDialog(null);

		if (files == null) {
			return;

		}
	}

	@FXML
	void handleDeleteItem(ActionEvent event) {
		System.out.println("DeleteItem");
	}

	@FXML
	void handleSearchBox(ActionEvent event) {
		System.out.println("SearchBox");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		sd = new SongDaoImpl();
		updatefilterInterpret();
		updatefilterAlbum();
		updatefilterYear();
		updatefilterGenre();

		// Listeners for selection changes of choicebox
		filterInterpret.getSelectionModel().selectedItemProperty()
				.addListener((v, oldValue, newValue) -> selectInterpret());
		filterAlbum.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> selectAlbum());
		filterGenre.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> selectGenre());
		filterYear.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> selectYear());

		trackNumber.setCellValueFactory(new PropertyValueFactory<Song, String>("songNumber"));
		year.setCellValueFactory(new PropertyValueFactory<Song, String>("year"));
		album.setCellValueFactory(new PropertyValueFactory<Song, String>("album"));
		length.setCellValueFactory(new PropertyValueFactory<Song, String>("length"));
		interpret.setCellValueFactory(new PropertyValueFactory<Song, String>("interpret"));
		name.setCellValueFactory(new PropertyValueFactory<Song, String>("name"));
		genre.setCellValueFactory(new PropertyValueFactory<Song, String>("genre"));
		
		ObservableList data=FXCollections.observableArrayList(
				sd.findAll()
				);
		tableView.setItems(data);
	}

	/**
	 * Method of updating filter of Interprets.
	 */
	private void updatefilterInterpret() {
		filterInterpret.getItems().clear();
		filterInterpret.setItems((ObservableList) FXCollections.observableList(sd.getInterprets()));
	}

	/**
	 * Method of updating filter of Albums.
	 */
	private void updatefilterAlbum() {
		filterAlbum.getItems().clear();
		filterAlbum.setItems((ObservableList) FXCollections.observableList(sd.getAlbums()));
	}

	/**
	 * Method of updating filter of years.
	 */
	private void updatefilterYear() {
		filterYear.getItems().clear();
		filterYear.setItems((ObservableList) FXCollections.observableList(sd.getYears()));
	}

	/**
	 * Method of updating filter of genres.
	 */
	private void updatefilterGenre() {
		filterGenre.getItems().clear();
		filterGenre.setItems((ObservableList) FXCollections.observableList(sd.getGenres()));
	}

	/**
	 * Method of select Interpret for filter output
	 */

	void selectInterpret() {
		if (filterInterpret.getValue() != null)	{	
		ObservableList data=FXCollections.observableArrayList(
				sd.findByInterpret(filterInterpret.getValue().toString())
				);
		tableView.setItems(data);
		filterAlbum.setValue(null);
		filterYear.setValue(null);
		filterGenre.setValue(null);
		}
	}

	/**
	 * Method of select Album for filter output
	 */
	private void selectAlbum() {
		if (filterAlbum.getValue() != null)	{	
		ObservableList data=FXCollections.observableArrayList(
		sd.findByAlbum(filterAlbum.getValue().toString()));
		tableView.setItems(data);
		filterInterpret.setValue(null);
		filterYear.setValue(null);
		filterGenre.setValue(null);
		}
	}

	/**
	 * Method of select Year for filter output
	 */
	private void selectYear() {
		if (filterYear.getValue() != null)	{	
		ObservableList data=FXCollections.observableArrayList(
				sd.findByYear(Integer.valueOf(filterYear.getValue().toString()))
				);
		tableView.setItems(data);
		filterInterpret.setValue(null);
		filterAlbum.setValue(null);
		filterGenre.setValue(null);
		}
	}

	/**
	 * Method of select Genre for filter output
	 */
	private void selectGenre() {
		if (filterGenre.getValue() != null)	{	
		ObservableList data=FXCollections.observableArrayList(
				sd.findByGenre(filterGenre.getValue().toString())
				);
		tableView.setItems(data);
		filterInterpret.setValue(null);
		filterAlbum.setValue(null);
		filterYear.setValue(null);
	
		}
	}

	
}
