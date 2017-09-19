import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Rectangle extends Figure 
{
	protected int longueur;
	protected int largeur;
	
	public Rectangle(){
		super(new Point());
		this.largeur=0;
		this.longueur=0;
	}

	public Rectangle(int longueur, int largeur) {
		/** Si on ne met pas le super(new Point), il va dans le constructeur public Figure(){[...]}
		 *  Cela revient à écrire super();
		 */
		super(new Point());
		this.largeur=largeur;
		this.longueur=longueur;
	}
	
	public Rectangle(int px, int py, Color c){
		
		super(new Point(px, py),c);
	}
	
	public Rectangle(Point p) 
	{
		super(p);
	}
	
	/** Plus général:
	public Rectangle(Point p, int longueur, int largeur) {
		super(p);
		this.largeur = largeur;
		this.longueur = longueur;
	}
	*/
	
	public double getPerimetre()
	{
		return (largeur+longueur)*2;
	}
	
	public double getSurface()
	{
		return longueur*largeur;
	}
	
	public int getLongueur()
	{
		return longueur;
	}
	
	public int getLargeur()
	{
		return largeur;
	}
	
	public void setLongueur(int longueur)
	{
		this.longueur=longueur;
	}
	
	public void setLargeur(int largeur)
	{
		this.largeur=largeur;
	}
	
	public String toString()
	{
		String affichage = "";
		for(int i=0; i<largeur+2;i++)
		{
			for(int j=0; j<2*longueur+2; j++)
			{
				if (i==0 || i==largeur+1)
				{
					if(j==0 || j==2*longueur+1)
					{
						affichage = affichage+"+";
						
					}
					else
					{
						affichage = affichage+"--";
					}
				}
				else if (j==0 || j==2*longueur+1)
				{
					affichage = affichage+"|";
				}
				else
				{
					affichage = affichage+"  ";
				}
				
				
				if (j==2*longueur+1)
				{
					affichage = affichage+"\n";
				}
			}
		}
		return affichage;
	}
	
	
	public void setBoundingBox(int hauteurBB, int largeurBB){
		largeur = largeurBB;
		longueur = hauteurBB;
	}
	
	public void draw(Graphics g) {
	g.setColor(c);
	g.fillRect(origine.getX(),origine.getY(),longueur,largeur); 
	//g.fillOval(?,?,?,?)
	}


}
