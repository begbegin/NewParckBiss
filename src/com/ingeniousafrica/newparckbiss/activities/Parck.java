package com.ingeniousafrica.newparckbiss.activities;

import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.ingeniousafrica.newparckbiss.metier.Client;
import com.ingeniousafrica.newparckbiss.metier.DataFabrication;
import com.ingeniousafrica.newparckbiss.utilitaire.ClientAdapter;
import com.ingeniousafrica.newparckbiss.utilitaire.DataManager;
import com.ingeniousafrica.newparckbiss.utilitaire.VoitureAdapter;
import com.ingeniousafrica.newparckbiss.R;


/**
 * C'est une activité permet de gere la fabrication de voitures
 * Date de création : 29-08-2012
 * Date de modification : 04-09-2012
 * @author w.begbessou
 * @version 1.0
 */
public class Parck extends Activity implements OnClickListener, OnItemClickListener{

	private ListView mListView;
	
	private DataFabrication mAppData;
	
	private ArrayList<Client> mClients;
	
	private Client mItemClient;
	
	private LayoutInflater mInflateur;
	
	private static final int AFFICHER_LIST_VOITURE_CLIENT = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parck);
		
		findViewById(R.id.activity_parck_toutes_voitures_button).setOnClickListener(this);
		mInflateur = LayoutInflater.from(this);
		mAppData = DataFabrication.getInstence();
		
		//mAppData.getmParckVoitureClient().clear();
		if(mAppData.getmClient()!= null){
			mAppData.getmParckVoitureClient().put(mAppData.getmClient(), mAppData.getmVoitures());
		}
		
		
		mAppData.listerClient();
		mClients = mAppData.getmClients();
		
		mListView = (ListView) findViewById(R.id.activity_parck_listview_listclient);
		
		mListView.setOnItemClickListener(this);
		
		afficherClients();
		
		DataManager.saveData(this, "dataParck", mAppData.getmParckVoitureClient(), false);
	}

	@Override
	protected void onDestroy() {
		
		mAppData.getmClients().clear();
		mAppData.getmVoitures().clear();
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	public void onClick(View v) {
		switch(v.getId()){
		case R.id.activity_parck_toutes_voitures_button:
			
			
			Intent intent = new Intent(this, AfficheVoitures.class );
			
			startActivity(intent);
			break;
			
    	}
	}
	
	
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		mItemClient = mAppData.getmClients().get(arg2);
		
		mAppData.setmVoitures(mAppData.getmParckVoitureClient().get(mItemClient));
		//showDialog(AFFICHER_LIST_VOITURE_CLIENT);
		
		Intent intent2 = new Intent(this, AfficheClientVoiture.class );
		
		startActivity(intent2);
		
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch(id){
		case AFFICHER_LIST_VOITURE_CLIENT:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);

			View view = mInflateur.inflate(R.layout.list_voiture, null);

			VoitureAdapter adapter = new VoitureAdapter(this,R.layout.item_nouveau_voiture, mAppData.getmParckVoitureClient().get(mItemClient));
			
			ListView lListV = (ListView)view.findViewById(R.id.list_voiture_id);

			lListV.setAdapter(adapter);
			
			Toast.makeText(this, mItemClient.getmNom(), 5000).show();
			
			builder.setView(view);

			builder.setTitle(R.string.list_voiture_titre_boite_dialogue);

			builder.setNegativeButton(android.R.string.cancel,null);
			return builder.create();

		}
		return super.onCreateDialog(id);
	}
	

	/**
	 * Cette methode sera appeller à chaque fois que la listview doit etre raffraichit
	 */
	public void afficherClients(){
		
		if(mClients != null){
			ClientAdapter adapter = new ClientAdapter(this,R.layout.item_client,mClients);
			mListView.setAdapter(adapter);
		}
		
	}

}
