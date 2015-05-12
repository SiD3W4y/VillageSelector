package com.SiD3W4y.containers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.SiD3W4y.objects.Ressource;
import com.SiD3W4y.utils.GameObject;
import com.SiD3W4y.utils.ObjectConverter;

public class DecosList {
	private ObjectConverter bc;
	private ArrayList<GameObject> decosObjs;
	
	public DecosList(JSONArray jarray){
		bc = new ObjectConverter(Ressource.DECOS);
		decosObjs = new ArrayList<GameObject>();
		
		try{
		for(int i=0; i < jarray.length();i++){
			decosObjs.add(new GameObject(jarray.getJSONObject(i)));
		}
		}catch(JSONException e){
			e.printStackTrace();
		}
	}
	
	public String getObjectName(GameObject gc){
		return bc.getName(gc.getObjectID());
	}
	
	public JSONArray getJsonForm(){
		JSONArray arr = new JSONArray();
		
		for(int i=0;i < decosObjs.size();i++){
			arr.put(decosObjs.get(i).getJsonForm());
		}
		
		return arr;
	}
	
	public ArrayList<GameObject> getGameObjects(int id){
		ArrayList<GameObject> objlist = new ArrayList<GameObject>();
		
		for(int i=0;i < decosObjs.size();i++){
			GameObject bo = decosObjs.get(i);
			
			if(bo.getObjectID() == id){
				objlist.add(bo);
			}
		}
		
		return objlist;
	}
	
	public ArrayList<GameObject> getAllObjects(){
		return decosObjs;
	}

}
