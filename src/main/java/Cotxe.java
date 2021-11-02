public class Cotxe extends Vehicle {
	private String Marca;
	private String Model;

	public Cotxe(int vel) {
		super(vel);
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}



}
