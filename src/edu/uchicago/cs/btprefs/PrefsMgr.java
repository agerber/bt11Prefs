package edu.uchicago.cs.btprefs;

import java.util.Map;
import java.util.Set;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PrefsMgr {
	SharedPreferences shp;

	public PrefsMgr(SharedPreferences shp) {
		this.shp = shp;
	}

	//################################################
	//get/set ints
	//################################################
	public void setInt(String strKey, int nValue) {

		Editor editor = shp.edit();
		editor.putInt(strKey, nValue);
		editor.commit();
	}

	public int getInt(String strKey, int nDefault) {

		return shp.getInt(strKey, nDefault);
		
	}
	
	//################################################
	//get/set string
	//################################################
	public void setString(String strKey, String strValue) {

		Editor editor = shp.edit();
		editor.putString(strKey, strValue);
		editor.commit();
	}

	public String getString(String strKey, String strDefault) {

		return shp.getString(strKey, strDefault);
		
	}
	
	//################################################
	//get/set set of string
	//################################################
	public void setStrings(String strKey, Set<String> strValues) {

		Editor editor = shp.edit();
		editor.putStringSet(strKey, strValues);
		editor.commit();
	}

	public Set<String> getStrings(String strKey, Set<String> strDefaults) {

		return shp.getStringSet(strKey, strDefaults);
		
	}
	
	
	public String getAllPrefsAsString(){
		
		StringBuilder stb = new StringBuilder();
		Map<String, ?> map = shp.getAll();
		for(Map.Entry<String,?> entry : map.entrySet()){
			 String strKey = entry.getKey();
			 Object  objValue = entry.getValue();
			 stb.append(strKey + " : ");
			 stb.append(objValue.toString() + "\n");
		}
		return stb.toString();
	}
	
	//################################################
	// etc. 
	//################################################
	
	
	
}
