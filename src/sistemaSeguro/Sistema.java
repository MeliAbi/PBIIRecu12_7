package sistemaSeguro;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import unlam.pb2.UserNotFound;

public class Sistema {

	private String nombre;
	private Set <Usuario> usuarios;

	public Sistema(String nombre) {
		this.nombre=nombre;
		usuarios=new HashSet<Usuario>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Set <Usuario> getUsuarios() {
		return usuarios;
	}

	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
		
	}
	
	public void eliminarUsuario(String nom) throws ClassCastException{
		
		if(buscarUsuario(nom) instanceof UsuarioBasico && buscarUsuario(nom)!=null) {
			((UsuarioBasico)buscarUsuario(nom)).eliminarUsuario();
		}else if (buscarUsuario(nom) instanceof UsuarioAdministrador && buscarUsuario(nom)!=null){
			throw new java.lang.ClassCastException("No se puede eliminar este usuario");
		}
			
		
	}
	
	public Usuario buscarUsuario(String nomUsuario) {
		Usuario user=null;
		
		for(Usuario actual : usuarios) {
			if(actual.getUsuario()==nomUsuario) {
				user=actual;
			}
		}
		
		return user;
	}
	
	public void ingresarUsuario(String usuario,String contraseña) throws UserNotFound {
		Usuario user=buscarUsuario(usuario);
		
		if(user instanceof UsuarioBasico) {
			Integer cant = ((UsuarioBasico)user).getCantIntentos()+1;
			
			if(user!=null && user.getContrasenia()==contraseña && cant<3){
				System.out.println("Se ingresó exitosamente");
			}else if(user!=null && user.getContrasenia()!=contraseña && cant<3) {
				((UsuarioBasico)user).setCantIntentos(cant);
			}else if(user!=null && user.getContrasenia()!=contraseña && cant>=3) {
				((UsuarioBasico) user).setBloqueado(true);
			}
		}
		
		if(user==null) {
			throw new unlam.pb2.UserNotFound("El usuario no existe");
		}

	}
	
	public void ordenarUsuarios() {
		Set<Usuario> nuevo = new TreeSet<Usuario>(new ordenarPorNombreDeUsuario());
		nuevo.addAll(usuarios);
		usuarios.addAll(nuevo);
	}

}
