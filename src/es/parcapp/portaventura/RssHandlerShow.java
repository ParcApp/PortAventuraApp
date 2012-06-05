package es.parcapp.portaventura;
import static es.parcapp.portaventura.BaseFeedParserHorarios.*;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RssHandlerShow extends DefaultHandler{
	private List<MessageShow> messages;
	private MessageShow currentMessage;
	private StringBuilder builder;
	
	public List<MessageShow> getMessages(){
		return this.messages;
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException{
		super.characters(ch, start, length);
		builder.append(ch, start, length);
	}
	
	@Override
	public void endElement(String uri, String localName, String Name) throws SAXException{
		super.endElement(uri, localName, Name);
		if (this.currentMessage != null){
			if (localName.equalsIgnoreCase(ID_ESPECTACULO)){
				currentMessage.setIdEspectaculo(builder.toString());
			
			} else if (localName.equalsIgnoreCase(HORARIO_SEMANAL)){
				currentMessage.setTimmingShow(builder.toString());
			} else if (localName.equalsIgnoreCase(ITEM)){
				messages.add(currentMessage);
			}
			builder.setLength(0);	
		}
	}
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		messages = new ArrayList<MessageShow>();
		builder = new StringBuilder();
	}
	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, name, attributes);
		if (localName.equalsIgnoreCase(ITEM)){
			this.currentMessage = new MessageShow();
		}
	}
}
