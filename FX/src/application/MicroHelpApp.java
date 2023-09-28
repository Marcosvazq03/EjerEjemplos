// MicroHelpApp.java
package application;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MicroHelpApp extends Application {
    private Text helpText = new Text();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        TextField fName = new TextField();
        TextField lName = new TextField();
        TextField salary = new TextField();
        Button closeBtn = new Button("Close");
        closeBtn.setOnAction(e -> Platform.exit());
        fName.getProperties().put("microHelpText", "Introduce tu nombre");
        lName.getProperties().put("microHelpText", "Introduce segundo apellido");
        salary.getProperties().put("microHelpText", "Introduce salario");
        // El nodo de texto de ayuda no está administrado
        helpText.setManaged(false);
        helpText.setTextOrigin(VPos.TOP);
        helpText.setFill(Color.RED);
        helpText.setFont(Font.font(null, 9));
        helpText.setMouseTransparent(true);
        // Agregar todos los nodos a un GridPane
        GridPane root = new GridPane();
        root.add(new Label("Nombre:"), 1, 1);
        root.add(fName, 2, 1);
        root.add(new Label("Primer apellido:"), 1, 2);
        root.add(lName, 2, 2);
        root.add(new Label("Salario:"), 1, 3);
        root.add(salary, 2, 3);
        root.add(closeBtn, 3, 3);
        root.add(helpText, 4, 3);
        Scene scene = new Scene(root, 350, 100);
        // Agregue un oyente de cambios a la escena, para que sepamos cuándo cambia el propietario del foco y muestre la microayuda.
        scene.focusOwnerProperty().addListener((ObservableValue<? extends Node> value, Node oldNode, Node newNode) -> focusChanged(value, oldNode, newNode));
        stage.setScene(scene);
        stage.setTitle("Showing Micro Help");
        stage.show();
    }

    public void focusChanged(ObservableValue<? extends Node> value, Node oldNode, Node newNode) {
        // El foco ha cambiado a un nuevo nodo.
        String microHelpText = (String) newNode.getProperties().get("microHelpText");
        if (microHelpText != null && microHelpText.trim().length() > 0) {
            helpText.setText(microHelpText);
            helpText.setVisible(true);
            // Colocar el nodo de texto de ayuda
            double x = newNode.getLayoutX() + newNode.getLayoutBounds().getMinX() - helpText.getLayoutBounds().getMinX();
            double y = newNode.getLayoutY() + newNode.getLayoutBounds().getMinY() + newNode.getLayoutBounds().getHeight() - helpText.getLayoutBounds().getMinX();
            helpText.setLayoutX(x);
            helpText.setLayoutY(y);
            helpText.setWrappingWidth(newNode.getLayoutBounds().getWidth());
        } else {
            helpText.setVisible(false);
        }
    }
}
