package com.SiD3W4y.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.SiD3W4y.containers.BuildingsList;
import com.SiD3W4y.objects.Buildings;
import com.SiD3W4y.objects.Ressource;
import com.SiD3W4y.utils.GameObject;
import com.SiD3W4y.utils.ObjectConverter;

public class ImageBuilder {
	private ArrayList<GameObject> objlist;
	private BufferedImage tiledBackground;
	private Graphics2D editSpace;
	
	private GraphicList glist;
	private ObjectConverter oc;
	
	private int TileSize = 20;
	
	
	public ImageBuilder(){
		glist = new GraphicList();
		oc = new ObjectConverter(Ressource.BUILDINGS);
	}
	
	public void setBuildings(BuildingsList bls){
		objlist = bls.getAllObjects();
		reset();
	}
	
	public void reset(){
		InputStream in = getClass().getResourceAsStream("/img/background.png");
		try {
			tiledBackground = ImageIO.read(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void process(){
		editSpace = tiledBackground.createGraphics();
		for(int i=0;i < objlist.size();i++){
			GameObject obj = objlist.get(i);
			if(glist.textureExist(obj.getObjectID())){
				int size = oc.getSize(obj.getObjectID());
				int objx = obj.getXpos()*TileSize;
				int objy = obj.getYpos()*TileSize;
				Image cimg = glist.getTexture(obj.getObjectID(),obj.getLevel());
				editSpace.drawImage(cimg,objx-(size*TileSize),objy-(size*TileSize),null);
			}
		}
	}
	
	public void imageToFile(String path){
		try {
			ImageIO.write(tiledBackground,"PNG",new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage(){
		return tiledBackground;
	}

	
	

}
