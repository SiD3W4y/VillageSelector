package com.SiD3W4y.tests;

import com.SiD3W4y.objects.Buildings;
import com.SiD3W4y.objects.Leagues;
import com.SiD3W4y.objects.Ressource;
import com.SiD3W4y.utils.ObjectConverter;
import com.SiD3W4y.utils.Village;
import com.SiD3W4y.utils.GameObject;

import java.io.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		// First load the json , here from a file
		try {
			ObjectConverter bc = new ObjectConverter(Ressource.BUILDINGS);
			BufferedReader br = new BufferedReader(new FileReader(new File("village.txt")));
			String text = "";
			String line = "";

			while ((line = br.readLine()) != null) {
				text += line;
			}
			br.close();

			// Create the village object
			Village village = new Village(text);

			// Let's say that you want to change your townhall to level 10
			// buildings method from village returns the BuildingList object ,
			// which contains basically all buildings data
			// setComponentLevel takes two arguments : the id of the building
			// and the level
			// You can use constants that are defined in Buildings class like
			// here
			village.buildings().setComponentLevel(Buildings.TOWNHALL, 10);
			
			// But what if you want to have a little bit more control on the building ?
			// You can get a list of a specific building type to get fine grain control of the operations !
			// Here we will get our walls and change the level of the first one in the list !
			ArrayList<GameObject> objlist = village.buildings().getGameObjects(Buildings.WALL);
			objlist.get(0).setLevel(11);
			
			// Now we want to change the wall level at coords 15,32 for example
			// The first arg is the x pos of the object
			// The second one is the y pos
			// And the last one is the level
			village.buildings().setLevel(15, 32, 11);
			

			// There is an event on your dedserver :D , and you want to offer a
			// gem box to all of your players the next hour
			// So let's change the respawn vars !
			
			// Here we use hasRespawnVars() to check if the current json has this fields (ucs don't have these fields for example)
			if(village.hasRespawnVars()){
			village.respawn_vars().setNextGemboxDrop(3600);
			
			// To change the last_league_rank , it's simple
			// You can even use constants that are defined in Leagues class !
			village.setLastLeague(Leagues.MASTER_II);
			}

			// And now we get our moded json file back using getVillageFile()
			// It return's a JSONObject
			System.out.println(village.getVillageFile().toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
