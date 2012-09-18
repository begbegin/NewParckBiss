package com.ingeniousafrica.newparckbiss.utilitaire;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.content.Context;

/**
 * Cette clase permettra la sauvegarde des données du parck de voiture
 * Date de création : 28-08-2012
 * Date de modification : 28-08-2012
 * @author w.begbessou
 * @version 1.0
 */
public class DataManager{
	
	public static void saveData(Context context, String key, final Object data, boolean temp){
		synchronized (data) {
			if(data==null)return;
			final File file;
			if(temp){
				file = getCacheFile(context,key);
			}else{
				file = getDataFile(context,key);
			}
			save(file, data);
		}
	}
	
	private static File getCacheFile(Context context, String key){
		try {
			return new File(context.getCacheDir().getAbsolutePath()+"/"+key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static File getDataFile(Context context, String key){
		try {
			return new File(context.getFilesDir().getAbsolutePath()+"/"+key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static void save(File file, final Object data)
	{
		try {
			FileOutputStream	fos = new FileOutputStream(file);
			ObjectOutputStream	oos = new ObjectOutputStream(fos);			
			oos.writeObject(data);			
			oos.close();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object readData(Context context, String key){
		File file = getCacheFile(context,key);
		// Si le fichier n'éxiste pas dans le dossier du cache
		// On regarde s'il existe dans le dossier data
		if(!file.exists()){
			file = getDataFile(context,key);
			// S'il n'éxiste pas non plus dans le dossier data alors on retourne null
			if(!file.exists()) return null;
		}
		try {
			FileInputStream		fis = new FileInputStream(file);
			ObjectInputStream	ois = new ObjectInputStream(fis);
			Object o = ois.readObject();		
			ois.close();
			fis.close();
			return o;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}
