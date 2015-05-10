package com.SiD3W4y.containers;

import org.json.JSONException;
import org.json.JSONObject;

public class respawnVars {
	
	private int secondsFromLastRespawn;
	private int respawnSeed;
	private int obstacleClearCounter;
	private int time_to_gembox_drop;
	private int time_in_gembox_period;
	
	public respawnVars(JSONObject jsob){
		try {
			secondsFromLastRespawn = jsob.getInt("secondsFromLastRespawn");
			respawnSeed = jsob.getInt("respawnSeed");
			obstacleClearCounter = jsob.getInt("obstacleClearCounter");
			time_to_gembox_drop = jsob.getInt("time_to_gembox_drop");
			time_in_gembox_period = jsob.getInt("time_in_gembox_period");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setObstacleCounter(int count){
		obstacleClearCounter = count;
	}
	
	public void setNextGemboxDrop(int time){
		time_to_gembox_drop = time;
	}
	
	public int getObstacleCounter(){
		return obstacleClearCounter;
	}
	
	public int getNextGemboxDrop(){
		return time_to_gembox_drop;
	}
	
	public JSONObject getJsonForm(){
		JSONObject jobj = new JSONObject();
		try {
			jobj.put("secondsFromLastRespawn",secondsFromLastRespawn);
			jobj.put("respawnSeed",respawnSeed);
			jobj.put("obstacleClearCounter",obstacleClearCounter);
			jobj.put("time_to_gembox_drop",time_to_gembox_drop);
			jobj.put("time_in_gembox_period",time_in_gembox_period);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jobj;
	}
	
	

}
