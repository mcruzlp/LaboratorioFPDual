package myjavafx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavafxSample extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Text textobienvenida = new Text("Bienvenid@s :D");
		textobienvenida.setFont(new Font(65));
		textobienvenida.setX(50);
		textobienvenida.setY(150);
		
		Group root = new Group(textobienvenida);
		
		Scene scene = new Scene(root,600,300);
		scene.setFill(Color.BROWN);

		primaryStage.setTitle("Sample Application");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
