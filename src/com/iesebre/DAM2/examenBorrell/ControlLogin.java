package com.iesebre.DAM2.examenBorrell;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class ControlLogin extends LinearLayout {
		private EditText txtUsuario;
		private EditText txtPassword;
		private Button btnLogin;
		private TextView lblMensaje;
		private OnLoginListener listener;
		
		

	public ControlLogin(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		    inicializar();
		     
	}

	public ControlLogin(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		inicializar();
	}

	public ControlLogin(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		
	}
	
	private void inicializar()
	{
	    //Utilizamos el layout 'control_login' como interfaz del control
	    String infService = Context.LAYOUT_INFLATER_SERVICE;
	    LayoutInflater li =
	        (LayoutInflater)getContext().getSystemService(infService);
	    li.inflate(R.layout.control_login, this, true);
	 
	    //Obtenemoslas referencias a los distintos control
	    txtUsuario = (EditText)findViewById(R.id.TxtUsuario);
	    txtPassword = (EditText)findViewById(R.id.TxtPassword);
	    btnLogin = (Button)findViewById(R.id.BtnAceptar);
	    
	    lblMensaje = (TextView)findViewById(R.id.LblMensaje);
	 
	    //Asociamos los eventos necesarios
	    asignarEventos();
	}
	
	public void setMensaje(String msg)
	{
	    lblMensaje.setText(msg);
	}
	
	public void setOnLoginListener(OnLoginListener l)
    {
		listener = l;
    }
	
	private void asignarEventos()
	{
	    btnLogin.setOnClickListener(new OnClickListener()
	    {
	        @Override
	        public void onClick(View v) {
	            listener.onLogin(txtUsuario.getText().toString(), txtPassword.getText().toString());
	           
	        }
	    });
	    
	    
	}
	

}
