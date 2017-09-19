import javax.swing.*;
import java.awt.*;
import java.util.*;



public class Cercle extends Ellipse
{
	public Cercle(int rayon)
	{
		super(rayon,rayon);
	}
	
	public Cercle(int px, int py, Color c){
		
		super(px, py,c);
	}
	
	public void setBoundingBox(int hauteurBB, int largeurBB){
		gaxe = hauteurBB;
		paxe = hauteurBB;
	}
}
