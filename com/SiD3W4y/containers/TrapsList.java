package com.SiD3W4y.containers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.SiD3W4y.objects.Ressource;
import com.SiD3W4y.utils.GameObject;
import com.SiD3W4y.utils.ObjectConverter;

public class TrapsList {
	private ObjectConverter bc;
	private ArrayList<GameObject> trapsObjs;
	
	public TrapsList(JSONArray jarray){
		trapsObjs = new ArrayList<GameObject>();
		bc = new ObjectConverter(Ressource.TRAPS);
		
		try{
		for(int i=0; i < jarray.length();i++){
			trapsObjs.add(new GameObject(jarray.getJSONObject(i)));
		}
		}catch(JSONException e){
			e.printStackTrace();
		}
	}
	
	public String getObjectName(GameObject gc){
		return bc.getName(gc.getObjectID());
	}
	
	public void setLevel(int x,int y,int level){
		for(int i=0;i < trapsObjs.size();i++){
			GameObject bo = trapsObjs.get(i);
			
			if(bo.getXpos() == x && bo.getYpos() == y){
				bo.setLevel(level);
			}
		}
	}
	
	public void setComponentLevel(int id,int level){
		for(int i=0;i < trapsObjs.size();i++){
			GameObject bo = trapsObjs.get(i);
			
			if(bo.getObjectID() == id){
				bo.setLevel(level);
			}
		}
	}
	
	public JSONArray getJsonForm(){
		JSONArray arr = new JSONArray();
		
		for(int i=0;i < trapsObjs.size();i++){
			arr.put(trapsObjs.get(i).getJsonForm());
		}
		
		return arr;
	}
	
	public ArrayList<GameObject> getBuildings(int id){
		ArrayList<GameObject> objlist = new ArrayList<GameObject>();
		
		for(int i=0;i < trapsObjs.size();i++){
			GameObject bo = trapsObjs.get(i);
			
			if(bo.getObjectID() == id){
				objlist.add(bo);
			}
		}
		
		return objlist;
	}


}
