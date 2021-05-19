package model.type;

import java.io.IOException;

import javax.imageio.ImageIO;

import contract.IBlock;
import model.Block;
import model.Model;

public class Wall extends Block implements IBlock {

	protected boolean breakable;

	public Wall(int posX, int posY, boolean breakable) {
    super(posX, posY);
    try {
    	if (breakable) {
    		this.setSprite(ImageIO.read(Model.class.getResource("/wall.png")));
    	} else {
    		this.setSprite(ImageIO.read(Model.class.getResource("/unbreakableWall.png")));
    	}
	} catch (IOException e) {
		
		e.printStackTrace();
	}
    this.breakable = breakable;
  }
}
