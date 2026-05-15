package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        Button boton = new Button("Seleccionar opción");

        boton.setOnAction(e -> mostrarOpciones());

        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(boton);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Diálogo de opciones");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarOpciones() {

        // Crear ArrayList
        ArrayList<String> opciones = new ArrayList<>();

        // Añadir opciones
        opciones.add("Opción 1");
        opciones.add("Opción 2");
        opciones.add("Opción 3");

        // Crear diálogo
        ChoiceDialog<String> dialogo =
                new ChoiceDialog<>("Opción 1", opciones);

        dialogo.setTitle("Seleccionar");
        dialogo.setHeaderText("Elige una opción");
        dialogo.setContentText("Opciones:");

        Optional<String> resultado = dialogo.showAndWait();

        resultado.ifPresent(opcion ->
                System.out.println("Elegiste: " + opcion)
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}