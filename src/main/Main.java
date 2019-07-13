package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.stage.Stage;
import terrain.Tile;

public class Main extends Application {
	public static final int WIDTH = Tile.getWidth();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Group g = new Group();
		Scene scene = new Scene(g, WIDTH, WIDTH);
		Canvas can = new Canvas(WIDTH, WIDTH);
		GraphicsContext gc = can.getGraphicsContext2D();
		PixelWriter pw = gc.getPixelWriter();
		
		g.getChildren().add(can);
		stage.setTitle("Title");
		stage.setScene(scene);
		stage.show();
		can.requestFocus();
	}
}
