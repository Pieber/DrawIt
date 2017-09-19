import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Ellipse extends Figure
{
	protected int paxe;
	protected int gaxe;
	
	public Ellipse(int gaxe, int paxe)
	{
		super();
		this.paxe=paxe;
		this.gaxe=gaxe;
	}
	
	public Ellipse(int px, int py, Color c){
		
		super(new Point(px, py),c);
	}
	
	public double getPerimetre()
	{
		return 2*Math.PI*Math.sqrt((Math.pow(paxe,2)+Math.pow(gaxe,2))/2);
	}
	
	public double getSurface()
	{
		return Math.PI*paxe*gaxe/4;
	}
	
	public void setBoundingBox(int hauteurBB, int largeurBB){
		gaxe = hauteurBB;
		paxe = largeurBB;
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillOval(origine.getX(),origine.getY(),gaxe,paxe); 
	}
	
	public int getLongueur()
	{
		return gaxe;
	}
	
	public int getLargeur()
	{
		return paxe;
	}
	
	public int getPaxe()
	{
		return paxe;
	}
	
	public int getGaxe()
	{
		return gaxe;
	}

}
