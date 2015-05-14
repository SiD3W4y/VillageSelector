package com.SiD3W4y.graphics;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GraphicObject {
	private Image tex;
	private int id;
	private int level;
	
	public GraphicObject(String path,int nid,int nlevel){
		id = nid;
		level = nlevel;
		
		InputStream in = getClass().getResourceAsStream(path);
		try {
			tex = ImageIO.read(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getID(){
		return id;
	}
	
	public int getLevel(){
		return level;
	}
	
	public Image getTexture(){
		return tex;
	}

}
