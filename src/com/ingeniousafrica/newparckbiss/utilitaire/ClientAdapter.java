package com.ingeniousafrica.newparckbiss.utilitaire;


import java.util.List;

import com.ingeniousafrica.newparckbiss.metier.Client;
import com.ingeniousafrica.newparckbiss.R;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
/**
 * Permet d'adapter l'affichage d'un objet client dans une listview
 * Date de création : 30-08-2012
 * Date de modification : 30-08-2012
 * @author w.begbessou
 * @version 1.0
 */
public class ClientAdapter extends ArrayAdapter<Client>{
	
	private int mRessources;
	private LayoutInflater inflateur;

	public ClientAdapter(Context context, int textViewResourceId,
			List<Client> objects) {
		super(context, textViewResourceId, objects);
		inflateur = LayoutInflater.from(context);
		mRessources = textViewResourceId;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView == null){
			convertView = inflateur.inflate(mRessources, null);
			
			
		}
		
		Client client = getItem(position);
		
		TextView lName= (TextView)convertView.findViewById(R.id.item_client_name_text);
		TextView lPrenom = (TextView)convertView.findViewById(R.id.item_client_prenom_text);
		
		lName.setText(client.getmNom());
		lPrenom.setText(client.getmPrenom());
		
		return convertView;
	}
	
	

}
