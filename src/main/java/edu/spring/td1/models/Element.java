package edu.spring.td1.models;

public class Element {
	private String nom;
	private int evaluation;
	public Element(String nom) {
		this.nom=nom;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Element)) {
			return false;
		}
		Element other=((Element)obj);
		if(other.getNom()==null) {
			return nom==null;
		}else {
			return other.getNom().equals(nom);
		}
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}
	public void inc() {
		evaluation++;
		
	}
	
	public void dec() {
		evaluation--;
		
	}
	
}
