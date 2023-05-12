package Catalogo;

public class Rivista extends ElementoCatalogo {
	private String periodicità;

	public Rivista(String codiceIsbn, String titolo, int annoPubblicazione, int numeroPagine, String periodicità) {
		super(codiceIsbn, titolo, annoPubblicazione, numeroPagine);
		this.setPeriodicità(periodicità);
	}

	public String getPeriodicità() {
		return periodicità;
	}

	public void setPeriodicità(String periodicità) {
		this.periodicità = periodicità;
	}
}
