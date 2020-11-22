package com.sagar.zombiesaga;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable {
	 
	public String title = "Zombie Game";
	
	private Handler handler;
	
	static int WIDTH = 800;
	private static int HEIGHT = 640;
    
	private  Thread  thread;
	
	
	private boolean isRunning = false;
	
	public Game() {
		
		 new Window(WIDTH, HEIGHT, title, this);
		
		 start();
		
		 init();
		 handler.addObject(new Player(120, 135, ID.Player));
		 handler.addObject(new Player(160, 235, ID.Player));
		 handler.addObject(new Player(20, 335, ID.Player)); 
         handler.addObject(new Player(150, 35, ID.Player)); 

         handler.addObject(new Player(200, 135, ID.Player)); 
         handler.addObject(new Player(100, 235, ID.Player)); 
         handler.addObject(new Player(100, 135, ID.Player));
         handler.addObject(new Player(300, 235, ID.Player));
         
         

	}
	
	private void init() {
		handler = new Handler();
	}
	
	private synchronized void start() {
		if (isRunning) return;
		thread = new Thread(this);
		thread.start();
		isRunning =true;
		
	}
	
	private synchronized void stop() {
		if(!isRunning) return;
		
		try {
			   thread.join();
		} 
		
		      catch (InterruptedException e) {
		       e.printStackTrace();
		}
		isRunning = false;
	}
	
	
	


	@Override
	public void run() {
	this.requestFocus();
	long lastTime = System.currentTimeMillis();
	double amountOfTicks = 60.0;
	double ns = 1000000000/ amountOfTicks;
	double delta =0;
	long timer = System.currentTimeMillis();
	int frames =0;
	while (isRunning) {
		long now = System.nanoTime();
		delta += (now -lastTime)/ns;
	    lastTime = now;
	    while(delta >= 1) {
	    	tick();
	    	delta--;
	    }
	    
	    render();
	    frames++;
	
	  if(System.currentTimeMillis() - timer > 1000) {
		  
		  timer += 1000;
		  frames = 0;
	  }
	
	}
	
	stop();
	
	
	
	}
	
	private void tick() {
		
		handler.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null  ) {
			this.createBufferStrategy(3);
			
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.magenta);
		
		handler.render(g);
		bs.show();
		
		g.dispose();
		
	}
	
	public static void main(String[] args) {
		
    new Game();
	    }

	
	
		
	}


