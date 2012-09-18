package com.ingeniousafrica.newparckbiss.metier;

import java.io.Serializable;
/**
 * Cette classe décrit une voiture
 * Date de création : 28-08-2012
 * Date de modification : 28-08-2012
 * @author w.begbessou
 * @version 1.0
 */
public class Voiture implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mImg;
	private String mMarque;
	private String mModel;
	private String mCarrosserie;
	private String mAnnee;
	private String mMoteur;
	private String mDescription;
	
	
	
	public Voiture() {
		super();
	}
	
	


	public Voiture(int mImg, String mMarque, String mModel,
			String mCarrosserie, String mAnnee, String mMoteur,
			String mDescription) {
		super();
		this.mImg = mImg;
		this.mMarque = mMarque;
		this.mModel = mModel;
		this.mCarrosserie = mCarrosserie;
		this.mAnnee = mAnnee;
		this.mMoteur = mMoteur;
		this.mDescription = mDescription;
	}

	


	public Voiture(String mMarque, String mModel, String mCarrosserie,
			String mAnnee, String mMoteur, String mDescription) {
		super();
		this.mMarque = mMarque;
		this.mModel = mModel;
		this.mCarrosserie = mCarrosserie;
		this.mAnnee = mAnnee;
		this.mMoteur = mMoteur;
		this.mDescription = mDescription;
	}




	public int getmImg() {
		return mImg;
	}



	public void setmImg(int mImg) {
		this.mImg = mImg;
	}



	public String getmMarque() {
		return mMarque;
	}



	public void setmMarque(String mMarque) {
		this.mMarque = mMarque;
	}



	public String getmModel() {
		return mModel;
	}



	public void setmModel(String mModel) {
		this.mModel = mModel;
	}



	public String getmCarrosserie() {
		return mCarrosserie;
	}



	public void setmCarrosserie(String mCarrosserie) {
		this.mCarrosserie = mCarrosserie;
	}



	public String getmAnnee() {
		return mAnnee;
	}



	public void setmAnnee(String mAnnee) {
		this.mAnnee = mAnnee;
	}



	public String getmMoteur() {
		return mMoteur;
	}



	public void setmMoteur(String mMoteur) {
		this.mMoteur = mMoteur;
	}



	public String getmDescription() {
		return mDescription;
	}



	public void setmDescription(String mDescription) {
		this.mDescription = mDescription;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mAnnee == null) ? 0 : mAnnee.hashCode());
		result = prime * result
				+ ((mCarrosserie == null) ? 0 : mCarrosserie.hashCode());
		result = prime * result
				+ ((mDescription == null) ? 0 : mDescription.hashCode());
		result = prime * result + mImg;
		result = prime * result + ((mMarque == null) ? 0 : mMarque.hashCode());
		result = prime * result + ((mModel == null) ? 0 : mModel.hashCode());
		result = prime * result + ((mMoteur == null) ? 0 : mMoteur.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voiture other = (Voiture) obj;
		if (mAnnee == null) {
			if (other.mAnnee != null)
				return false;
		} else if (!mAnnee.equals(other.mAnnee))
			return false;
		if (mCarrosserie == null) {
			if (other.mCarrosserie != null)
				return false;
		} else if (!mCarrosserie.equals(other.mCarrosserie))
			return false;
		if (mDescription == null) {
			if (other.mDescription != null)
				return false;
		} else if (!mDescription.equals(other.mDescription))
			return false;
		if (mImg != other.mImg)
			return false;
		if (mMarque == null) {
			if (other.mMarque != null)
				return false;
		} else if (!mMarque.equals(other.mMarque))
			return false;
		if (mModel == null) {
			if (other.mModel != null)
				return false;
		} else if (!mModel.equals(other.mModel))
			return false;
		if (mMoteur == null) {
			if (other.mMoteur != null)
				return false;
		} else if (!mMoteur.equals(other.mMoteur))
			return false;
		return true;
	}
	
		
	
}
