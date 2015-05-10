package com.SiD3W4y.containers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.SiD3W4y.utils.BuildingConverter;
import com.SiD3W4y.utils.BuildingObject;

public class BuildingsList {
	private BuildingConverter bc;
	private ArrayList<BuildingObject> buildingObjs;
	
	public BuildingsList(JSONArray jarray){
		buildingObjs = new ArrayList<BuildingObject>();
		
		try{
		for(int i=0; i < jarray.length();i++){
			buildingObjs.add(new BuildingObject(jarray.getJSONObject(i)));
		}
		}catch(JSONException e){
			e.printStackTrace();
		}
	}
	
	public void setLevel(int x,int y,int level){
		for(int i=0;i < buildingObjs.size();i++){
			BuildingObject bo = buildingObjs.get(i);
			
			if(bo.getXpos() == x && bo.getYpos() == y){
				bo.setLevel(level);
			}
		}
	}
	
	public void setComponentLevel(int id,int level){
		for(int i=0;i < buildingObjs.size();i++){
			BuildingObject bo = buildingObjs.get(i);
			
			if(bo.getBuildingID() == id){
				bo.setLevel(level);
			}
		}
	}
	
	public JSONObject getJsonForm(){
		JSONArray arr = new JSONArray();
		JSONObject jsob = new JSONObject();
		
		for(int i=0;i < buildingObjs.size();i++){
			arr.put(buildingObjs.get(i).getJsonForm());
		}
		
		try {
			jsob.put("buildings", arr);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return jsob;
	}
	
	public ArrayList<BuildingObject> getBuildings(int id){
		ArrayList<BuildingObject> objlist = new ArrayList<BuildingObject>();
		
		for(int i=0;i < buildingObjs.size();i++){
			BuildingObject bo = buildingObjs.get(i);
			
			if(bo.getBuildingID() == id){
				objlist.add(bo);
			}
		}
		
		return objlist;
	}

}
