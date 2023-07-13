package sistemaSeguro;

import java.util.ArrayList;

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
	
	public Boolean contraseñaValida() {
		
		Boolean res = false;
		int largo = contrasenia.length();
		Boolean cn = false;
		Boolean cmay = false;
		Boolean cmin = false;
		
		for(int i=0; i<largo;i++) {
			if((contrasenia.charAt(i)>=48 && contrasenia.charAt(i)<=57)) {
				cn=true;
			}
			else if((contrasenia.charAt(i)>=65 && contrasenia.charAt(i)<=90)) {
				cmay=true;
			}
			else if((contrasenia.charAt(i)>=97 && contrasenia.charAt(i)<=122)) {
				cmin=true;
			}
		}
		if(cn&&cmay&&cmin) {
			res = true;
		};
		return res;
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
