package com.SiD3W4y.utils;

import java.util.ArrayList;
import java.io.*;

import com.SiD3W4y.objects.Ressource;

public class ObjectConverter {
	private ArrayList<Integer> id_list;
	private ArrayList<String> names;
	private ArrayList<Integer> size;
	private InputStream in;
	
	public ObjectConverter(String respath){
		id_list = new ArrayList<Integer>();
		names = new ArrayList<String>();
		size = new ArrayList<Integer>();
		in = getClass().getResourceAsStream(respath);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			while((line = br.readLine()) != null){
				if(respath.equals(Ressource.BUILDINGS)){
				size.add(Integer.parseInt(line.split(",")[2]));
				}
				id_list.add(Integer.parseInt(line.split(",")[1]));
				names.add(line.split(",")[0]);
			}
		br.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
	
	
	public String getName(int id){
		for(int i=0;i < id_list.size();i++){
			if(id_list.get(i) == (id)){
				return names.get(i);
			}
		}
		
		return "ERR : No such ID";
	}
	
	public int getID(String name){
		for(int i=0;i < names.size();i++){
			if(names.get(i).equals(name)){
				return id_list.get(i);
			}
		}
		return -1;
	}
	
	public int getSize(int id){
		for(int i=0;i < id_list.size();i++){
			if(id_list.get(i) == id){
				return size.get(i);
			}
		}
		return -1;
	}

}
