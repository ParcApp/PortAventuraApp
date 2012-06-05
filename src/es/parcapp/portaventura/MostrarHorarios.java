package es.parcapp.portaventura;

import java.util.ArrayList;
import java.util.List;




import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
//import android.widget.ListAdapter;
//import android.widget.ListView;


public class MostrarHorarios extends ListActivity {
	private List<MessageShow> messages;
	@Override
	protected void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);
		loadFeed();
		
	}
	private void loadFeed(){
		String idEspectaculo;
        
		try{
			BaseFeedParserHorarios parser = new BaseFeedParserHorarios();
			messages = parser.parse();
			List<String> titles = new ArrayList<String>(messages.size());
			for(MessageShow msg : messages){
				idEspectaculo=msg.getIdEspectaculo();
				
				int idEsp = Integer.parseInt(idEspectaculo);
				switch(idEsp){
				case 1:
					titles.add("Sésamo Parade");
					titles.add(msg.getTimmingShow());
				case 2:
					titles.add("Aloha Tahiti");
					titles.add(msg.getTimmingShow());
				
				case 3:
					titles.add("Aves del Paraíso");
					titles.add(msg.getTimmingShow());
				
				case 4: 
					titles.add("Pareos en Bora-Bora");
					titles.add(msg.getTimmingShow());
				case 5:
					titles.add("Sea Odissey 4D");
					titles.add(msg.getTimmingShow());
				case 6:
					titles.add("Bubblebou");
					titles.add(msg.getTimmingShow());
				case 7:
					titles.add("Music Generation");
					titles.add(msg.getTimmingShow());
				case 8:
					titles.add("Los Shaolin de Shambhala");
					titles.add(msg.getTimmingShow());
				case 9:
					titles.add("Templo del Fuego");
					titles.add(msg.getTimmingShow());
				case 10:
					titles.add("Baila Mexico");
					titles.add(msg.getTimmingShow());
				case 11:
					titles.add("Bang Bang West");
					titles.add(msg.getTimmingShow());
				case 12:
					titles.add("Atraco al Saloon");
					titles.add(msg.getTimmingShow());
				case 13:
					titles.add("Sésamoaventura");
					titles.add(msg.getTimmingShow());
				case 14:
					titles.add("¡Es la hora de la aventura!");
					titles.add(msg.getTimmingShow());
				
				//titles.add(msg.getIdEspectaculo());
				//titles.add(msg.getTimmingShow());
			
		}}
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row,titles);
			    	
			    	this.setListAdapter(adapter);
		    	} catch (Throwable t){
		    		Log.e("AndroidNews",t.getMessage(),t);
		    	}
		
	}}
	