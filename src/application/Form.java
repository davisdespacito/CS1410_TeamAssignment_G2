package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * 
 * @param a
 * @param b
 * @param c
 * @param d
 * @param name
 */
public class Form {
	Rectangle a;
	Rectangle b;
	Rectangle c;
	Rectangle d;
	Color color;
	private String name;
	public int form = 1;

	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 */
	public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param name
	 */
	public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.name = name;

		// Sets color of each group of blocks
		switch (name)

		{
		case "j":
			color = Color.DARKGRAY;
			break;
		case "l":
			color = Color.LIGHTGOLDENRODYELLOW;
			break;
		case "o":
			color = Color.CORAL;
			break;
		case "s":
			color = Color.AQUAMARINE;
			break;
		case "t":
			color = Color.CORNFLOWERBLUE;
			break;
		case "z":
			color = Color.DEEPPINK;
			break;
		case "i":
			color = Color.SANDYBROWN;
			break;
		}

		this.a.setFill(color);
		this.b.setFill(color);
		this.c.setFill(color);
		this.d.setFill(color);
	}

	/**
	 * Getter for ..
	 * 
	 * @return
	 */
	public String getName() {
		return name;
		
	}
	
	/**
	 * 
	 */
	public void changeForm() {
		if (form !=4) {
			form++;
		}
		else {
			form = 1;
			
		}
	}
}
