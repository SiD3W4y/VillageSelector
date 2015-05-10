package com.SiD3W4y.utils;

import com.SiD3W4y.containers.BuildingsList;
import com.SiD3W4y.containers.DecosList;
import com.SiD3W4y.containers.TrapsList;
import com.SiD3W4y.containers.respawnVars;
import com.SiD3W4y.Objects.Buildings;

import org.json.*;


public class Village {
	
	private String VillageJson;
	
	// Some empty stuff (not implemented yet)
	
	private JSONArray cooldowns;
	private JSONArray obstacles;
	private JSONArray newShopBuildings;
	private JSONArray newShopTraps;
	private JSONArray newShopDecos;
	private JSONArray traps;
	private JSONArray decos;
	
	
	// Data container
	
	private BuildingsList buildingLST;
	//private DecosList decosLST;  *** Not used for now , cause it's not implemented in the server yet
	//private TrapsList trapsLST;  *** Not used for now , cause it's not implemented in the server yet
	private respawnVars RespawnVars;
	
	// End of village files vars
	
	private int last_league_rank;
	private int last_league_shuffle;
	private int last_news_seen;
	private boolean edit_mode_shown;
	
	
	
	
	public Village(String json){
		VillageJson = json;
		try{
		JSONObject js = new JSONObject(json);
		
		
		// Filling BuildingList with all village buildings
		buildingLST = new BuildingsList(js.getJSONArray("buildings"));
		
		// Creating obstacles array (empty for now)
		obstacles = new JSONArray();
		
		// Creating cooldown array (empty for now)
		cooldowns = new JSONArray();
		
		// Creating traps array (empty for now)
		traps = new JSONArray();
		
		// Creating decos array (empty for now)
		decos = new JSONArray();
		
		// Creating newShopBuildings array
		newShopBuildings = new JSONArray();
		newShopBuildings = js.getJSONArray("newShopBuildings");
		
		// Creating newShopTraps array 
		newShopTraps = new JSONArray();
		newShopTraps = js.getJSONArray("newShopTraps");
		
		// Creating newShopDecos array
		newShopDecos = new JSONArray();
		newShopDecos = js.getJSONArray("newShopDecos");
		
		// Filling respawnVars with respawn variables (that's pretty straightforward lol)
		RespawnVars = new respawnVars(js.getJSONObject("respawnVars"));
		
		// Getting last vars
		last_league_rank = js.getInt("last_league_rank");
		last_league_shuffle = js.getInt("last_league_shuffle");
		last_news_seen = js.getInt("last_news_seen");
		edit_mode_shown = js.getBoolean("edit_mode_shown");
		
		}catch(JSONException e){
			e.printStackTrace();
		}
		
		
		
	}
	
	public void setLastLeague(int id){
		// You can use Constants defined in com.SiD3W4y.Objects.Leagues (ex : setLastLeague(Leagues.BRONZE_III)
		last_league_rank = id;
	}
	
	public void setEditMode(boolean bool){
		edit_mode_shown = bool;
	}
	
	public JSONObject getVillageFile(){
		JSONObject job = new JSONObject();
		try {
			job.put("buildings",buildingLST.getJsonForm());
			job.put("obstacles", obstacles);
			job.put("traps",traps);
			job.put("decos",decos);
			job.put("respawnVars",RespawnVars.getJsonForm());
			job.put("cooldowns",cooldowns);
			job.put("newShopBuildings",newShopBuildings);
			job.put("newShopTraps",newShopTraps);
			job.put("newShopDecos",newShopDecos);
			job.put("last_league_rank",last_league_rank);
			job.put("last_league_shuffle",last_league_shuffle);
			job.put("last_news_seen",last_news_seen);
			job.put("edit_mode_shown",edit_mode_shown);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return job;
	}
	
	public BuildingsList buildings(){
		return buildingLST;
	}
	
	public respawnVars respawn_vars(){
		return RespawnVars;
	}


}
