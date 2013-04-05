package edu.uchicago.cs.btprefs;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.uchicago.cs.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	//1: declare a reference to the SharedPreferences class
	SharedPreferences shp;
	
	//declare some refs to the UI objects
	TextView txtPref;
	Button btnGet;
	
	//PrefsMgr pmgManager;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//2: get the object from the factory
		shp = PreferenceManager.getDefaultSharedPreferences(this);
		
		//get inflated views
		txtPref = (TextView) findViewById(R.id.txtPref);
		btnGet = (Button) findViewById(R.id.btnGet);
		
		btnGet.setOnClickListener(this);
		
		// pmgManager = new PrefsMgr(shp);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onClick(View v) {
		
		
		Editor edtEditor = shp.edit();
		
		//clearing all prefs
		//edtEditor.clear();
		
		//setting an individual preference
		edtEditor.putInt("MY_INT", 20);
		edtEditor.putString("MY_STRING", "hello");
		edtEditor.putBoolean("MY_BOOL", true);
		//etc.
		
		//setting a set of preferences
		Set<String> strVals = new HashSet<String>();
		strVals.add("baseball");
		strVals.add("football");
		strVals.add("basketball");
		strVals.add("soccer");
		edtEditor.putStringSet("MY_SET", strVals);
		
		//you must call commit to commit the transaction
		edtEditor.commit();
		
		
		//getting a preference
		int nMyInt = shp.getInt("MY_INT", -99);
		String strMyStr = shp.getString("MY_STRING", "absent");
		boolean bMyBool = shp.getBoolean("MY_BOOL", false);
		

		//getting all the preferences
		StringBuilder stb = new StringBuilder();
		Map<String, ?> map = shp.getAll();
		for(Map.Entry<String,?> entry : map.entrySet()){
			 String strKey = entry.getKey();
			 Object  objValue = entry.getValue();
			 stb.append(strKey + " : ");
			 stb.append(objValue.toString() + "\n");
		}
		txtPref.setText(stb.toString());

		//txtPref.setText(pmgManager.getAllPrefsAsString());
		
		
		
	}
	



	

}
