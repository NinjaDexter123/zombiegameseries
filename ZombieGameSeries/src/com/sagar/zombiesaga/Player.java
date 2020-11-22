package com.sagar.zombiesaga;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Player extends GameObject {
	
	public Player(  float x, float y,  ID id) {
		super(x, y, id);
		
		velX = 1;
		velY = 1;
	}
	
	public void tick() {
		x  += velX;
		y += velY;
		
		if (x > Game.WIDTH) x = 0; 
	}
	
	public void render(Graphics g) {
		g.setColor(Color.magenta);
		g.fillRect((int)x, (int)y, 25, 35);
	}
	
	
}
