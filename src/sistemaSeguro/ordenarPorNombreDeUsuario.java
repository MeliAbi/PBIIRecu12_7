package sistemaSeguro;

import java.util.Comparator;

public class ordenarPorNombreDeUsuario implements Comparator <Usuario>{

	@Override
	public int compare(Usuario o1, Usuario o2) {
		return o1.getUsuario().compareTo(o2.getUsuario());
	}

}
