package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Pause extends BasicGameState {
	
	public Pause (int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Pause Menu State!", 100, 100);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			sbg.enterState(1);
		} 
	}
	
	public int getID() {
		return -1;
	}
}