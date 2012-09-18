package com.ingeniousafrica.newparckbiss.activities;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.ListView;

import android.widget.TextView;
import android.widget.Toast;

import com.ingeniousafrica.newparckbiss.metier.DataFabrication;
import com.ingeniousafrica.newparckbiss.metier.Voiture;
import com.ingeniousafrica.newparckbiss.utilitaire.VoitureAdapter;
import com.ingeniousafrica.newparckbiss.R;

/**
 * C'est une activité permet de gere la fabrication de voitures
 * Date de création : 28-08-2012
 * Date de modification : 04-09-2012
 * @author w.begbessou
 * @version 1.0
 */
public class Fabrication extends Activity implements OnClickListener, OnItemClickListener{

	private ListView mListV;
	
	private Voiture mItemVoiture;
	
	private static final int SUPPRIMER_VOITURE = 1;
	
	private static final int ACTIVITY_FABRIQUE_VOITURE = 1;
	
	private VoitureAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fabrication);
		

		findViewById(R.id.activity_fabrication_button_fabriquer).setOnClickListener(this);
		findViewById(R.id.activity_fabrication_button_back).setOnClickListener(this);
		findViewById(R.id.activity_fabrication_ajout_parck_button).setOnClickListener(this);
		mListV = (ListView)findViewById(R.id.activity_fabrication_list_voiture);

		mListV.setOnItemClickListener(this);
		
		//j'affiche le nom et prenom du client
		((TextView)findViewById(R.id.activity_fabrication_client_name_value)).setText(DataFabrication.getInstence().getmClient().getmNom());
		((TextView)findViewById(R.id.activity_fabrication_client_prenom_value)).setText(DataFabrication.getInstence().getmClient().getmPrenom());

		afficherVoitures();
	}

	public void onClick(View v) {
		switch(v.getId()){

    	case R.id.activity_fabrication_button_fabriquer:
    	
    		Intent intent = new Intent(this, FabriqueVoiture.class );
    		
    		startActivityForResult(intent, ACTIVITY_FABRIQUE_VOITURE);
    		
    		break;
    	case R.id.activity_fabrication_ajout_parck_button:
    		ArrayList<Voiture> lVoitures =  DataFabrication.getInstence().getmVoitures();
        	if(!lVoitures.isEmpty()){
        		Intent intent2 = new Intent(this, Parck.class );
        		
        		startActivity(intent2);
        		
        		finish();
        	}else{
        		Toast.makeText(this, R.string.activity_fabrication_obligation_msg, 5000).show();
        	}
    		
    		break;

    	case R.id.activity_fabrication_button_back:
    		
    		finish();

    	}
	}
	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch(requestCode){
		case ACTIVITY_FABRIQUE_VOITURE:
			afficherVoitures();
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
			builder.setMessage(R.string.boite_dialogue_suppr_msg+"\n\n");
			builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
				
				public void onClick(DialogInterface arg0, int arg1) {
					DataFabrication.getInstence().getmVoitures().remove(mItemVoiture);
					
					//j'affiche un message pour rassurrer l'utilisateur
					Toast.makeText(Fabrication.this,R.string.boite_dialogue_car_msg + mItemVoiture.getmMarque()+" "+mItemVoiture.getmModel()+R.string.boite_dialogue_car_suppr, 5000).show();
					
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
