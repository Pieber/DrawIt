import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;



public abstract class Figure implements Serializable
{
	protected Point origine;
	public Color c;

	public Figure() {
		origine = new Point();
	}

	public Figure(Point o, Color co)
	{
		origine=o;
		c = co;


	}
	
	public Color getColor(){
		return c;
	}
	
	public Point getOrigine(){
		return origine;
	}
	
	public void setColor(Color co){
		c = co;
	}
	
	public void setOrigine(Point o){
		origine=o;
	}
	
	public Figure(Point o)
	{
		origine=o;
	}
	
	public String toString()
	{
		return "Abscisse = " + origine.getX()+" Ordonnée =" + origine.getY();
	}
	
	/**
	* @return perimetre de la figure
	*/
	public abstract double getPerimetre();
	/**
	* @return surface de la figure
	*/
	public abstract double getSurface();

	public abstract void setBoundingBox(int hauteurBB, int largeurBB);
	
	public abstract void draw(Graphics g);
	
	public abstract int getLongueur();
	public abstract int getLargeur();


}
