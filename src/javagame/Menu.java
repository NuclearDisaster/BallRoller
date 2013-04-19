package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
	
	Image face, play, end, dock, bg;
	int faceX = 0, faceY = 245;
	int playX = 0, playY = 365; // 630
	int endX = 715, endY = 365;
	int dockX = 0, dockY = 350;
	int bgX = 50, bgY = 0;
	
	public String mouseOver = "NO DATA";
	
	public Menu (int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		play = new Image("res/play.png");
		end = new Image("res/end.png");
		bg = new Image("res/menuback.jpg");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		bg.draw(bgX, bgY);
		//dock.draw(dockX,dockY);
		play.draw(playX, playY);
		end.draw(endX, endY);
		//face.draw(faceX, faceY);
		g.drawString(mouseOver, 750, 0);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		int xpos = Mouse.getX(), ypos = Mouse.getY();
		mouseOver ="x:" + xpos + "\ny:" + ypos;	
		if ((xpos>0 && xpos<85) && (ypos>0 && ypos<85)) {
			if (input.isMousePressed(0)) {
				sbg.enterState(1);
			}	
		}
		if ((xpos>715 && xpos<800) && (ypos>0 && ypos<85)) {
			if (input.isMousePressed(0)) {
				System.exit(0);
			}	
		}	
	}
	
	public int getID() {
		return 0;
	}
}
