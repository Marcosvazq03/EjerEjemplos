//GridPaneForm.java
package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class GridPaneForm extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // A Label and a TextField 
        Label nameLbl = new Label("Name:");
        TextField nameFld = new TextField();
        // A Label and a TextArea
        Label descLbl = new Label("Description:");
        TextArea descText = new TextArea();
        descText.setPrefColumnCount(20);
        descText.setPrefRowCount(5);
        // Two buttons
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");
        // A Label used as a status bar
        Label statusBar = new Label("Status: Ready");
        statusBar.setStyle("-fx-background-color: lavender;" +
                           "-fx-font-size: 7pt;" +
                           "-fx-padding: 10 0 0 0;");
        // Create a GridPane and set its background color to lightgray
        GridPane root = new GridPane();
        root.setStyle("-fx-background-color: lightgray;");
        // Add children to the GridPane
        root.add(nameLbl, 0, 0, 1, 1);   // (c0, r0, colspan=1, rowspan=1)
        root.add(nameFld, 1, 0, 1, 1);   // (c1, r0, colspan=1, rowspan=1)
        root.add(descLbl, 0, 1, 2, 1);   // (c0, r1, colspan=2, rowspan=1)
        root.add(descText, 0, 2, 2, 1);  // (c0, r2, colspan=2, rowspan=1)
        root.add(okBtn, 2, 0, 1, 1);     // (c2, r0, colspan=1, rowspan=1)
        root.add(cancelBtn, 2, 1, 1, 1); // (c2, r1, colspan=1, rowspan=1)
        root.add(statusBar, 0, 3, GridPane.REMAINING, 1); 
        /* Establecer restricciones para que los niños personalicen su comportamiento de cambio de tamaño */
        // El ancho máximo del botón Aceptar debe ser lo 
        // suficientemente grande para que pueda llenar el ancho de su celda.
        okBtn.setMaxWidth(Double.MAX_VALUE);
        // El campo de nombre en la primera fila debería crecer horizontalmente.
        GridPane.setHgrow(nameFld, Priority.ALWAYS);
        // El campo de descripción en la tercera fila debería crecer verticalmente.
        GridPane.setVgrow(descText, Priority.ALWAYS);
        // La barra de estado en el último debe llenar su celda. 
        statusBar.setMaxWidth(Double.MAX_VALUE);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Creating Forms Using a GridPane");
        stage.show();
    }
}
