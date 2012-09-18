package com.ingeniousafrica.newparckbiss.utilitaire;

import java.util.List;


import com.ingeniousafrica.newparckbiss.metier.Voiture;

import com.ingeniousafrica.newparckbiss.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
/**
 * Permet d'adapter l'affichage d'un objet voiture
 * Date de création : 28-08-2012
 * Date de modification : 30-08-2012
 * @author w.begbessou
 * @version 1.0
 */
public class VoitureAdapter extends ArrayAdapter<Voiture>{
	
	private int mRessources;
	private LayoutInflater mInflateur;

	public VoitureAdapter(Context context, int textViewResourceId,
			List<Voiture> objects) {
		super(context, textViewResourceId, objects);
		mInflateur = LayoutInflater.from(context);
		mRessources = textViewResourceId;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView == null){
			convertView = mInflateur.inflate(mRessources, null);
			
			
		}
		
		Voiture vehicule = getItem(position);
		
		TextView lMarque = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_marque_text);
		TextView lModel = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_model_text);
		TextView lCarrosserie = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_carrosserie_text);
		TextView lMoteur = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_moteur_text);
		TextView lAnnee = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_annee_text);
		TextView lDescription = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_description_text);
		
		lMarque.setText(vehicule.getmMarque());
		lModel.setText(vehicule.getmModel());
		lCarrosserie.setText(vehicule.getmCarrosserie());
		lMoteur.setText(vehicule.getmMoteur());
		lAnnee.setText(vehicule.getmAnnee());
		lDescription.setText(vehicule.getmDescription());

		return convertView;
	}
	
	

}
