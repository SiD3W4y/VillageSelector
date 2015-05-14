package com.SiD3W4y.graphics;

import java.awt.Image;
import java.util.ArrayList;

import com.SiD3W4y.objects.Buildings;

public class GraphicList {
	private ArrayList<GraphicObject> texlist;
	
	public GraphicList(){
		texlist = new ArrayList<GraphicObject>();
		
		// Getting textures
		query("AA_TOWER",8,Buildings.AA_TOWER);
		query("ARCHER_TOWER",13,Buildings.ARCHER_TOWER);
		query("ARMY_CAMP",8,Buildings.ARMY_CAMP);
		query("BARRACK",10,Buildings.BARRACKS);
		query("CANNON",13,Buildings.CANNON);
		query("CLAN_CASTLE",6,Buildings.CASTLE);
		query("DARK_BARRACK",6,Buildings.DARK_BARRACKS);
		query("DE_DRILL",6,Buildings.DE_PUMP);
		query("DE_STORAGE",6,Buildings.DE_STORAGE);
		query("ELIXIR_PUMP",12,Buildings.ELIXIR_PUMP);
		query("ELIXIR_STORAGE",11,Buildings.ELIXIR_STORAGE);
		query("GOLD_MINE",12,Buildings.GOLD_MINE);
		query("GOLD_STORAGE",11,Buildings.GOLD_STORAGE);
		query("INFERNO",3,Buildings.INFERNO);
		query("LABORATORY",8,Buildings.LABORATORY);
		query("MORTAR",8,Buildings.MORTAR);
		query("SPELL_FACTORY",5,Buildings.SPELL_FACTORY);
		query("TESLA",8,Buildings.TESLA_TOWER);
		query("TOWNHALL",10,Buildings.TOWNHALL);
		query("WALL",11,Buildings.WALL);
		query("WIZARD_TOWER",8,Buildings.WIZARD_TOWER);
		query("XBOW",4,Buildings.XBOW);
		query("BK_ALTAR",1,Buildings.BK_ALTAR);
		query("AQ_ALTAR",1,Buildings.AQ_ALTAR);
		query("BUILDER_HOUSE",1,Buildings.WORKER_HOUSE);
	}
	
	public void query(String fname,int maxlvl,int id){
		for(int i=1;i<(maxlvl+1);i++){
			String path = "/img/"+fname+"/"+i+".png";
			texlist.add(new GraphicObject(path,id,i));
			//System.out.println("Loading : "+path);
		}
	}
	
	public Boolean textureExist(int id){
		for(int i=0;i < texlist.size();i++){
			if(texlist.get(i).getID() == id){
				return true;
			}
		}
		return false;
	}
	
	public Image getTexture(int id,int level){
		level = level + 1;
		
		for(int i=0;i < texlist.size();i++){
			GraphicObject gx = texlist.get(i);
			
			if(gx.getID() == id && gx.getLevel() == level){
				return gx.getTexture();
			}
		}
		return null;
	}

}
