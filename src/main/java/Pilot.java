/**
 * @author Victoria Carreto Stankiewicz
 * @version 0.2
 * Classe Pilot on es guarda el seu nom, quin nivell té i els punts que té
 */

import java.util.Date;

public class Pilot {
	private String nom;
	private int nivell;
	private int punts;

	/**
	 * Es posa el nom del pilot
	 * @param nom Nom del pilot
	 */
	public Pilot(String nom) {
		this.nom = nom;
	}

	/**
	 * @deprecated des de la versió 0.1
	 */
	//ara tractem els punts de forma diferent
	//public Pilot(String punts) {
	//	this.punts = punts;
	//}

	/**
	 * Retorna el nom del pilot
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Retorna els punts del pilot
	 * @return punts
	 */
	public int getPunts() {
		return punts;
	}

	/**
	 * s posa un número de punts
	 * @param punts Número de punts
	 */
	public void setPunts(int punts) {
		this.punts = punts;
	}

	/**
	 * Funció on s'afafeix punts
	 * @param p Número de punts
	 */
	public void addPunts(int p) {
		punts += p;
	}

	//sobrecàrrega que hereta de la classe Object
	public String toString() {
		return "Pilot{" +
				"nom='" + nom + '\'' +
				", punts=" + punts +
				'}';
	}
}
