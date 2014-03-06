package com.iesebre.DAM2.examenBorrell;


import android.app.Activity;
import android.content.Intent;
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
	private Spinner position;
	private SQLiteDatabase db;
	private EditText password;
	private EditText username;
	private Button registrarse;
	private Button cancelar;
	LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarse);
       
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();
        position = (Spinner)findViewById(R.id.posicions);
        username = (EditText)findViewById(R.id.editText1);
        password = (EditText)findViewById(R.id.editText2);
        
        final String[] datos =
            new String[]{"Top","Jungler","Mid","ADC","Support"};
     
        //Alternativa 1: Array java
        ArrayAdapter<String> adaptador =
            new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datos);
        
        
        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
         
        position.setAdapter(adaptador);
        Basededades bd =
	            new Basededades(this, "DBUsuaris", null, 1);
	    		Log.i("missatge","feta correctament");
	        db = bd.getWritableDatabase();
        
        registrarse = (Button)findViewById(R.id.registrarse);
        
        
        registrarse.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//String sql = "INSERT INTO Usuaris (nombreusuario,password,posicion) VALUES ('" + usernom + "','" + password + "','" + positions.getSelectedItem().toString() + "') ";
				String Susername = username.getText().toString();  
				String Spassword = password.getText().toString();  
				String Sposition = position.getSelectedItem().toString(); 
				
				if (!Susername.equals("") || !Spassword.equals("")){
					loginDataBaseAdapter.insertEntry(Susername, Spassword, Sposition);
					Toast toast = Toast.makeText(Registrarse.this, "S'ha registrat correctament", 5);
						toast.show();
						Intent intent = new Intent(Registrarse.this, Adaptadors.class);
			            startActivity(intent);
					
				}
				else{
					Toast toast = Toast.makeText(Registrarse.this, "Por favor, introduce un nombre de usuario y una contraseña", 5);
					toast.show();
				}
			}
		});
        
        cancelar = (Button)findViewById(R.id.cancelar);
        cancelar.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Registrarse.this.finish();
			}
        });
        }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}