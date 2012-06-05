package es.parcapp.portaventura;

import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MostrarTiming extends Activity{
	
	@Override
	protected void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timing);
		
		 TextView dragonKhanTime =(TextView)findViewById(R.id.dragonKhanTime);
		 TextView shambalaTime =(TextView)findViewById(R.id.shambalaTime);
		 TextView tutukiTime =(TextView)findViewById(R.id.tutukiSplashTime);
		 TextView rapidTime =(TextView)findViewById(R.id.grandCanyonRapidsTime);
		 TextView silverTime =(TextView)findViewById(R.id.silverRiverFlumeTime);
		 TextView furiusTime =(TextView)findViewById(R.id.furiusBacoTime);
		 TextView huracanTime =(TextView)findViewById(R.id.huracanCondorTime);
		 TextView seaTime =(TextView)findViewById(R.id.seaOdysseyTime);
		 TextView temploTime =(TextView)findViewById(R.id.temploDelFuegoTime);
		 TextView stampidaTime =(TextView)findViewById(R.id.stampidaTime);
		 TextView diabloTime =(TextView)findViewById(R.id.eldiabloTime);
		 List<Message> messages;
		 String idAtraccion;
		 String idEstado;
		 String Timming;
				
		try{
	    	BaseFeedParser parser = new BaseFeedParser();
	    	messages = parser.parse();
	    	//List<String> titles = new ArrayList<String>(messages.size());
	    	for (Message msg : messages){
	    		idAtraccion = msg.getIdAtraccion();
	    		idEstado = msg.getIdEstado();
	    		Timming=msg.getTimming();
	    		int idA = Integer.parseInt(idAtraccion);
	    		int idE = Integer.parseInt(idEstado);
	    		//int t = Integer.parseInt(Timming);
	    		switch(idA){
	    		case 1:
	    			if(idE == 2){
	    				furiusTime.setText(Timming);
	    			}else{
	    				furiusTime.setText("--:--");
	    			}
	    		case 2:
	    			if(idE == 2){
	    				tutukiTime.setText(Timming);
	    			}else{
	    				tutukiTime.setText("--:--");
	    			}
	    		case 3:
	    			if(idE == 2){
	    				seaTime.setText(Timming);
	    			}else{
	    				seaTime.setText("--:--");
	    			}
	    		case 4:
	    			if(idE == 2){
	    				dragonKhanTime.setText(Timming);
	    			}else{
	    				dragonKhanTime.setText("--:--");
	    			}
	    		case 5:
	    			if(idE == 2){
	    				shambalaTime.setText(Timming);
	    			}else{
	    				shambalaTime.setText("--:--");
	    			}
	    		case 6:
	    			if(idE == 2){
	    				diabloTime.setText(Timming);
	    			}else{
	    				diabloTime.setText("--:--");
	    			}
	    		case 7:
	    			if(idE == 2){
	    				huracanTime.setText(Timming);
	    			}else{
	    				huracanTime.setText("--:--");
	    			}
	    		case 8:
	    			if(idE == 2){
	    				temploTime.setText(Timming);
	    			}else{
	    				temploTime.setText("--:--");
	    			}
	    		case 9:
	    			if(idE == 2){
	    				stampidaTime.setText(Timming);
	    			}else{
	    				stampidaTime.setText("--:--");
	    			}
	    		case 10:
	    			if(idE == 2){
	    				silverTime.setText(Timming);
	    			}else{
	    				silverTime.setText("--:--");
	    			}
	    		case 11:
	    			if(idE == 2){
	    				rapidTime.setText(Timming);
	    			}else{
	    				rapidTime.setText("--:--");
	    			}
	    		
	    	
	    	
	    		}
	    	
	    	
    	}
	    	
		} catch (Throwable t){
    		Log.e("AndroidNews",t.getMessage(),t);
    	}
			
	
	}
	
		


}
		

	
	


	