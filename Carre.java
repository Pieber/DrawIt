import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Carre extends Rectangle
{
	public Carre()
	{
		super(0, 0);
	}
	
	public Carre(int largeur)
	{
		super(largeur, largeur);
	}
	public Carre(int px, int py, Color c){
		super(px, py,c);
	}
	public void setLongueur(int longueur)
	{
		this.longueur=longueur;
		this.largeur=longueur;
	}
	
	public void setLargeur(int largeur)
	{
		this.largeur=largeur;
		this.longueur=largeur;
	}
	
	public int getLargeur()
	{
		return largeur;

	}
	
	public int getLongueur()
	{
		return longueur;
	}
	
	public void setBoundingBox(int hauteurBB, int largeurBB){
		setLongueur(hauteurBB);
	}
}
