package bowling;

public class Lance {
	private int nombreGuillesAbattues;

	public Lance(int nombreGuillesAbattues) {
		this.nombreGuillesAbattues = nombreGuillesAbattues;
	}

	public int getNombreGuillesAbattues() {
		return nombreGuillesAbattues;
	}

	public Boolean estUnStrike() {
		Boolean bo = false;
		if (nombreGuillesAbattues == 10)
			bo = true;
		return bo;
	}

	public void setNombreGuillesAbattues(int nombreGuillesAbattues) {
		this.nombreGuillesAbattues = nombreGuillesAbattues;
	}

	public Boolean estLance() {
		if (nombreGuillesAbattues == -1) {
			return false;
		}
		return true;


	}

	@Override
	public String toString() {
		return "Lance{" +
			"nombreGuillesAbattues=" + nombreGuillesAbattues +
			'}';
	}
}
