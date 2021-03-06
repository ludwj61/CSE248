package app;

import controller.HomeShop;
import controller.MenuBarShop;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.StudentBag;

public class App extends Application {

	private BorderPane root;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new BorderPane();
		
		StudentBag students = new StudentBag();
		students.printAllStudents();
		
		MenuBarShop menuBarShop = new MenuBarShop(root);
		HomeShop homeShop = new HomeShop(menuBarShop, root, students);
		
		Scene scene = new Scene(root, 800, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
