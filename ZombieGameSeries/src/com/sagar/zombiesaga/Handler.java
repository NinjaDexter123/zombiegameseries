package com.sagar.zombiesaga;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> listObject  = new LinkedList();
	
	public Handler( ) {
		
		
	}
	
	public void tick() {
		for(GameObject tempObject: listObject) {
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		for(GameObject tempObject: listObject) {
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject tempObject) {
		
		listObject.add(tempObject);
	}



public void removeObject(GameObject tempObject) {
	
	listObject.remove(tempObject);


}
}
