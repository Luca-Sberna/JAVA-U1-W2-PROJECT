package Catalogo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Archivio {
	private List<ElementoCatalogo> elementiCatalogo;

	public Archivio() {
		this.elementiCatalogo = new ArrayList<>();
	}

	public void aggiungiElemento(ElementoCatalogo elemento) {
		elementiCatalogo.add(elemento);
	}

	public ElementoCatalogo rimuoviElemento(String codiceIsbn) {
		ElementoCatalogo elementoRimosso = ricercaPerIsbn(codiceIsbn);
		elementiCatalogo.removeIf(e -> e.codiceIsbn.equals(codiceIsbn));
		return elementoRimosso;
	}

	public ElementoCatalogo ricercaPerIsbn(String codiceIsbn) {
		return elementiCatalogo.stream().filter(e -> e.codiceIsbn.equals(codiceIsbn)).findFirst().orElse(null);
	}

	public List<ElementoCatalogo> getElementiCatalogo() {
		return elementiCatalogo;
	}

	public List<ElementoCatalogo> ricercaPerAnnoPubblicazione(int annoPubblicazione) {
		return elementiCatalogo.stream().filter(e -> e.annoPubblicazione == annoPubblicazione)
				.collect(Collectors.toList());
	}

	public List<Libro> ricercaPerAutore(String autore) {
		return elementiCatalogo.stream().filter(e -> e instanceof Libro).map(e -> (Libro) e)
				.filter(l -> l.autore.equals(autore)).collect(Collectors.toList());
	}

	public void salvaSuDisco(String nomeFile) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
			out.writeObject(elementiCatalogo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void caricaDaDisco(String nomeFile) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeFile))) {
			elementiCatalogo = (List<ElementoCatalogo>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
