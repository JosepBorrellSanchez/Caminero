package com.iesebre.DAM2.examenBorrell;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	
	private ControlLogin ctlLogin;
	private Button registrarse;
	private SQLiteDatabase db;
		@Override
		public void onCreate(Bundle savedInstanceState)
		{
			 Basededades bd =
			            new Basededades(this, "DBUsuaris", null, 1);
			    		Log.i("missatge","feta correctament");
			        db = bd.getWritableDatabase();
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.activity_main);
		    
		    registrarse =(Button)findViewById(R.id.registrarse);
		    ctlLogin = (ControlLogin)findViewById(R.id.CtlLogin);
		   
		    ctlLogin.setOnLoginListener(new OnLoginListener()
		    {
		    @Override
		    public void onLogin(String usuario, String password)
		    {
		        //Validamos el usuario y la contrase�a
		        if (usuario.equals("dam") && password.equals("dam")) {
		            ctlLogin.setMensaje("Login correcto, entrando a tu equipo");
		            Intent i = new Intent(MainActivity.this, Adaptadors.class);
                    startActivity(i);
		        }
		        else
		            ctlLogin.setMensaje("Usuario o contraseña incorrectos");
		    }
		    });
		
		    registrarse.setOnClickListener(new OnClickListener()
		    {

		    	@Override
		        public void onClick(View v) {
		            Intent intent = new Intent(MainActivity.this, Registrarse.class);
		            startActivity(intent);
		            
		        }
		    });
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
