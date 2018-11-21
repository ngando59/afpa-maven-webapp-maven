package fr.ngando.cart.domain;

import java.util.HashMap;
import java.util.Map;

import fr.ngando.commons.decimalformatprintable.DecimalFormatPrintable;
import fr.ngando.product.domain.Product;

public class Cart implements DecimalFormatPrintable {
	
	private Map<Product, Integer> panier;
	private int nbArticles;
	private double montant;
	
	public Cart() {
		panier = new HashMap<Product, Integer>();
	}

	public void add(Product produit, int quantite) {
		panier.put(produit, quantite);
	}
	
	public void remove(Product produit) {
		panier.remove(produit);
	}
	
	public void setQuantite(Product produit, Integer quantite) {
		//panier.
	}

	public int getNbArticles() {
		return nbArticles;
	}

	public void setNbArticles(int nbArticles) {
		this.nbArticles = nbArticles;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	} 
	
}
