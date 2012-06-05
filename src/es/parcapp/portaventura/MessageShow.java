package es.parcapp.portaventura;


public class MessageShow implements Comparable<MessageShow>{
	
	private String IdEspectaculo;
	private String TimmingShow;
	
	public String getIdEspectaculo() {
		return IdEspectaculo;
	}
	public void setIdEspectaculo(String IdEspectaculo) {
		this.IdEspectaculo = IdEspectaculo.trim();
	}
	public String getTimmingShow() {
		return TimmingShow;
	}
	public void setTimmingShow(String TimmingShow) {
		this.TimmingShow = TimmingShow.trim();
	}
	
	public MessageShow copy(){
		MessageShow copy = new MessageShow();
		copy.IdEspectaculo = IdEspectaculo;
		copy.TimmingShow = TimmingShow;
		return copy;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID ESPECTACULO: ");
		sb.append(IdEspectaculo);
		sb.append('\n');
		sb.append("TIMMING SHOW: ");
		sb.append(TimmingShow);
		sb.append('\n');
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdEspectaculo == null) ? 0 : IdEspectaculo.hashCode());
		result = prime * result + ((TimmingShow == null) ? 0 : TimmingShow.hashCode());
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
			MessageShow other = (MessageShow) obj;
			if (IdEspectaculo == null) {
				if (other.IdEspectaculo != null)
					return false;
			} else if (!IdEspectaculo.equals(other.IdEspectaculo))
				return false;
			if (TimmingShow == null) {
				if (other.TimmingShow != null)
					return false;
			} else if (!TimmingShow.equals(other.TimmingShow))
				return false;
			
			return true;
		}
		public int compareTo(MessageShow another) {
			if (another == null) return 1;
			// sort descending, most recent first
			return another.IdEspectaculo.compareTo(IdEspectaculo);
		}
		
	}
		

