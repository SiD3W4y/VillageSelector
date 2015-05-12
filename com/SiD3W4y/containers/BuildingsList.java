package com.SiD3W4y.containers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.SiD3W4y.objects.Ressource;
import com.SiD3W4y.utils.ObjectConverter;
import com.SiD3W4y.utils.GameObject;

public class BuildingsList {
	private ObjectConverter bc;
	private ArrayList<GameObject> buildingObjs;
	
	public BuildingsList(JSONArray jarray){
		buildingObjs = new ArrayList<GameObject>();
		bc = new ObjectConverter(Ressource.BUILDINGS);
		
		try{
		for(int i=0; i < jarray.length();i++){
			buildingObjs.add(new GameObject(jarray.getJSONObject(i)));
		}
		}catch(JSONException e){
			e.printStackTrace();
		}
	}
	
	public String getObjectName(GameObject gc){
		return bc.getName(gc.getObjectID());
	}
	
	public void setLevel(int x,int y,int level){
		for(int i=0;i < buildingObjs.size();i++){
			GameObject bo = buildingObjs.get(i);
			
			if(bo.getXpos() == x && bo.getYpos() == y){
				bo.setLevel(level);
			}
		}
	}
	
	public void setComponentLevel(int id,int level){
		for(int i=0;i < buildingObjs.size();i++){
			GameObject bo = buildingObjs.get(i);
			
			if(bo.getObjectID() == id){
				bo.setLevel(level);
			}
		}
	}
	
	public JSONArray getJsonForm(){
		JSONArray arr = new JSONArray();
		
		for(int i=0;i < buildingObjs.size();i++){
			arr.put(buildingObjs.get(i).getJsonForm());
		}
		
		return arr;
	}
	
	public ArrayList<GameObject> getGameObjects(int id){
		ArrayList<GameObject> objlist = new ArrayList<GameObject>();
		
		for(int i=0;i < buildingObjs.size();i++){
			GameObject bo = buildingObjs.get(i);
			
			if(bo.getObjectID() == id){
				objlist.add(bo);
			}
		}
		
		return objlist;
	}
	
	public ArrayList<GameObject> getAllObjects(){
		return buildingObjs;
	}

}
