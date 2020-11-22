package com.sagar.zombiesaga;

import java.awt.Graphics;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class GameObject {
	
	protected float x, y;
	
	protected float velX, velY;
	
	protected ID id;
	
	public GameObject(float x, float y, ID id) {
		
		this.x =x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	
	public abstract  void render(Graphics g);
	
	

}
