package terrain;

import terrain.simplexNoise.SimplexNoise;
import util.Coord2D;

public class Tile {
	private static final int WIDTH = 600;
	// position is upperLeftHand Corner
	private Coord2D pos;
	//TODO make private
	public double[][] heightMap = new double[WIDTH][WIDTH];
	
	public Tile(int x, int y) {
		pos = new Coord2D(x,y);
		heightMap = generateNoise(x, x+WIDTH, y, y+WIDTH, WIDTH, WIDTH);
	}
	public static int getWidth() {
		return WIDTH;
	}
	public int getX() {
		return pos.getX();
	}
	public int getY() {
		return pos.getY();
	}
	private double[][] generateNoise(double xStart, double xEnd, double yStart, double yEnd, int xResolution, int yResolution) {
		SimplexNoise simplexNoise=new SimplexNoise(100,0.1,5000);
		double[][] result=new double[xResolution][yResolution];
	    for(int i=0;i<xResolution;i++){
	        for(int j=0;j<yResolution;j++){
	            int x=(int)(xStart+i*((xEnd-xStart)/xResolution));
	            int y=(int)(yStart+j*((yEnd-yStart)/yResolution));
	            result[i][j]=0.5*(1+simplexNoise.getNoise(x,y));
	        }
	    }
	    return result;
	}
	public boolean contains(Coord2D point) {
		return false;
	}
	public double getZ(Coord2D point) {
		return heightMap[point.getX()-pos.getX()][point.getY()-pos.getY()];
	}
}
