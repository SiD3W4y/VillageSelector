package com.SiD3W4y.utils;

import java.util.ArrayList;
import java.io.*;

public class ObjectConverter {
	private ArrayList<Integer> id_list;
	private ArrayList<String> names;
	private InputStream in;
	
	public ObjectConverter(String respath){
		id_list = new ArrayList<Integer>();
		names = new ArrayList<String>();
		in = getClass().getResourceAsStream(respath);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			while((line = br.readLine()) != null){
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
	
	public void dbgPrint(){
		for(int i=0; i< id_list.size();i++){
			System.out.println("ID : "+id_list.get(i)+" Name : "+names.get(i));
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

}
