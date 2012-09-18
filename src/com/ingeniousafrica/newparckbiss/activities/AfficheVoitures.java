package com.ingeniousafrica.newparckbiss.activities;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;

import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.ListView;

import com.ingeniousafrica.newparckbiss.metier.Client;
import com.ingeniousafrica.newparckbiss.metier.DataFabrication;
import com.ingeniousafrica.newparckbiss.metier.Voiture;
import com.ingeniousafrica.newparckbiss.utilitaire.DataManager;
import com.ingeniousafrica.newparckbiss.utilitaire.VoitureAdapter;
import com.ingeniousafrica.newparckbiss.R;

/**
 * C'est une activité permet l'affichage de toutes les voitures des clients
 * Date de création : 30-08-2012
 * Date de modification : 03-09-2012
 * @author w.begbessou
 * @version 1.0
 */
public class AfficheVoitures extends Activity implements OnClickListener{

	private ListView mListV;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_voiture);
		

		findViewById(R.id.activity_afficheclientvoiture_button_back).setOnClickListener(this);
		
		mListV = (ListView)findViewById(R.id.list_voiture_id);

		afficherVoitures();
	}

	public void onClick(View v) {
		switch(v.getId()){

    	case R.id.activity_afficheclientvoiture_button_back:
    		
    		finish();

    	}
	}
	

	/**
	 * Cette methode sera appeller à chaque fois que la listview doit etre raffraichit
	 */
	@SuppressWarnings("unchecked")
	public void afficherVoitures(){
		DataFabrication.getInstence().setmParckVoitureClient((HashMap<Client, ArrayList<Voiture>>)DataManager.readData(this, "dataParck"));
		DataFabrication.getInstence().listerVoitures();
		ArrayList<Voiture> lVoitures =  DataFabrication.getInstence().getmVoitures();
		
		
		if(lVoitures != null){

			VoitureAdapter adapter = new VoitureAdapter(this,R.layout.item_nouveau_voiture, lVoitures );

			mListV.setAdapter(adapter);
		}

	}

}
