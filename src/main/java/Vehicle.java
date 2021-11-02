/**
 * @author Victoria Carreto Stankiewicz
 * @version 0.2
 * Classe Vehicle on es guarda la velocitat máxima i quin pilot el controla
 * @abstract
 */


public abstract class Vehicle {
	private int velocitatMAX;
	private Pilot pilot;

	/**
	 * Es posa quina velocitat máxima té
	 * @param vel Número de la velocidad
	 */
	public Vehicle(int vel) {
		velocitatMAX = vel;
	}

	/**
	 * @deprecated des de la versió 0.1
	 */
	//variable "tipus" en desús
	//public Vehicle(int vel, int tipus) {
	//	velocitatMAX = vel;
	//}

	/**
	 * Retorna el pilot que controla el vehicle
	 * @return pilot
	 */
	public Pilot getPilot() {
		return pilot;
	}

	/**
	 * Es posa el pilot que controlará el vehicle
	 * @param pilot Nom de la classe Pilot
	 */
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	/**
	 * Retorna la velocitat máxima del vehicle
	 * @return velocitatMAX
	 */
	public int getVelocitatMAX() {
		return velocitatMAX;
	}

	/**
	 * Es posa la velocitat máxima del vehicle
	 * @param velocitatMAX Número de la velocitat máxima
	 */
	public void setVelocitatMAX(int velocitatMAX) {
		this.velocitatMAX = velocitatMAX;
	}
}
