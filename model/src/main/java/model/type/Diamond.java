package model.type;

import java.io.IOException;

import javax.imageio.ImageIO;

import contract.IBlock;
import model.Block;
import model.Model;

/**
	 * Diamond class
	 */
	public class Diamond extends Block implements IBlock {

		private boolean falling = false;
		// Constructor for Diamond
		public Diamond(int posX, int posY) {
	    super(posX, posY);
	    try {
	    	this.setSprite(ImageIO.read(Model.class.getResource("/diamond.png")));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	  }
		
		public void walkOn() {
			try {
		    	this.setSprite(ImageIO.read(Model.class.getResource("/emptyGround.png")));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

		public boolean isFalling() {
			return falling;
		}

		public void setFalling(boolean falling) {
			this.falling = falling;
		}
		
		
	  
	

}
