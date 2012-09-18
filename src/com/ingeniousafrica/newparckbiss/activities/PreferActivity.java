package com.ingeniousafrica.newparckbiss.activities;


import java.util.Locale;

import com.ingeniousafrica.newparckbiss.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

/**
 * C'est une activité permet le gestion des paramettres de l'appliction
 * Date de création : 01-09-2012
 * Date de modification : 04-09-2012
 * @author w.begbessou
 * @version 1.0
 */
public class PreferActivity extends PreferenceActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        addPreferencesFromResource(R.xml.users_setting);
    }

	@Override
	protected void onDestroy() {
		SharedPreferences lPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		
		String lLang =lPrefs.getString("lang", getString(R.string.french_string)).toString();
		if(lLang.equals(getString(R.string.french_string))){
			changeLocale(Locale.FRANCE);
		}else{
			changeLocale(Locale.ENGLISH);
		}
		//Toast.makeText(this, lPrefs.getString("lang", "Français").toString(), 10000).show();
		
		super.onDestroy();
	}
	
    /**
     * Cette methode se charge de changer le local puis le redemmarrage de l'application
     * @author w.begbessou
     * @param local
     */
	private void changeLocale(Locale local){
		Resources lRes = getResources();
		
		Configuration lConfig = lRes.getConfiguration();
		
		lConfig.locale = local;
		
		lRes.updateConfiguration(lConfig, lRes.getDisplayMetrics());
		
		Intent intent = new Intent(this, Main.class );

		startActivity(intent);
		
	} 
    
    
}