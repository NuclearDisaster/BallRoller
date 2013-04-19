package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {

	public static final String GAMENAME = "Life Or Death v2.0b - By: Brian Ho, Andy Zhou, Tadeasko Smolko";
	public static final int pause = -1;
	public static final int menu = 0;
	public static final int play = 1;
	// Window Properties
	public static final int LENGTH = 800;
	public static final int WIDTH = 450;
	
	public Game (String GAMENAME) {
		super(GAMENAME);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Pause(pause));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(pause).init(gc, this);
		this.enterState(menu); // Shows default user enter state
	}
	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Game(GAMENAME));
			appgc.setDisplayMode(LENGTH, WIDTH, false);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
