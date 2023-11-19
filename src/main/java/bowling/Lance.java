package bowling;

public class Lance {
	private int nombreGuillesAbattues;
	public static int num;
	public int numLance;

	public Lance(int nombreGuillesAbattues) {
		this.nombreGuillesAbattues = nombreGuillesAbattues;
		numLance=num;
		num+=1;
	}

	public int getNombreGuillesAbattues() {
		return nombreGuillesAbattues;
	}

	public Boolean estUnStrike(){
		Boolean bo = false;
		if (nombreGuillesAbattues==10)
			bo= true;
		return bo;
	}

	public int getNumLance() {
		return numLance;
	}
}
