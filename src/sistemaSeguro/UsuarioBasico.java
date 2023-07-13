package sistemaSeguro;


public class UsuarioBasico extends Usuario implements Bloqueable, Eliminable{

	private Integer cantIntentos; 
	private Boolean bloqueado;
	private Boolean eliminado;
	
	public UsuarioBasico(String usuario,String contraseña) {
		super(usuario, contraseña);
		this.cantIntentos=0;
		this.bloqueado=false;
		this.eliminado=false;
	}

	
	public Integer getCantIntentos() {
		return cantIntentos;
	}


	public void setCantIntentos(Integer cantIntentos) {
		this.cantIntentos = cantIntentos;
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}


	public Boolean getEliminado() {
		return eliminado;
	}


	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}



	@Override
	public void bloquearUsuario() {
		if(cantIntentos>=3) {
			bloqueado=true;
		}
		
	}

	@Override
	public void eliminarUsuario() {
		setEliminado(true);
		
	}

	

}
