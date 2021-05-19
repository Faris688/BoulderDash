package model.type;

import java.io.IOException;

import javax.imageio.ImageIO;

import contract.IBlock;
import model.Block;
import model.Model;

public class End extends Block implements IBlock {

	//Constructor of End
	public End(int posX, int posY) {
		super(posX, posY);
		try {
			this.setSprite(ImageIO.read(Model.class.getResource("/emptyGround.png")));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
  }
	
	public void release() {
		try {
			this.setSprite(ImageIO.read(Model.class.getResource("/Player.png")));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
