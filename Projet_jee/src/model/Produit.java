package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;




public class Produit implements Comparable<Produit>{
	private int id;
	private String titre;
	private int price;
	private String category;
	private String description;
	private String image;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Product [titre=" + titre + ", description=" + description + ", prix=" + price + ", categorie=" + category + ", image=" + image + "]";
	}
	public boolean findProduct(ArrayList<String> panier, String id2) {
		for(String id : panier) {
			if(id.equals(id2))
				return true;
		}
		return false;
	}
	public ArrayList<String> removeProduct(ArrayList<String> panier, String id) {
		for(String cid : panier) {
			if(cid.equals(id)) {
				panier.remove(cid);
				break;
			}
				
		}
		
		return panier;
	}
	public ArrayList<Produit> lowtohigh(ArrayList<Produit> list) {
		Collections.sort(list);
		return list;
	}
	
	@Override
	public int compareTo(Produit p) {
		
		return this.price-p.price;
	}
	public ArrayList<Produit> hightolow(ArrayList<Produit> listeProduits) {
		Collections.sort(listeProduits, new tocampareClass());
		return listeProduits;
	}
	



class tocampareClass implements Comparator<Produit>{

	@Override
	public int compare(Produit o1, Produit o2) {
		return o2.getPrice()- o1.getPrice();
	}
	
}
}