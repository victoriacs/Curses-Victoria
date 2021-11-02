/**
 * @author Victoria Carreto Stankiewicz
 * @version 0.2
 * Classe Cotxe
 * @usedby Vehicle
 */
public class Cotxe extends Vehicle {
	private String Marca;
	private String Model;

	/**
	 * Es posa la velocitat del cotxe
	 * @param vel Número de la velocitat
	 */
	public Cotxe(int vel) {
		super(vel);
	}

	/**
	 * Retorna la marca del cotxe
	 * @return Marca
	 */
	public String getMarca() {
		return Marca;
	}

	/**
	 * Es posa la marca del cotze
	 * @param marca Nom de la marca
	 */
	public void setMarca(String marca) {
		Marca = marca;
	}

	/**
	 * Retorna el model del cotxe
	 * @return Model
	 */
	public String getModel() {
		return Model;
	}

	/**
	 * Es posa el model del cotxe
	 * @param model Nom del model
	 */
	public void setModel(String model) {
		Model = model;
	}



}
