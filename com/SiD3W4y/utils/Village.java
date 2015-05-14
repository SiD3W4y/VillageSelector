package com.SiD3W4y.utils;

import com.SiD3W4y.containers.BuildingsList;
import com.SiD3W4y.containers.DecosList;
import com.SiD3W4y.containers.TrapsList;
import com.SiD3W4y.containers.respawnVars;
import com.SiD3W4y.graphics.ImageBuilder;
import com.SiD3W4y.objects.Buildings;

import org.json.*;


public class Village {
	
	private String VillageJson;
	
	// Graphics part
	private ImageBuilder grphx;
	
	// Some empty stuff (not implemented yet)
	
	private JSONArray cooldowns;
	private JSONArray obstacles;
	private JSONArray newShopBuildings;
	private JSONArray newShopTraps;
	private JSONArray newShopDecos;
	
	// Data containers
	
	private BuildingsList buildingLST;
	private DecosList decosLST;
	private TrapsList trapsLST;
	private respawnVars RespawnVars;
	
	// End of village files vars
	
	private int last_league_rank;
	private int last_league_shuffle;
	private int last_news_seen;
	private boolean edit_mode_shown;
	
	// Booleans used for compatibility with ucs (fields missing)
	private boolean has_shopBuildings;
	private boolean has_shopTraps;
	private boolean has_shopDecos;
	private boolean has_respawnVars;
	
	
	
	
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
		trapsLST = new TrapsList(js.getJSONArray("traps"));
		
		// Creating decos array (empty for now)
		decosLST = new DecosList(js.getJSONArray("decos"));
		
		// Creating newShopBuildings array
		if(js.has("newShopBuildings")){
		has_shopBuildings = true;
		newShopBuildings = js.getJSONArray("newShopBuildings");
		}
		// Creating newShopTraps array
		if(js.has("newShopTraps")){
		has_shopTraps = true;
		newShopTraps = js.getJSONArray("newShopTraps");
		}
		
		// Creating newShopDecos array
		if(js.has("newShopDecos")){
		has_shopDecos = true;
		newShopDecos = js.getJSONArray("newShopDecos");
		}
		// Filling respawnVars with respawn variables (that's pretty straightforward lol)
		if(js.has("respawnVars")){
		has_respawnVars = true;
		RespawnVars = new respawnVars(js.getJSONObject("respawnVars"));
		
		// Getting last vars
		last_league_rank = js.getInt("last_league_rank");
		last_league_shuffle = js.getInt("last_league_shuffle");
		last_news_seen = js.getInt("last_news_seen");
		edit_mode_shown = js.getBoolean("edit_mode_shown");
		}
		}catch(JSONException e){
			e.printStackTrace();
		}
		
		
		
	}
	
	public void setLastLeague(int id){
		// You can use Constants defined in com.SiD3W4y.objects.Leagues (ex : setLastLeague(Leagues.BRONZE_III)
		last_league_rank = id;
	}
	
	public boolean hasRespawnVars(){
		return has_respawnVars;
	}
	
	public void setEditMode(boolean bool){
		edit_mode_shown = bool;
	}
	
	public JSONObject getVillageFile(){
		JSONObject job = new JSONObject();
		try {
			job.put("buildings",buildingLST.getJsonForm());
			job.put("obstacles", obstacles);
			job.put("traps",trapsLST.getJsonForm());
			job.put("decos",decosLST.getJsonForm());
			job.put("cooldowns",cooldowns);
			
			if(has_respawnVars){
			job.put("last_league_rank",last_league_rank);
			job.put("last_league_shuffle",last_league_shuffle);
			job.put("last_news_seen",last_news_seen);
			job.put("edit_mode_shown",edit_mode_shown);
			}
			
			if(has_shopBuildings){
			job.put("newShopBuildings",newShopBuildings);
			}
			if(has_shopTraps){
			job.put("newShopTraps",newShopTraps);
			}
			if(has_shopDecos){
			job.put("newShopDecos",newShopDecos);
			}
			
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
	
	public TrapsList traps(){
		return trapsLST;
	}
	
	public DecosList decos(){
		return decosLST;
	}
	

}
