import java.io.*;


class Point implements Serializable
{
	private int x;
	private int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	/**
	* retourne l'abscisse du point
	*/
	public int getX()
	{
		return this.x;
	}
	/**
	* retourne l'ordonnee du point
	*/
	public int getY()
	{
		return this.y;
	}

}
