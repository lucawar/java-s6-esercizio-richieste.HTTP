package lucaguerra.exceptions;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException {

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(int id) {
		super("Siamo spiacenti l'ID: " + id + " non è stato trovato");
	}
}
