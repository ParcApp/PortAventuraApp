package es.parcapp.portaventura;


public class Message implements Comparable<Message>{
	
	//CREAMOS LAS VARIABLES DE LOS VALORES QUE VAMOS A RECUPERAR
	private String IdAtraccion;
	private String IdEstado;
	private String Timming;
	

	//GETTERS Y SETTERS DE LOS METODOS
	public String getIdAtraccion() {
		return IdAtraccion;
	}
	public void setIdAtraccion(String IdAtraccion) {
		this.IdAtraccion = IdAtraccion.trim();
	}
	
	public String getIdEstado() {
		return IdEstado;
	}
	public void setIdEstado(String IdEstado) {
		this.IdEstado = IdEstado.trim();
	}
	
	public String getTimming() {
		return Timming;
	}
	public void setTimming(String Timming) {
		this.Timming = Timming.trim();
	}
	
	
	//METODO QUE COPIA EL CONTENIDO DE LAS VARIABLES
	public Message copy(){
		Message copy = new Message();
		copy.IdAtraccion = IdAtraccion;
		copy.IdEstado = IdEstado;
		copy.Timming = Timming;
		
		return copy;
	}
	
	//SOBREESCRIBIMOS EL METODO TOSTRING CON NUESTROS DATOS
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID ATRACCIÓN: ");
		sb.append(IdAtraccion);
		sb.append('\n');
		sb.append("ID ESTADO: ");
		sb.append(IdEstado);
		sb.append('\n');
		sb.append("TIMMING: ");
		sb.append(Timming);
		sb.append('\n');	
		
		return sb.toString();
	}

	//CREAMOS UNA HASTABLE PARA IR GUARDANDO LOS DATOS Y ASI SU ACCESO ES MAS COMODO
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdAtraccion == null) ? 0 : IdAtraccion.hashCode());
		result = prime * result + ((IdEstado == null) ? 0 : IdEstado.hashCode());
		result = prime * result + ((Timming == null) ? 0 : Timming.hashCode());
		
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (IdAtraccion == null) {
			if (other.IdAtraccion != null)
				return false;
		} else if (!IdAtraccion.equals(other.IdAtraccion))
			return false;
		if (IdEstado == null) {
			if (other.IdEstado != null)
				return false;
		} else if (!IdEstado.equals(other.IdEstado))
			return false;
		if (Timming == null) {
			if (other.Timming != null)
				return false;
		} else if (!Timming.equals(other.Timming))
			return false;
	
		
		return true;
	}

	public int compareTo(Message another) {
		if (another == null) return 1;
		// sort descending, most recent first
		return another.IdAtraccion.compareTo(IdAtraccion);
	}
}
