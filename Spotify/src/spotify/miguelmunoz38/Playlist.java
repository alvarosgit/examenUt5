package spotify.miguelmunoz38;

import java.util.ArrayList;
import java.util.List;

import spotify.exception.DatosInvalidosException;
/**
 * En la clase Playlist administramos la playlist, en ella podemos obtener la duración total,
 * agregar canciones y encontar canciones por su nombre.
 * @author miguel.munoz38@educa.madrid.org
 * @version 1.5
 *
 */
//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5
public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	/**
	 * En el metodo obtienes la duracion total de la canción y la convierte de segundos a minutos.
	 * @return Devuelve la duración de la canción en minutos.
	 */
	// Poner descripcion, valor de retorno.
	//En los comentarios describir cómo se obtienen los minutos y a partir de qué dato de la clase.
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
	/**
	 * En el metodo se le pasa un canción y comprueba si esta en la playlist y si no esta la añade
	 * y si es un valor nulo nos devuelve un mensaje.
	 * @param nueva es la canción que se quiera añadir a dicha playlist.
	 * @return devuelve que la canción ha sido añadida a la playlist.
	 * @throws DatosInvalidosException saldrá esta excepción cuando se introduzca un valor nulo.
	 * @since 1.0
	 */
	
		
	// Poner descripcion, parametros de entrada, valor de retorno, y excepción. Además que pueda
	// referenciar tanto a las clases Cancion y DatosInvalidosException
	//Existe desde la version 1.0
	public boolean agregarCancion(Cancion nueva) throws DatosInvalidosException {

		boolean exito = false;
		if (canciones == null) {
			this.canciones = new ArrayList<>();
		}
		if (nueva == null || nueva.getNombre() == null) {
			throw new DatosInvalidosException("La cancion o su nombre es vacía");
		}

		boolean existeCancion = this.encontrarCancionPorNombre(nueva.getNombre());
		if (!existeCancion) {
			exito = canciones.add(nueva);
		}

		return exito;
	}


	/**
	 * El metodo se le necesita el nombre de una canción para poder nencontarla, recorre el array de canciones y si lo encuentra devuelve lo optenido.
	 * @param nombre es el nombre de la canción.
	 * @return devuelve si es encontrada la canción. 
	 * @since 1.5
	 */
	// Poner descripcion, parametros de entrada, valor de retorno, y excepción.
	//Existe desde la version 1.5
	public boolean encontrarCancionPorNombre(String nombre) {
		boolean encontrado = false;
		int contador = 0;
		while (!encontrado && contador < canciones.size()) {
/**
 * 
 */
			// Si el nombre de la cancion obtenida en cada vuelta es igual a la que se
			// quiere
			if (canciones.get(contador).getNombre().equalsIgnoreCase(nombre)) {
				encontrado = true;
			}

			contador++;
		}

		return encontrado;
	}
	/**
	 * El metodo se le necesita el nombre de una canción para poder nencontar la canción, recorre el array de canciones y si lo encuentra devuelve lo optenido.
	 * @param nombreCancion la canción que queramos buscar.
	 * @return devuelve si es encontrada la canción.
	 * @deprecated utilizar mejor {@link #encontrarCancionPorNombre(String)}
	 * @since 1.0
	 */
	// Este metodo está deprecado porque se ha hecho uno mejor, y el que lo sustituye es el
	// encontrarCancionPorNombre(String nombre)
	//Existe desde la version 1.0
	public boolean encontrarCancion(String nombreCancion) {
		boolean encontrado = false;

		for (int cont = 0; cont < canciones.size(); cont++) {
			Cancion cancionExtraida = this.canciones.get(cont);
			if (cancionExtraida.getNombre().equals(nombreCancion)) {
				encontrado = true;
				break;
			}
			
		}
		return encontrado;
	}

	


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTotalSegundos() {
		return totalSegundos;
	}

	public void setTotalSegundos(int totalSegundos) {
		this.totalSegundos = totalSegundos;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	//////////////////////  METODOS PRIVADOS ////////////////////////////


//	private void comprobarErroresEliminar(String nombreCancion)
//			throws DatosInvalidosException, OperacionNoPermitidaException {
//		if (nombreCancion == null || nombreCancion.isEmpty()) {
//			throw new DatosInvalidosException("La cancion o su nombre es vacía");
//		}
//
//		if (canciones == null) {
//			throw new OperacionNoPermitidaException(
//					"No es posible eliminar la cancion. La lista de canciones está vacía");
//		}
//	}
//	

//	// Poner parametros de entrada, valor de retorno, y excepción. Además que pueda
//		// referenciar a la clase DatosInvalidosException
//	//Existe desde la version 1.0
//	public boolean eliminarCancion(String nombreCancion) throws DatosInvalidosException, OperacionNoPermitidaException {
//		boolean exito = false;
//
//		comprobarErroresEliminar(nombreCancion);
//		
//		boolean existeCancion = this.encontrarCancionPorNombre(nombreCancion);
//		if (existeCancion) {
//			Cancion eliminar = new Cancion();
//			eliminar.setNombre(nombreCancion);
//			exito = this.canciones.remove(eliminar);
//		}
//
//		return exito;
//	}
	
	

	
	
}