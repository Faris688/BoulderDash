package model;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {

	private int posX;
	private int posY;
	private Image sprite;
	private int score;
	
	public Player() {
		this.posX = 16;
		this.posY = 16;
		this.score = 0;
		try {
	    	this.setSprite(ImageIO.read(Model.class.getResource("/Normal.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		try {
			if (posX > 0) {
		    	this.setSprite(ImageIO.read(Model.class.getResource("/Right.png")));
			} else {
				this.setSprite(ImageIO.read(Model.class.getResource("/Left.png")));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.posX += posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		try {
			if (posY > 0) {
		    	this.setSprite(ImageIO.read(Model.class.getResource("/Down.png")));
			} else {
				this.setSprite(ImageIO.read(Model.class.getResource("/Up.png")));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.posY += posY;
	}
	
	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score += score;
	}
	
	/**
	 * Printing a message on immediate death and automatically closing the window.
	 */
	public void die() {
		try {
			this.setSprite(ImageIO.read(Model.class.getResource("/Death.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}