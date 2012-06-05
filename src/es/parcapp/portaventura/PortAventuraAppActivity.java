package es.parcapp.portaventura;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PortAventuraAppActivity extends Activity {
   	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       Button vBoton = (Button)findViewById(R.id.btiming);
       Button vHorario = (Button)findViewById(R.id.bshow);
        vBoton.setOnClickListener(new OnClickListener(){
    
    public void onClick(View v){
    	
    Intent intent = new Intent();
    intent.setClass(getApplicationContext(), MostrarTiming.class);
    startActivity(intent);
    	
    }});
        
        vHorario.setOnClickListener(new OnClickListener(){
            
            public void onClick(View v){
            	
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(), MostrarHorarios.class);
            startActivity(intent);
            	
            }});
        
}}