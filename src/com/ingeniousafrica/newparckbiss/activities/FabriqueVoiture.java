package com.ingeniousafrica.newparckbiss.activities;
import java.util.ArrayList;
import java.util.Date;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;



import com.ingeniousafrica.newparckbiss.metier.DataFabrication;
import com.ingeniousafrica.newparckbiss.metier.Voiture;
import com.ingeniousafrica.newparckbiss.R;


/**
 * C'est une activité permettant la fabrication de voitures
 * Date de création : 29-08-2012
 * Date de modification : 04-09-2012
 * @author w.begbessou
 * @version 1.0
 */
public class FabriqueVoiture extends Activity implements OnClickListener {

	private Spinner mSpMark;
	private Spinner mSpMoteur;
	private Spinner mSpCarro;
	private EditText mModel;
	
	private EditText mDescription;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fabrique);
		
		findViewById(R.id.activity_fabrique_button_valider).setOnClickListener(this);
		findViewById(R.id.activity_fabrique_button_annuler).setOnClickListener(this);
		
		mSpMark = (Spinner)findViewById(R.id.activity_fabrication_marque_spin);
		
		mSpMoteur = (Spinner)findViewById(R.id.activity_fabrication_moteur_spin);
		
		mSpCarro = (Spinner)findViewById(R.id.activity_fabrique_carrosserie_spin);
		
		mModel =  (EditText)findViewById(R.id.activity_fabrique_model_edit);
		
		mDescription = (EditText)findViewById(R.id.activity_fabrique_description_voiture_edit);
	}

	public void onClick(View v) {
		switch(v.getId()){

		case R.id.activity_fabrique_button_valider:
			String lModel = mModel.getText().toString();
			String lDescription = mDescription.getText().toString();
			
			if(!lModel.equals("") && !lDescription.equals("")){
				Voiture lV = new Voiture();

				lV.setmMarque(mSpMark.getSelectedItem().toString());
				lV.setmCarrosserie(mSpCarro.getSelectedItem().toString());
				lV.setmMoteur(mSpMoteur.getSelectedItem().toString());
				lV.setmModel(lModel);
				lV.setmDescription(lDescription);
				lV.setmAnnee((new Date()).toGMTString());

				//je recupère ma liste de voiture pour le client en cour
				ArrayList<Voiture> lListV = DataFabrication.getInstence().getmVoitures();
				lListV.add(lV);
				//je r
				DataFabrication.getInstence().setmVoitures(lListV);

				Intent intent = new Intent(this, Fabrication.class );

				setResult(RESULT_OK, intent);

				// je termine l'activité
				finish();
			}else{
				Toast.makeText(this, R.string.activity_champ_null_msg, 5000).show();
			}
			break;

		case R.id.activity_fabrique_button_annuler:

			finish();

		}
	}

	
	

}
