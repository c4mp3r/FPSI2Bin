package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Principal  extends Application {
	private static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = FXMLLoader.load(getClass().getResource("princ.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			setPrimaryStage(primaryStage);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*
	public void setTela2()
	{
		try {
		Pane r2 = FXMLLoader.load(getClass().getResource("Cadastro.fxml"));
		Scene s2 = new Scene(r2);
		primaryStage.setScene(s2);
		primaryStage.show();
		setPrimaryStage(primaryStage);
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	}*/
	
	public static void main(String[] args)
	{
		launch(args);
	}
	

	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		View.Principal.primaryStage = primaryStage;
}
}