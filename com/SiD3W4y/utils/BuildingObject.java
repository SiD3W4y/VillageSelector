package com.SiD3W4y.utils;

import java.util.ArrayList;

import org.json.*;

import com.SiD3W4y.Objects.Buildings;

public class BuildingObject {
	
	// Fixed values
	
	private int id;
	private int x_pos;
	private int y_pos;
	private int level;
	
	// Optional values
	
	int collector_timer;
	int storage_type;
	int unit_prod_type;
	
	ArrayList<Integer> troops_id;
	ArrayList<Integer> troops_cnt;
	
	// Switches
	
	boolean ctimer;
	boolean stype;
	boolean has_units;
	
	public BuildingObject(JSONObject jsob){
		try{
		id = jsob.getInt("data");
		x_pos = jsob.getInt("x");
		y_pos = jsob.getInt("y");
		level = jsob.getInt("lvl");
		
		if(jsob.has("res_time")){
			collector_timer = jsob.getInt("res_time");
			ctimer = true;
		}
		if(jsob.has("storage_type")){
			storage_type = jsob.getInt("storage_type");
			stype = true;
		}
		
		}catch(JSONException e){
			e.printStackTrace();
		}
	
	}
	
	public int getBuildingID(){
		return id;
	}
	
	public int getXpos(){
		return x_pos;
	}
	
	public int getYpos(){
		return y_pos;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setLevel(int lvl){
		level = (lvl -1);
	}
	
	public JSONObject getJsonForm(){
		JSONObject js = new JSONObject();
		try {
			js.put("data",id);
			js.put("lvl",level);
			js.put("x",x_pos);
			js.put("y", y_pos);
			
			if(ctimer == true){
				js.put("res_timer",collector_timer);
			}
			if(stype == true){
				js.put("storage_type", storage_type);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return js;
	}

	
	
	
	}


