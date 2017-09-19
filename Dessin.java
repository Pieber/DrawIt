import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.Field;
import java.beans.*;


class Dessin extends JPanel implements MouseMotionListener,MouseListener, Serializable {
	
	private ArrayList<Figure> liste;
	private Color c;
	private String nomFigure;
	private int x;
	private int y;
	
	public Dessin(){
		super();
		c=Color.black;
		nomFigure = "Rectangle";
		addMouseListener(this);
		addMouseMotionListener(this);
		liste = new ArrayList<Figure>();
	}
	
	public void paintComponent( Graphics g){
		super.paintComponent(g); 
		this.setBackground(Color.white);
				
		for(Figure f : liste){
			f.draw(g);
		}		
	}
	
	public void setColor(Color couleur){
		c=couleur;
	}
	
	
	public void setName(String name){
		nomFigure=name;
	}
	
	public ArrayList<Figure> getList(){
		return liste;
	}
	
	public void resetList(){
		liste=new ArrayList<Figure>();
	}
	
	
	public void mouseClicked(MouseEvent e) {} 

	public void mousePressed(MouseEvent e) {
		x=e.getX();
		y=e.getY();
		if (nomFigure == "Cercle"){
			liste.add(new Cercle(x,y,c));
		}
		else if (nomFigure == "Rectangle"){
			liste.add(new Rectangle(x,y,c));
		}
		else if (nomFigure == "Square"){
			liste.add(new Carre(x,y,c));
		}
		else if (nomFigure == "Ellipse"){
			liste.add(new Ellipse(x,y,c));
		}
	}

	public void mouseReleased(MouseEvent e) {
		int x2=e.getX();
		int y2=e.getY();
		liste.get(liste.size()-1).setBoundingBox(Math.abs(x2-x),Math.abs(y2-y));			
		repaint();
				

	}

	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseDragged(MouseEvent e){
		int x2=e.getX();
		int y2=e.getY();
		liste.get(liste.size()-1).setBoundingBox(Math.abs(x2-x),Math.abs(y2-y));			
		repaint();					
	}
	public void mouseMoved(MouseEvent e){}
	
	public void saveDessin(String name){
		String tosave="";
		for(Figure fig: liste){
			tosave += "\n";
			if (fig.getClass() == Rectangle.class){
				tosave += "Rectangle";
			}
			else if(fig.getClass() == Carre.class){
				tosave += "Carre";
			}
			else if(fig.getClass() == Cercle.class){
				tosave += "Cercle";
			}
			else if(fig.getClass() == Ellipse.class){
				tosave += "Ellipse";
			}
			tosave += "\n"+fig.origine.getX()+" "+fig.origine.getY()+" "+Integer.toString(fig.c.getRGB())+"\n"+fig.getLongueur()+" "+fig.getLargeur();
		}
		try{
			File monFichier = new File(name);
			boolean supprime = monFichier.delete();
			BufferedWriter br = new BufferedWriter(new FileWriter(monFichier));
			br.write(tosave);
			br.flush();
			br.close();
		}
		catch(Exception ex) {
		ex.printStackTrace() ;
		}
	}
	
	public void saveXml(String name){
		try{
			XMLEncoder en = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(name)));
			en.writeObject(liste.get(0));
			en.close();
		}
		catch(Exception ex) {
		ex.printStackTrace() ;
		}	
	}
	
	public void openXml(String name){
		try{
			XMLDecoder en = new XMLDecoder(new BufferedInputStream(new FileInputStream(name)));
			liste.add((Rectangle)en.readObject());
			en.close();
			repaint();
		}
		catch(Exception ex) {
		ex.printStackTrace() ;
		}	
	}
	public void openDessin(String name){
		try {
			File monFichier = new File(name);
			FileReader fr = new FileReader(monFichier);
			BufferedReader br = new BufferedReader(fr);
			String ligne = br.readLine();
			String[] resultat = null;
			String type = null;
			this.resetList();
			while ((ligne = br.readLine()) != null) {
				type = ligne;
				ligne = br.readLine();
				resultat = ligne.split(" ");

				x = Integer.parseInt(resultat[0]);
				y = Integer.parseInt(resultat[1]);
				
				c = new Color(Integer.parseInt(resultat[2]));
				
				if (type.equals("Cercle")){
					liste.add(new Cercle(x,y,c));
				}
				else if (type.equals("Rectangle")){
					liste.add(new Rectangle(x,y,c));
				}
				else if (type.equals("Carre")){
					liste.add(new Carre(x,y,c));
				}
				else if (type.equals("Ellipse")){
					liste.add(new Ellipse(x,y,c));
				}
				
				ligne = br.readLine();
				resultat = ligne.split(" ");
				liste.get(liste.size()-1).setBoundingBox(Integer.parseInt(resultat[0]),Integer.parseInt(resultat[1]));			
				
			}
			repaint();
			br.close() ;
			}
		catch(Exception ex) {
		ex.printStackTrace() ;
		}
	}
}
