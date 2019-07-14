package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import terrain.Tile;
import terrain.TileMap;
import util.Direction;

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
		
		TileMap tm = new TileMap();
		
		can.setOnKeyPressed(action -> {
			switch(action.getCode()) {
				case UP:
					drawHeightMap(pw, tm.updateViewer(Direction.UP));
					break;
				case DOWN:
					drawHeightMap(pw, tm.updateViewer(Direction.DOWN));
					break;
			}
		});
		//TileMap tm = new TileMap();
		//drawHeightMap(pw, tm.view(viewer));
		//Tile tile = new Tile(new Coord2D(WIDTH, WIDTH));
		drawHeightMap(pw, tm.getView());
		
		g.getChildren().add(can);
		stage.setTitle("Title");
		stage.setScene(scene);
		stage.show();
		can.requestFocus();
	}
	
	private void drawHeightMap(PixelWriter pw, double[][] hm) {
		for(int x=0; x<WIDTH; x++)
			for(int y=0; y<WIDTH; y++)
				pw.setColor(x, y, new Color(0.5*hm[x][y], 0.99*hm[x][y], 0.2*hm[x][y], 1));
	}
}
