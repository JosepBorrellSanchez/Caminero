package com.iesebre.DAM2.examenBorrell;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Adaptadors extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segon_layout);
        
        
        ArrayList<CosesLlista> versiones =
           new ArrayList<CosesLlista>();
        
        versiones.add(
              new CosesLlista("Fill", "", R.drawable.gohan));
        
        versiones.add(
              new CosesLlista("El prota", "", R.drawable.goku));
        
        versiones.add(
              new CosesLlista("tia", "", R.drawable.bulma));
        
        versiones.add(
              new CosesLlista("Amigatxo", "", R.drawable.vegeta));
        
        Llista adaptador = new Llista(
              Adaptadors.this, versiones);
        setListAdapter(adaptador);
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
    	
    	if (true){ //aqui haurem de ficar algo per a comprovar si es admin)
    	//if admin
    	getMenuInflater().inflate(R.menu.adminoptions, menu);}
    	else{
    	//if no admin
		getMenuInflater().inflate(R.menu.main, menu);}
		return true;
	}
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_notificacion:
            	Intent intent = new Intent(Adaptadors.this, Notificacio.class);
	            startActivity(intent);
                return true;
           // case R.id.MnuOpc2:
                
                //return true;
            //case R.id.MnuOpc3:
               
               // return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}