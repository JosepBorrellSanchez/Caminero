package com.iesebre.DAM2.examenBorrell;

import java.util.ArrayList;


import android.app.ListActivity;
import android.os.Bundle;

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
}