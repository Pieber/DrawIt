import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.io.*;



class Fenetre extends JFrame implements WindowListener,ActionListener{
	
	private Dessin des;
	
	public Fenetre(String titre){
	super(titre);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocation(0,200);
	setSize(1000,500);
	
	Container contentPane = getContentPane() ;
	JMenuBar m= new JMenuBar();
	JMenu menu1=new JMenu("Fichiers");
	JMenuItem un = new JMenuItem("Open") ;
	un.addActionListener(this);
	menu1.add(un);
	//raccourci
	un.setAccelerator(KeyStroke.getKeyStroke('O',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),false));
	//separe d’un trait
	JMenuItem neuf = new JMenuItem("New");
	neuf.addActionListener(this);
	menu1.add(neuf);
	
	JMenuItem save = new JMenuItem("Save") ;
	save.addActionListener(this);
	menu1.add(save);
	//raccourci
	save.setAccelerator(KeyStroke.getKeyStroke('S',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),false));
	//
	menu1.addSeparator();
	JMenuItem quit = new JMenuItem("Quit");
	quit.addActionListener(this);
	menu1.add(quit);
	m.add(menu1);
	JMenu menu3 = new JMenu("Import/Export");
	JMenuItem extext = new JMenuItem("Export as text");
	extext.addActionListener(this);
	JMenuItem xml = new JMenuItem("Export as xml(Rectangle only)");
	xml.addActionListener(this);
	JMenuItem xmli = new JMenuItem("Import as xml(Rectangle only)");
	xmli.addActionListener(this);
	JMenuItem imtext = new JMenuItem("Import as text");
	imtext.addActionListener(this);
	menu3.add(extext);
	menu3.add(imtext);
	menu3.add(xml);
	menu3.add(xmli);
	m.add(menu3);
	
	JMenu menu2 = new JMenu("A propos");
	JMenuItem auteurs = new JMenuItem("Auteurs");
	auteurs.addActionListener(this);
	menu2.add(auteurs);
	m.add(menu2);
	setJMenuBar(m);

	JPanel pan1=new JPanel();
	JPanel pan2=new JPanel();
	JPanel pan3=new JPanel();
	
	pan1.setLayout(new GridLayout(1,2));
	pan2.setLayout(new GridLayout(2,4));
	pan3.setLayout(new GridLayout(2,2));
	
	pan1.add(pan2);
	
	JButton black = new JButton("Black");
	black.addActionListener(this);
	black.setBackground(Color.black);
	pan2.add(black);
	
	JButton red = new JButton("Red");
	red.addActionListener(this);
	red.setBackground(Color.red);
	pan2.add(red);
	
	JButton green = new JButton("Green");
	green.addActionListener(this);
	green.setBackground(Color.green);
	pan2.add(green);
	
	JButton blue = new JButton("Blue");
	blue.addActionListener(this);
	blue.setBackground(Color.blue);
	pan2.add(blue);
	
	JButton yellow = new JButton("Yellow");
	yellow.addActionListener(this);
	yellow.setBackground(Color.yellow);
	pan2.add(yellow);
	
	JButton pink = new JButton("Pink");
	pink.addActionListener(this);
	pink.setBackground(Color.pink);
	pan2.add(pink);
	
	JButton magenta = new JButton("Magenta");
	magenta.addActionListener(this);
	magenta.setBackground(Color.magenta);
	pan2.add(magenta);
	
	JButton orange = new JButton("Orange");
	orange.addActionListener(this);
	orange.setBackground(Color.orange);
	pan2.add(orange);

	
	pan1.add(pan3);
	JButton ellipse = new JButton("Ellipse");
	ellipse.addActionListener(this);
	pan3.add(ellipse);
	
	JButton circle = new JButton("Circle");
	circle.addActionListener(this);
	pan3.add(circle);
	
	JButton square = new JButton("Square");
	square.addActionListener(this);
	pan3.add(square);
	
	JButton rectangle = new JButton("Rectangle");
	rectangle.addActionListener(this);
	pan3.add(rectangle);

	
	contentPane.add(pan1,"South");
	des = new Dessin();
	contentPane.add(des, "Center");

	JButton monbouton = new JButton("Bonjour");
	monbouton.addActionListener(this);
	/*error: Fenetre is not abstract and does not override abstract method windowDeactivated(WindowEvent) in WindowListener*/
	setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Square")) {
			des.setName("Square");		
		}
		else if(cmd.equals("Rectangle")){
			des.setName("Rectangle");
		}
		else if(cmd.equals("Circle")){
			des.setName("Cercle");
		}
		else if(cmd.equals("Ellipse")){
			des.setName("Ellipse");
		}
		else if(cmd.equals("Black")){
			des.setColor(Color.black);
		}
		else if(cmd.equals("Red")){
			des.setColor(Color.red);
		}
		else if(cmd.equals("Yellow")){
			des.setColor(Color.yellow);
		}
		else if(cmd.equals("Blue")){
			des.setColor(Color.blue);
		}
		else if(cmd.equals("Orange")){
			des.setColor(Color.orange);
		}
		else if(cmd.equals("Pink")){
			des.setColor(Color.pink);
		}
		else if(cmd.equals("Magenta")){
			des.setColor(Color.magenta);
		}
		else if(cmd.equals("Green")){
			des.setColor(Color.green);
		}
		else if(cmd.equals("New")){
			des.resetList();
			repaint();
		}
		else if(cmd.equals("Auteurs")){
			JOptionPane.showMessageDialog(new JFrame(),"Pierre-Bernard Le Roux with the divine guidance of God Coremori","The Winners are...",JOptionPane.WARNING_MESSAGE);
		}
		else if(cmd.equals("Quit")) {
			System.exit(0);
		}
		else if(cmd.equals("Export as text")){
			des.saveDessin("miam.txt");
		}
		else if(cmd.equals("Export as xml")){
			des.saveXml("Rectangle.xml");
		}
		else if(cmd.equals("Import as text")){
			des.openDessin("miam.txt");
		}
		else if(cmd.equals("Import as xml")){
			des.openXml("Rectangle.xml");
		}
		else if(cmd.equals("Save")){
			
			/*try {
				 FileOutputStream out = new FileOutputStream("test.ser");
				 ObjectOutputStream oout = new ObjectOutputStream(out);
				 oout.writeObject(this.des);
				 oout.flush();
				 oout.close();
			} catch (Exception ex) {
				 ex.printStackTrace();
			}*/
		}
		else if(cmd.equals("Open")) {
			/*try{
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.ser"));
				this.des = (Dessin) ois.readObject();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
				des.repaint();*/
		}
		else {
			System.err.println(cmd);
		}
	}
	 
	 
	public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
        }
	
	public void windowOpened(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}

}
