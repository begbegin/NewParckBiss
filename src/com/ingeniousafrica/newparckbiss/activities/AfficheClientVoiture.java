package com.ingeniousafrica.newparckbiss.activities;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;

import android.content.DialogInterface;

import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.ListView;

import android.widget.Toast;

import com.ingeniousafrica.newparckbiss.metier.DataFabrication;
import com.ingeniousafrica.newparckbiss.metier.Voiture;
import com.ingeniousafrica.newparckbiss.utilitaire.VoitureAdapter;
import com.ingeniousafrica.newparckbiss.R;

/**
 * C'est une activité permet l'affichage des voitures d'un client donnée
 * Date de création : 30-08-2012
 * Date de modification : 04-09-2012
 * @author w.begbessou
 * @version 1.0
 */
public class AfficheClientVoiture extends Activity implements OnClickListener, OnItemClickListener{

	private ListView mListV;
	
	private Voiture mItemVoiture;
	
	private static final int SUPPRIMER_VOITURE = 1;
	
	private VoitureAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_voiture);
		

		findViewById(R.id.activity_afficheclientvoiture_button_back).setOnClickListener(this);
		
		mListV = (ListView)findViewById(R.id.list_voiture_id);

		mListV.setOnItemClickListener(this);
		
		afficherVoitures();
	}

	public void onClick(View v) {
		switch(v.getId()){

    	case R.id.activity_afficheclientvoiture_button_back:
    		
    		finish();

    	}
	}
	
	
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		mItemVoiture = (Voiture) mListV.getItemAtPosition(arg2);
		
		showDialog(SUPPRIMER_VOITURE);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch(id){
		case SUPPRIMER_VOITURE:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle(R.string.titre_boite_dialogue);
			builder.setMessage(R.string.boite_dialogue_suppr_msg);
			builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface arg0, int arg1) {
					DataFabrication.getInstence().getmVoitures().remove(mItemVoiture);
					
					//j'affiche un message pour rassurrer l'utilisateur
					Toast.makeText(AfficheClientVoiture.this,R.string.boite_dialogue_car_msg+mItemVoiture.getmMarque()+" "+mItemVoiture.getmModel()+R.string.boite_dialogue_car_suppr, 5000).show();
					
					//je reaffiche les infos dans la listview
					mListV.setAdapter(adapter);	
				}
			});
			
			builder.setNegativeButton(R.string.no, null);
			return builder.create();
		}
		return super.onCreateDialog(id);
	}
	/**
	 * Cette methode sera appeller à chaque fois que la listview doit etre raffraichit
	 */
	public void afficherVoitures(){
		ArrayList<Voiture> lVoitures =  DataFabrication.getInstence().getmVoitures();
		if(lVoitures != null){

			VoitureAdapter adapter = new VoitureAdapter(this,R.layout.item_nouveau_voiture, lVoitures );

			mListV.setAdapter(adapter);
		}

	}

}
