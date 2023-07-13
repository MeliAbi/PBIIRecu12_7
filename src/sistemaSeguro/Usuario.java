package sistemaSeguro;

import java.util.Objects;

public class Usuario implements Comparable <Usuario>{
	
	protected String usuario="";
	protected String contrasenia="";

	public Usuario(String usuario,String contraseña) {
		this.usuario=usuario;
		this.contrasenia=contraseña;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	
	
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contraseña) {
		this.contrasenia = contraseña;
	}

	@Override
	public int hashCode() {
		return Objects.hash(usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(usuario, other.usuario);
	}

	@Override
	public int compareTo(Usuario o) {
		return usuario.compareTo(o.getUsuario());
	}

	public String toString()
	{
		return "Nombre: " + usuario
				+"\n";
	}
	
	
}
