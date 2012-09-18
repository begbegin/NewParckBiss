package com.ingeniousafrica.newparckbiss.metier;

import java.io.Serializable;

/**
 * Cette classe décrit un objet client
 * 
 * Date de création : 28-08-2012
 * Date de modification : 28-08-2012
 * @author w.begbessou
 * @version 1.0
 */
public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mNom;
	
	private String mPrenom;

	
	public Client() {
		super();
	}


	public Client(String mNom, String mPrenom) {
		super();
		this.mNom = mNom;
		this.mPrenom = mPrenom;
	}


	public String getmNom() {
		return mNom;
	}


	public void setmNom(String mNom) {
		this.mNom = mNom;
	}


	public String getmPrenom() {
		return mPrenom;
	}


	public void setmPrenom(String mPrenom) {
		this.mPrenom = mPrenom;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mNom == null) ? 0 : mNom.hashCode());
		result = prime * result + ((mPrenom == null) ? 0 : mPrenom.hashCode());
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
		Client other = (Client) obj;
		if (mNom == null) {
			if (other.mNom != null)
				return false;
		} else if (!mNom.equals(other.mNom))
			return false;
		if (mPrenom == null) {
			if (other.mPrenom != null)
				return false;
		} else if (!mPrenom.equals(other.mPrenom))
			return false;
		return true;
	}

	

}
