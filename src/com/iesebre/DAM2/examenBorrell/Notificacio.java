package com.iesebre.DAM2.examenBorrell;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Notificacio extends Activity {
	private static final int NOTIF_ALERTA_ID = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notificacio);
		Button enviarnotificacio;
		Button botocancelar;
		final EditText textnotificacio;
		textnotificacio = (EditText)findViewById(R.id.textnotificacio);
		botocancelar = (Button)findViewById(R.id.cancelar);
		enviarnotificacio = (Button)findViewById(R.id.enviarnotificacio);
		
		enviarnotificacio.setOnClickListener(new OnClickListener()
	    {

	    	@Override
	        public void onClick(View v) {
	            
	    		NotificationCompat.Builder mBuilder =
				        new NotificationCompat.Builder(Notificacio.this)
				        .setSmallIcon(R.drawable.ic_launcher)
				        .setLargeIcon((((BitmapDrawable)getResources()
				        		.getDrawable(R.drawable.ic_launcher)).getBitmap()))
				        .setContentTitle("Tu equipo te habla")
				        .setContentText(textnotificacio.getText())
				       // .setContentInfo("4")
				        .setTicker("Tu equipo");

				Intent notIntent = 
						new Intent(Notificacio.this, Notificacio.class);

				PendingIntent contIntent = PendingIntent.getActivity(
						Notificacio.this, 0, notIntent, 0);

				mBuilder.setContentIntent(contIntent);

				NotificationManager mNotificationManager =
				    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

				mNotificationManager.notify(NOTIF_ALERTA_ID, mBuilder.build());
	            
	        }
	    });
		
		botocancelar.setOnClickListener(new OnClickListener()
	    {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Notificacio.this.finish();
			}
		
	});
	}
}
