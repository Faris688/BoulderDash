package model;

import java.util.ArrayList;

import org.json.JSONObject;

import contract.IBlock;
import model.type.Diamond;
import model.type.End;
import model.type.Ground;
import model.type.Monster;
import model.type.Rock;
import model.type.Wall;
import contract.IMap;
public class Map {

	//providing some attribut
	private String dataMap;
	private ArrayList<IBlock> generatedMap = new ArrayList<IBlock>();
	private int Width;
	private int Height;
	private int diamonds;
	private Block end;
	
	public Map(String dataMap, int width, int height, int n_diamonds) {
		this.setDataMap(dataMap);
		this.setWidth(width);
		this.setHeight(height);
		this.setDiamonds(n_diamonds);
	}
	
	/**
	 * Instantiating a new Map.
	 */
	public Map() {
		this("",0,0,0);
	}

	public String getDataMap() {
		return dataMap;
	}

	public void setDataMap(String dataMap) {
		this.dataMap = dataMap;
		if (!dataMap.equals("")) {
			generateMap();
		}
	}

	public int getWidth() {
		return Width;
	}

	public void setWidth(int width) {
		Width = width;
	}

	public int getHeight() {
		return Height;
	}

	public void setHeight(int height) {
		Height = height;
	}
	
	public ArrayList<IBlock> getGeneratedMap() {
		return generatedMap;
	}

	public void setGeneratedMap(ArrayList<IBlock> generatedMap) {
		this.generatedMap = generatedMap;
	}

	public int getDiamonds() {
		return diamonds;
	}

	public void setDiamonds(int diamonds) {
		this.diamonds = diamonds;
	}

	public Block getEnd() {
		return end;
	}

	public void setEnd(IBlock end) {
		this.end = (Block) end;
	}
	
	/**
	 * Generates the map
	 */
	public void generateMap() {
		JSONObject obj = new JSONObject(this.dataMap);
		for (int i=0; i<22*16; i+=16) {
	    	  for(int x=0; x<40*16; x+=16) {
	    		  String block = obj.getJSONObject(String.valueOf(i/16)).getJSONObject(String.valueOf(x/16)).getString("type");
	    		  switch(block) {
	    		  	case "Wall":
	    		  		Wall uwall = new Wall(x, i, false);
		    			this.generatedMap.add(uwall);
		    			break;
	    		  	case "breakableWall":
	    		  		Wall wall = new Wall(x, i, true);
		    			this.generatedMap.add(wall);
		    			break;
	    		  	case "stone":
	    		  		Rock rock = new Rock(x, i);
		    			this.generatedMap.add(rock);
		    			break;
	    		  	case "diamond":
	    		  		Diamond diamond = new Diamond(x, i);
		    			this.generatedMap.add(diamond);
		    			break;
	    		  	case "dirt":
	    		  		Ground ground = new Ground(x, i, false);
		    			this.generatedMap.add(ground);
		    			break;
	    		  	case "void":
	    		  		Ground vground = new Ground(x,i,true);
	    		  		this.generatedMap.add(vground);
	    		  		break;
	    		  	case "end":
	    		  		End end = new End(x, i);
	    		  		this.setEnd(end);
	    		  		this.generatedMap.add(end);
	    		  		break;
	    		  	case "monster":
	    		  		Monster monster = new Monster(x,i);
	    		  		this.generatedMap.add(monster);
	    		  		break;
	    		  }
	    	  }
	      }
		}
	}
	