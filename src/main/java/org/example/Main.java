package org.example;

// Importación de clases necesarias de JavaFX
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

// Importaciones para listas y resultados opcionales
import java.util.ArrayList;
import java.util.Optional;

// Clase principal que hereda de Application
public class Main extends Application {

    // Método que inicia la interfaz gráfica
    @Override
    public void start(Stage primaryStage) {

        // Crear botón
        Button boton =
                new Button("Seleccionar opción");

        // Evento del botón:
        // llama al método mostrarOpciones()
        boton.setOnAction(
                e -> mostrarOpciones()
        );

        // Crear VBox con separación de 20 píxeles
        VBox root = new VBox(20);

        // Centrar componentes
        root.setAlignment(Pos.CENTER);

        // Añadir botón al contenedor
        root.getChildren().add(boton);

        // Crear escena
        Scene scene =
                new Scene(root, 300, 200);

        // Configurar ventana principal
        primaryStage.setTitle(
                "Diálogo de opciones"
        );

        // Asignar escena
        primaryStage.setScene(scene);

        // Mostrar ventana
        primaryStage.show();
    }

    // Método privado encargado de mostrar
    // un cuadro de diálogo con opciones
    private void mostrarOpciones() {

        // Crear una lista dinámica
        ArrayList<String> opciones =
                new ArrayList<>();

        // Añadir opciones a la lista
        opciones.add("Opción 1");
        opciones.add("Opción 2");
        opciones.add("Opción 3");

        // Crear diálogo de selección
        // Primer parámetro:
        // opción seleccionada por defecto
        // Segundo parámetro:
        // lista de opciones disponibles
        ChoiceDialog<String> dialogo =
                new ChoiceDialog<>(
                        "Opción 1",
                        opciones
                );

        // Configurar título
        dialogo.setTitle(
                "Seleccionar"
        );

        // Configurar encabezado
        dialogo.setHeaderText(
                "Elige una opción"
        );

        // Texto descriptivo
        dialogo.setContentText(
                "Opciones:"
        );

        // Mostrar diálogo y obtener resultado
        Optional<String> resultado =
                dialogo.showAndWait();

        // Si el usuario selecciona una opción
        // y pulsa aceptar, se imprime
        resultado.ifPresent(opcion ->

                System.out.println(
                    "Elegiste: " + opcion
                )
        );
    }

    // Método principal que inicia aplicación
    public static void main(String[] args) {
        launch(args);
    }
}
