package com.iesebre.DAM2.examenBorrell;


import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Registrarse extends Activity {
	private TextView lblMensaje;
	private Spinner posicions;
	private SQLiteDatabase db;
	private EditText password;
	private EditText nom;
	private Button registrarse;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarse);
        
        posicions = (Spinner)findViewById(R.id.posicions);
        nom = (EditText)findViewById(R.id.editText1);
        password = (EditText)findViewById(R.id.editText2);
        
        final String[] datos =
            new String[]{"Top","Jungler","Mid","ADC","Support"};
     
        //Alternativa 1: Array java
        ArrayAdapter<String> adaptador =
            new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datos);
        
        
        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
         
        posicions.setAdapter(adaptador);
        Basededades bd =
	            new Basededades(this, "DBUsuaris", null, 1);
	    		Log.i("missatge","feta correctament");
	        db = bd.getWritableDatabase();
        
        registrarse = (Button)findViewById(R.id.registrarse);
        registrarse.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String sql = "INSERT INTO Usuaris (nombreusuario,password,posicion) VALUES ('" + nom + "','" + password + "','" + posicions.getSelectedItem().toString() + "') ";
				db.execSQL(sql);
			Toast toast = Toast.makeText(Registrarse.this, "S'ha registrat correctament", 5);
				toast.show();
			}
		});
        };
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}