package Catalogo;

public class ElementoCatalogo {
	protected String codiceIsbn;
	protected String titolo;
	protected int annoPubblicazione;
	protected int numeroPagine;

	public ElementoCatalogo(String codiceIsbn, String titolo, int annoPubblicazione, int numeroPagine) {
		this.codiceIsbn = codiceIsbn;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}
}
