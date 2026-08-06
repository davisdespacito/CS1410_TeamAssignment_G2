package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tetris extends Application {

	// VARIABLES
	public static final int MOVE = 25;
	public static final int SIZE = 25;
	public static final int XMAX = SIZE * 12;
	public static final int YMAX = SIZE * 24;
	public static final int[][] MESH = new int[XMAX / SIZE][YMAX / SIZE];
	private static Pane groupe = new Pane();
	private static Form object;
	private static Scene scene = new Scene(groupe, XMAX + 150, YMAX);
	public static int score = 0;
	public static int top = 0;
	private static boolean game = true;
	private static Form nextObj = Controller.makeRect();
	private static int linesNo = 0;

	// Creating initial scene, starting game
	public void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		for (int[] a : MESH) {
			Arrays.fill(a, 0);
		}

		// Making score and level text
		Line line = new Line(XMAX, 0, XMAX, YMAX);
		Text scoretext = new Text("SCORE: ");
		scoretext.setStyle("-fx-font: 20 mono;");
		scoretext.setY(60);
		scoretext.setX(XMAX + 5);
		Text level = new Text("Lines: ");
		level.setStyle("-fx-font: 20 mono;");
		level.setY(100);
		level.setX(XMAX + 5);
		level.setFill(Color.GREEN);
		groupe.getChildren().addAll(scoretext, line, level);

		// Creating first block and stage
		Form a = nextObj;
		groupe.getChildren().addAll(a.a, a.b, a.c, a.d);
		moveOnKeyPressed(a);
		object = a;
		nextObj = Controller.makeRect();
		stage.setScene(scene);
		stage.setTitle("T E T R I S");
		stage.show();

		// TIMER
		Timer fall = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						if (object.a.getY() == 0 || object.b.getY() == 0 || object.c.getY() == 0
								|| object.d.getY() == 0) {
							top++;
						} else
							top = 0;

						if (top == 2) {

							// GAME OVER
							Text over = new Text("G A M E  O V E R");
							over.setFill(Color.RED);
							over.setStyle("-fx-font: 70 mono;");
							over.setY(250);
							over.setX(10);
							groupe.getChildren().add(over);
							game = false;

						}

						// EXIT
						if (top == 15) {
							System.exit(0);

						}

						if (game) {

							MoveDown(object);
							scoretext.setText("Score: " + Integer.toString(score));
							level.setText("Lines: " + Integer.toString(linesNo));
						}

					}
				});
			}

		};
		fall.schedule(task, 0, 300);

	}

	private void moveOnKeyPressed(Form form) {

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {

				switch (event.getCode()) {
				case RIGHT:
					Controller.MoveRight(form);
					break;
				case DOWN:
					ModeDown(form);
					score++;
					break;
				case LEFT:
					Controller.MoveLeft(form);
					break;
				case UP:
					MoveTurn(form);
					break;
				}

			}
		});

	}
	
	// Meeting #2

	private void MoveTurn(Form form) {
		int f = form.form;
		Rectangle a = form.a;
		Rectangle b = form.b;
		Rectangle c = form.c;
		Rectangle d = form.d;
		switch (form.getName()) {
		case "j":
		     if ( f == 1 && cB(a,1, -1) && cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     
		     }
		     
		     if ( f == 2 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
			     MoveRight(form.a);
			     MoveDown(form.a);
			     MoveDown(form.c);
			     MoveLeft(form.c);
			     MoveDown(form.d);
			     MoveDown(form.d);
			     MoveLeft(form.d);
			     MoveLeft(form.d);
			     form.changeForm();
			     break;	     	     
		     }
		     

		     if ( f == 3 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
			     MoveRight(form.a);
			     MoveDown(form.a);
			     MoveDown(form.c);
			     MoveLeft(form.c);
			     MoveDown(form.d);
			     MoveDown(form.d);
			     MoveLeft(form.d);
			     MoveLeft(form.d);
			     form.changeForm();
			     break;	     	     
		     }
		     

		     if ( f == 4 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
			     MoveRight(form.a);
			     MoveDown(form.a);
			     MoveDown(form.c);
			     MoveLeft(form.c);
			     MoveDown(form.d);
			     MoveDown(form.d);
			     MoveLeft(form.d);
			     MoveLeft(form.d);
			     form.changeForm();
			     break;	     	     
		     }
		     
		case "l";
	     if ( f == 1 && cB(a,1, -1) && cB(c,-1,-1) && cB(d,-2,-2)) {
	     MoveRight(form.a);
	     MoveDown(form.a);
	     MoveDown(form.c);
	     MoveLeft(form.c);
	     MoveDown(form.d);
	     MoveDown(form.d);
	     MoveLeft(form.d);
	     MoveLeft(form.d);
	     form.changeForm();
	     break;	     
	     }
	     
	     if ( f == 2 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
	     

	     if ( f == 3 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
	     

	     if ( f == 4 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
	     
		case "o";
	     if ( f == 1 && cB(a,1, -1) && cB(c,-1,-1) && cB(d,-2,-2)) {
	     MoveRight(form.a);
	     MoveDown(form.a);
	     MoveDown(form.c);
	     MoveLeft(form.c);
	     MoveDown(form.d);
	     MoveDown(form.d);
	     MoveLeft(form.d);
	     MoveLeft(form.d);
	     form.changeForm();
	     break;	     
	     }
	     
	     if ( f == 2 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
	     

	     if ( f == 3 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
	     

	     if ( f == 4 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
	     
		case "s";
	     if ( f == 1 && cB(a,1, -1) && cB(c,-1,-1) && cB(d,-2,-2)) {
	     MoveRight(form.a);
	     MoveDown(form.a);
	     MoveDown(form.c);
	     MoveLeft(form.c);
	     MoveDown(form.d);
	     MoveDown(form.d);
	     MoveLeft(form.d);
	     MoveLeft(form.d);
	     form.changeForm();
	     break;	     
	     }
	     
	     if ( f == 2 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
	     

	     if ( f == 3 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
	     

	     if ( f == 4 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
	     
		case "t";
	     if ( f == 1 && cB(a,1, -1) && cB(c,-1,-1) && cB(d,-2,-2)) {
	     MoveRight(form.a);
	     MoveDown(form.a);
	     MoveDown(form.c);
	     MoveLeft(form.c);
	     MoveDown(form.d);
	     MoveDown(form.d);
	     MoveLeft(form.d);
	     MoveLeft(form.d);
	     form.changeForm();
	     break;	     
	     }
	     
	     if ( f == 2 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
	     

	     if ( f == 3 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
	     

	     if ( f == 4 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
	     
		case "z";
	     if ( f == 1 && cB(a,1, -1) && cB(c,-1,-1) && cB(d,-2,-2)) {
	     MoveRight(form.a);
	     MoveDown(form.a);
	     MoveDown(form.c);
	     MoveLeft(form.c);
	     MoveDown(form.d);
	     MoveDown(form.d);
	     MoveLeft(form.d);
	     MoveLeft(form.d);
	     form.changeForm();
	     break;	     
	     }
	     
	     if ( f == 2 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
	     

	     if ( f == 3 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
	     

	     if ( f == 4 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
	     
		case "i";
	     if ( f == 1 && cB(a,1, -1) && cB(c,-1,-1) && cB(d,-2,-2)) {
	     MoveRight(form.a);
	     MoveDown(form.a);
	     MoveDown(form.c);
	     MoveLeft(form.c);
	     MoveDown(form.d);
	     MoveDown(form.d);
	     MoveLeft(form.d);
	     MoveLeft(form.d);
	     form.changeForm();
	     break;	     
	     }
	     
	     if ( f == 2 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
	     

	     if ( f == 3 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
	     

	     if ( f == 4 && cB(a,1, -1) &&cB(c,-1,-1) && cB(d,-2,-2)) {
		     MoveRight(form.a);
		     MoveDown(form.a);
		     MoveDown(form.c);
		     MoveLeft(form.c);
		     MoveDown(form.d);
		     MoveDown(form.d);
		     MoveLeft(form.d);
		     MoveLeft(form.d);
		     form.changeForm();
		     break;	     	     
	     }
		}
		
	}

	private void RemoveRows(Pane pane) {
		ArrayList<Node> rects = new ArrayList<Node>();
		ArrayList<Integer> lines = new ArrayList<Integer>();
		ArrayList<Node> newrects = new ArrayList<Node>();
		int full = 0;
		//CHECK WHICH LINE IS FULL
		for (int i = 0; i< MESH[0].length;i++) {
			for (int j = 0; i<MESH.length; j++) {
				if (MESH[j][i] == 1)
					full++;
			}
			
			if (fill == MESH.length)
				libes.add(i+lines.size());
		    full = 0;
		}
		
		//Deleting the row
		if (lines.size() > 0)
			do {
				for (node node : pane.getChildren()) {
					if (node instanceof Rectangle)
						rect.add(node);
				}
				score+= 50;
				linesNo++;
				
				
				
				
				//deleting block on row
				for (Node node: rects) {
					Rectangle a = (Rectangle)node;
					if(a.getY() == lines.get(0)*SIZE) {
						MESH[(int)a.getX()/SIZE][(int)a.getY()/SIZE] = 0;
						pane.getChildren().remove(node);
						
						
					}
					else
						newrects.add(node);
					
				}
				   for (Node node: newrects) {
					   Rectangle a = (Rectangle)node;
					   if (a.getY() < lines.get(0)*SIZE) {
						   MESH[(int)a.getX()/SIZE][(int)a.getY()/SIZE] = 0;
						   a.setY(a.getY() + SIZE);						   
					   }
					   lines.remove(0);
					   rects.clear();
					   newrects.clear();
					   
					   for (Node node: pane.getChildren()) {
						   if (node instanceof Rectangle)
							   rects.add(node);
						   
					   }
					   
					   for (Node node: rects) {
						   
				   }
			}
	}

	private boolean cB(Rectangle rect, int x, int y) {
		boolean yb = false;
		boolean xb = false;
		if (x >= 0)
			xb = rect.getX() + x * MOVE <= XMAX - SIZE;
		if (x < 0)
			xb = rect.getX() + x * MOVE >= 0;
		if (y >= 0)
			yb = rect.getY() + y * MOVE > 0;
		if (y < 0)
			yb = rect.getY() + y * MOVE < YMAX;
		return xb && yb && MESH[((int) rect.getX() / SIZE) + x][((int) rect.getY() / SIZE) - y] == 0;

	}

}

}
