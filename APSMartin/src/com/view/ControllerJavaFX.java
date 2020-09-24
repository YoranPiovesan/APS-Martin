package com.view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerJavaFX extends Application implements Initializable {
	

    @FXML
    private Label labelNome;

    @FXML
    void ChoiceDialogButton(ActionEvent event) {
    	List<String> choices = new ArrayList<>();
    	choices.add("Yoran");
    	choices.add("Ricardo");
    	choices.add("Josney");
    	ChoiceDialog<String> dialog = new ChoiceDialog<>(" ",choices);
    	dialog.setTitle("Choice Dialog");
    	dialog.setHeaderText("Este é um Choice Dialog");
    	dialog.setContentText("Escolha um nome:");
    	// Traditional way to get the response value.
    	Optional<String> result = dialog.showAndWait();
    	if (result.isPresent()){
    		  result.ifPresent(name -> labelNome.setText(name+""));
    	}
    	// The Java 8 way to get the response value (with lambda expression).
    	  result.ifPresent(name -> labelNome.setText(name+""));
    }
    @FXML
    void TextFieldDialogButton(ActionEvent event) {
    	TextInputDialog dialog = new TextInputDialog("");
    	dialog.setTitle("Text Input Dialog");
    	dialog.setHeaderText("Este é um Text Input Dialog");
    	dialog.setContentText("Por favor, digite seu nome:");

    	// Traditional way to get the response value.
    	Optional<String> result = dialog.showAndWait();
    	if (result.isPresent()){
    	    System.out.println("Seu nome: " + result.get());
    	    labelNome.setVisible(true);
    	    result.ifPresent(name -> labelNome.setText(name+""));
    	}
    	// The Java 8 way to get the response value (with lambda expression).
    	result.ifPresent(name -> System.out.println("Seu nome: " + name));
    }
    
	@Override
	public void start(Stage stage) {
		try {
			AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("JaxaFX.fxml"));
			Scene sc = new Scene(pane);
			stage.setScene(sc);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void execute() {
		launch();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Olá!!!");
		alert.setHeaderText("Seja muito bem vindo");
		alert.setContentText("Nesse projeto você verá diversos exemplos usando JavaJX!");
		alert.showAndWait();
	}

}
