package terrain;

import util.Coord2D;
import util.Direction;

public class TileMap {

	private final int TILE_WIDTH = 3;
	private Tile[][] tiles = new Tile[TILE_WIDTH][TILE_WIDTH];
	private Coord2D viewer = new Coord2D(Tile.getWidth()*TILE_WIDTH/2,Tile.getWidth()*TILE_WIDTH/2);
	private double[][] view = new double[Tile.getWidth()][Tile.getWidth()];
	
	//TODO remove magic numbers
	public double[][] updateViewer(Direction dir) {
		
		switch(dir) {
			case UP:
				viewer.setY(viewer.getY()-1);
				if(tiles[1][0].contains(viewer)) {
					//TODO
				}
				else {
					for(int x=0; x<Tile.getWidth(); x++) 
						for(int y=Tile.getWidth()-1; y>0; y--)
							view[x][y] = view[x][y-1];
					if(tiles[1][0].contains(new Coord2D(viewer.getX(), viewer.getY()-300))) {
					for(int x=0; x<Tile.getWidth(); x++) {
						view[x][0] = tiles[1][0].getZ(new Coord2D(viewer.getX()-300+x, viewer.getY()-300));	
					}
				}
				break;
			case DOWN:
				viewer.setY(viewer.getY()+1);
				if(tiles[1][2].contains(viewer)) {
					//TODO
				}
				else {
					for(int x=0; x<Tile.getWidth(); x++) 
						for(int y=0; y<Tile.getWidth()-1; y++)
							view[x][y] = view[x][y+1];
					for(int x=0; x<Tile.getWidth(); x++) {
						view[x][Tile.getWidth()-1] = tiles[1][2].getZ(new Coord2D(viewer.getX()-300+x, viewer.getY()+300));	
					}
				}
				break;/*
			case LEFT:
				viewer.setY(viewer.getY()-1);
				if(tiles[1][2].contains(viewer)) {
					//TODO
				}
				else {
					for(int x=0; x<Tile.getWidth(); x++) 
						for(int y=Tile.getWidth()-1; y>0; y--)
							view[x][y] = view[x][y-1];
					for(int x=0; x<Tile.getWidth(); x++) {
						System.out.println("("+(viewer.getX()-300+x)+","+(viewer.getY()-301)+")");
						view[x][0] = tiles[1][2].getZ(new Coord2D(viewer.getX()-300+x, viewer.getY()-300));	
					}
				}
				break;
			case RIGHT:
				viewer.setY(viewer.getY()-1);
				if(tiles[0][1].contains(viewer)) {
					//TODO
				}
				else {
					for(int x=0; x<Tile.getWidth(); x++) 
						for(int y=Tile.getWidth()-1; y>0; y--)
							view[x][y] = view[x][y-1];
					for(int x=0; x<Tile.getWidth(); x++) {
						System.out.println("("+(viewer.getX()-300+x)+","+(viewer.getY()-301)+")");
						view[x][0] = tiles[1][0].getZ(new Coord2D(viewer.getX()-300+x, viewer.getY()-300));	
					}
				}
				break;*/
		}
		return view;
	}

	public double[][] getView() {
		return view;
	}
	
	public TileMap() {
		for(int x=0; x<TILE_WIDTH; x++)
			for(int y=0; y<TILE_WIDTH; y++)
				tiles[x][y] = new Tile(new Coord2D(x*Tile.getWidth(), y*Tile.getWidth()));
		for(int x=0/*currentViewer.getX()-Tile.getWidth()/2*/; x<Tile.getWidth()/*currentViewer.getX()+Tile.getWidth()/2*/; x++)
			for(int y=0/*currentViewer.getY()-Tile.getWidth()/2*/; y<Tile.getWidth()/*currentViewer.getY()+Tile.getWidth()/2*/; y++)
				view[x][y] = tiles[1][1].getZ(new Coord2D(x+Tile.getWidth(),y+Tile.getWidth()));
	}
	

}
