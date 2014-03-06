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
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Button login;
	private Button registrarse;
	private SQLiteDatabase db;
	 LoginDataBaseAdapter loginDataBaseAdapter;
		@Override
		public void onCreate(Bundle savedInstanceState)
		{
			 loginDataBaseAdapter=new LoginDataBaseAdapter(this);
	         loginDataBaseAdapter=loginDataBaseAdapter.open();
			 Basededades bd =
			            new Basededades(this, "DBUsuaris", null, 1);
			    		Log.i("missatge","feta correctament");
			        db = bd.getWritableDatabase();
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.activity_main);
		    
		    login =(Button)findViewById(R.id.login);
		    registrarse = (Button)findViewById(R.id.registrarse);

		    login.setOnClickListener(new View.OnClickListener() 
		    {
		    @Override
		    public void onClick(View v) {
                // get The User name and Password
		    	
		    	 final  EditText editTextUserName=(EditText)findViewById(R.id.TxtUsuario);
		         final  EditText editTextPassword=(EditText)findViewById(R.id.TxtPassword);
                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();

                if (!userName.equals("") || !password.equals("")){
                // fetch the Password form database for respective user name
                String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);
                // check if the Stored password matches with  Password entered by user
                if(password.equals(storedPassword))
                {
                    Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, Adaptadors.class);
    	            startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
                }
                }
                else{
                	Toast.makeText(MainActivity.this, "No puedes dejar en blanco los campos", Toast.LENGTH_LONG).show();
                }
            }
        });
		    
		    
                
		       /* if (usuario.equals("dam") && password.equals("dam")) {
		            ctlLogin.setMensaje("Login correcto, entrando a tu equipo");
		            Intent i = new Intent(MainActivity.this, Adaptadors.class);
                    startActivity(i);
		        }
		        else
		            ctlLogin.setMensaje("Usuario o contraseÃ±a incorrectos");
		    }*/
		   
		
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
