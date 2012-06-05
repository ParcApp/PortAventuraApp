package es.parcapp.portaventura;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import es.parcapp.portaventura.Message;



import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.util.Xml;

public class BaseFeedParser {

	//URL QUE LLAMAMOS PARA OBTENER EL FICHERO XML
	static String feedUrlString = "http://appportaventura.gsip.es/WebServices/ws_timming_atracciones.php?keyWsTimmingClient=vb18t15dRtCpLmeT580@qwR9";
	
	//TAGS PADRE/HIJO QUE ENCONTRAREMOS EN EL XML
	static final String RSS = "PortAventura";
	static final String CHANNEL = "AtraccionesTimming";
	static final String ITEM = "app_portaventura_atracciones_timming";
	
	//ELEMENTOS DE CADA ITEM, SON LOS CAMPOS QUE OBTENEMOS DE LA BASE DE DATOS
	static final String ID_ATRACCION = "ID_ATRACCION";
	static final String ID_ESTADO = "ID_ESTADO";
	static final String TIMMING = "TIEMPO_ESPERA";

	//CREAMOS UNA VARIABLE DEL TIPO URL
	private final URL feedUrl;

	//UTILIZAMOS ESTE METODO PARA INDICARLE QUE LA VERIABLE FEEDURL DEBE HACER REFRENCIA A LA VARIABLE FEEDURLSTRING
	protected BaseFeedParser(){
		try {
			this.feedUrl = new URL(feedUrlString);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	//UTILIZAMOS ESTE METODO PARA ABRIR CONEXION CON LA URL (CONECTARNOS A LA URL QUE NOS DEVUELVE EL XML)
	protected InputStream getInputStream() {
		try {
			return feedUrl.openConnection().getInputStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	//PARSEAMOS EL XML CREANDO UNA LIST INDICANDO QUE LA ETIQUETA PRINCIPAL ES EL CHANNEL, QUE EL HIJO SON LOS ITEMS Y DENTRO DE ESTOS ESTAN LOS ELEMENTOS 
	public List<Message> parse() {
		final Message currentMessage = new Message();
		RootElement root = new RootElement(RSS);
		final List<Message> messages = new ArrayList<Message>();
		Element itemlist = root.getChild(CHANNEL);
		Element item = itemlist.getChild(ITEM);
		item.setEndElementListener(new EndElementListener(){
			public void end() {
				messages.add(currentMessage.copy());
			}
		});
		item.getChild(ID_ATRACCION).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body) {
				currentMessage.setIdAtraccion(body);
			}
		});
		item.getChild(ID_ESTADO).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body) {
				currentMessage.setIdEstado(body);
			}
		});
		item.getChild(TIMMING).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body) {
				currentMessage.setTimming(body);
			}
		});
		try {
			Xml.parse(this.getInputStream(), Xml.Encoding.UTF_8, root.getContentHandler());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return messages;
	}
}