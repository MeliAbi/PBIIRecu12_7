package sistemaSeguro;

import static org.junit.Assert.*;

import unlam.pb2.UserNotFound;

public class Test {

	@org.junit.Test
	public void queSePuedaCrearUnSistema() {
		Sistema sistema = new Sistema("Nombre del Sistema");
		String usuario1= "lauraxx";
		String contra1= "lauraxx";
		String usuario2= "martita99";
		String contra2= "lauraxx";
		
		Usuario laura = new UsuarioBasico(usuario1,contra1);
		Usuario marta = new UsuarioAdministrador(usuario2,contra2);
		
		sistema.agregarUsuario(laura);
		sistema.agregarUsuario(marta);
		
		assertEquals(2,sistema.getUsuarios().size());
		
	}
	
	@org.junit.Test
	public void queSePuedaBloquearUnUsuarioBasico() throws UserNotFound {
		Sistema sistema = new Sistema("Nombre del Sistema");
		String usuario1= "lauraxx";
		String contra1= "lauraxx";
		String usuario2= "martita99";
		String contra2= "lauraxx";
		
		Usuario laura = new UsuarioBasico(usuario1,contra1);
		Usuario marta = new UsuarioAdministrador(usuario2,contra2);

		sistema.agregarUsuario(laura);
		sistema.agregarUsuario(marta);
		

		try {
			sistema.ingresarUsuario(usuario1,"sarasa");
			sistema.ingresarUsuario(usuario1,"sarasa");
			sistema.ingresarUsuario(usuario1,"sarasa");
		} catch (UserNotFound e) {
			throw new unlam.pb2.UserNotFound(e.getMessage());
		}
		
		
		assertEquals(true,((UsuarioBasico)sistema.buscarUsuario(usuario1)).getBloqueado());
		
	}
	
	@org.junit.Test
	public void queSePuedaEliminarUnUsuarioBasico() throws UserNotFound {
		Sistema sistema = new Sistema("Nombre del Sistema");
		String usuario1= "lauraxx";
		String contra1= "lauraxx";
		String usuario2= "martita99";
		String contra2= "lauraxx";
		
		Usuario laura = new UsuarioBasico(usuario1,contra1);
		Usuario marta = new UsuarioBasico(usuario2,contra2);

		sistema.agregarUsuario(laura);
		sistema.agregarUsuario(marta);
		
		try {
			sistema.ingresarUsuario(usuario1,contra1);
		} catch (UserNotFound e) {
			throw new unlam.pb2.UserNotFound(e.getMessage());
		}

		sistema.eliminarUsuario(usuario2);
		
		assertEquals(false,((UsuarioBasico)sistema.buscarUsuario(usuario1)).getBloqueado());
		assertEquals(true,((UsuarioBasico)sistema.buscarUsuario(usuario2)).getEliminado());
		
	}
	
	@org.junit.Test
	public void queNoSePuedaIngresarDosUsuariosConElMismoNombreDeUsuario() {
		Sistema sistema = new Sistema("Nombre del Sistema");
		String usuario1= "martita99";
		String contra1= "lauraxx";
		String contra2= "martita99";
		
		Usuario laura = new UsuarioBasico(usuario1,contra1);
		Usuario marta = new UsuarioAdministrador(usuario1,contra2);
		sistema.agregarUsuario(laura);
		sistema.agregarUsuario(marta);
		
		
		assertEquals(1,sistema.getUsuarios().size());
		
	}
	
	@org.junit.Test
	public void queSePuedaOrdenarLosUsuariosPorNombreDeUsuario() {
		Sistema sistema = new Sistema("Nombre del Sistema");
		String usuario1= "lauraxx";
		String contra1= "lauraxx";
		String usuario2= "martita99";
		String contra2= "martita99";
		String usuario3= "pablo123";
		String contra3= "pablo123";
		String usuario4= "pedro246";
		String contra4= "pedro246";
		
		Usuario laura = new UsuarioBasico(usuario1,contra1);
		Usuario marta = new UsuarioAdministrador(usuario2,contra2);
		Usuario pablo = new UsuarioBasico(usuario3,contra3);
		Usuario pedro = new UsuarioAdministrador(usuario4,contra4);
		
		sistema.agregarUsuario(laura);
		sistema.agregarUsuario(marta);
		sistema.agregarUsuario(pablo);
		sistema.agregarUsuario(pedro);
		
		sistema.ordenarUsuarios();
		System.out.println(sistema.getUsuarios());
		assertEquals(4,sistema.getUsuarios().size());
		
	}
	
	@org.junit.Test (expected=UserNotFound.class)
	public void queSeIntenteLoguearUnUsuarioInexistente() throws UserNotFound {
		Sistema sistema = new Sistema("Nombre del Sistema");
		String usuario1= "lauraxx";
		String contra1= "lauraxx";
		String usuario2= "martita99";
		String contra2= "martita99";
		
		Usuario laura = new UsuarioBasico(usuario1,contra1);
		
		sistema.agregarUsuario(laura);
		
		try {
			sistema.ingresarUsuario(usuario2, contra2);
		} catch (UserNotFound e) {
			System.out.println(e.getMessage());
			throw new unlam.pb2.UserNotFound(e.getMessage());
		}
		
		assertEquals(1,sistema.getUsuarios().size());
		
	}
	
	@org.junit.Test (expected=ClassCastException.class)
	public void queSeIntenteEliminarUnNoEliminable() throws ClassCastException {
		Sistema sistema = new Sistema("Nombre del Sistema");
		String usuario2= "martita99";
		String contra2= "martita99";
		
		Usuario marta = new UsuarioAdministrador(usuario2,contra2);
		
		sistema.agregarUsuario(marta);
		
		try {
			sistema.eliminarUsuario(usuario2);
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
			throw new java.lang.ClassCastException(e.getMessage());
		}
		
		assertEquals(1,sistema.getUsuarios().size());

	}
	
	/*
9.	Los requisitos de las contraseñas varían entre los usuarios Básicos y los usuarios Administradores.
 	Los usuarios básicos deben tener contraseñas que contengan al menos un número y una minúscula y 
 	una mayúscula. Los usuarios administradores además de los requisitos de la contraseña de los usuarios
 	 básicos deben tener un carácter especial y no puede tener secuencia de más de 3 caracteres seguidos 
 	 (123 y abc es válido, pero 1234 o abcd no). 
10.	Intentar generar un usuario con una contraseña inválida debe arrojar la excepción unlam.pb2.InvalidPassword

	 */
}
