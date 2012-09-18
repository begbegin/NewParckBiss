/**
 * 
 */
package com.ingeniousafrica.newparckbiss.metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.ingeniousafrica.newparckbiss.utilitaire.DataManager;

import android.app.Application;



/**
 * Elle permet regroupe les informations de fabrication de voitue
 * Date de création : 28-08-2012
 * Date de modification : 31-08-2012
 * @author w.begbessou
 * @version 1.0
 * @see Client
 * @see Voiture
 *
 */
public class DataFabrication extends Application{
	
	private Client mClient = null;
	private ArrayList<Client> mClients =  new ArrayList<Client>();
	private ArrayList<Voiture> mVoitures = new ArrayList<Voiture>();
	//private DataParck mDataParck;
	private HashMap<Client, ArrayList<Voiture>> mParckVoitureClient;
	
	private static DataFabrication mSingletonObj;
	
	/**
	 * Cette methode permet le retour d'un seul obj de notre classe
	 * @author w.begbessou
	 * @return DataFabrication
	 */
	public static DataFabrication getInstence(){
		return mSingletonObj;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void onCreate() {
	
		super.onCreate();
		mSingletonObj = this;
		//je déserialise puis recupère les données sur le lient et les vehicules
		mParckVoitureClient = (HashMap<Client, ArrayList<Voiture>>) DataManager.readData(this, "dataParck");
		
		if(mParckVoitureClient == null){
			mParckVoitureClient = new HashMap<Client, ArrayList<Voiture>>();
		}
	
	}
	/**
	 * Elle permet d'obtenir la liste des clients
	 */
	public void listerClient(){
		mClients.clear();
		for (Entry<Client, ArrayList<Voiture>> currentEntry : mParckVoitureClient.entrySet()) {
			mClients.add(currentEntry.getKey());
		}
	}
	
	/**
	 * Elle permet d'obtenir la liste des voitures.
	 */
	public void listerVoitures(){
		mVoitures.clear();
		
		for (Entry<Client, ArrayList<Voiture>> currentEntry : mParckVoitureClient.entrySet()) {
			mVoitures.addAll(currentEntry.getValue());
		}
	}
	

	public ArrayList<Client> getmClients() {
		return mClients;
	}



	public void setmClients(ArrayList<Client> mClients) {
		this.mClients = mClients;
	}



	public Client getmClient() {
		return mClient;
	}
	public void setmClient(Client mClient) {
		this.mClient = mClient;
	}
	
	public ArrayList<Voiture> getmVoitures() {
		return mVoitures;
	}


	public void setmVoitures(ArrayList<Voiture> mVoitures) {
		this.mVoitures = mVoitures;
	}
	public HashMap<Client, ArrayList<Voiture>> getmParckVoitureClient() {
		return mParckVoitureClient;
	}

	public void setmParckVoitureClient(
			HashMap<Client, ArrayList<Voiture>> mParckVoitureClient) {
		this.mParckVoitureClient = mParckVoitureClient;
	}

	
		
}
