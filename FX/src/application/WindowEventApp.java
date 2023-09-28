//WindowEventApp.java
package application;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import static javafx.stage.WindowEvent.WINDOW_CLOSE_REQUEST;

public class WindowEventApp extends Application {
 private CheckBox canCloseCbx;

 public static void main(String[] args) {
     Application.launch(args);
 }

 @Override
 public void start(Stage stage) {
     canCloseCbx = new CheckBox("Can Close Window");
     Button closeBtn = new Button("Close");
     closeBtn.setOnAction(e -> stage.close());
     Button hideBtn = new Button("Hide");
     hideBtn.setOnAction(e -> {
         showDialog(stage);
         stage.hide();
     });
     HBox root = new HBox();
     root.setPadding(new Insets(20));
     root.setSpacing(20);
     root.getChildren().addAll(canCloseCbx, closeBtn, hideBtn);
     // Agregar controladores de eventos de ventana al escenario
     stage.setOnShowing(e -> handle(e));
     stage.setOnShown(e -> handle(e));
     stage.setOnHiding(e -> handle(e));
     stage.setOnHidden(e -> handle(e));
     stage.setOnCloseRequest(e -> handle(e));
     Scene scene = new Scene(root);
     stage.setScene(scene);
     stage.setTitle("Window Events");
     stage.show();
 }

 public void handle(WindowEvent e) {
     // Consume el evento si el CheckBox no está seleccionado, 
	 // evitando así que el usuario cierre la ventana.
     EventType<WindowEvent> type = e.getEventType();
     if (type == WINDOW_CLOSE_REQUEST && !canCloseCbx.isSelected()) {
         e.consume();
     }
     System.out.println(type + ": Consumed=" + e.isConsumed());
 }

 public void showDialog(Stage mainWindow) {
     Stage popup = new Stage();
     Button closeBtn = new Button("Click to Show Main Window");
     closeBtn.setOnAction(e -> {
         popup.close();
         mainWindow.show();
     });
     HBox root = new HBox();
     root.setPadding(new Insets(20));
     root.setSpacing(20);
     root.getChildren().addAll(closeBtn);
     Scene scene = new Scene(root);
     popup.setScene(scene);
     popup.setTitle("Popup");
     popup.show();
 }
}
