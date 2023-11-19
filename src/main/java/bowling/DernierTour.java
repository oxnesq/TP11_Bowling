package bowling;

public class DernierTour extends Tour {
	private Lance lance3;

	public DernierTour() {
		super();
		this.lance3 = new Lance(-1);
	}

	public int scoreTour() {
		return super.scoreTour() + lance3.getNombreGuillesAbattues();
	}

	public Boolean estTermine() {
		boolean bo = false;
		if (getLance1().estLance() && getLance2().estLance() && lance3.estLance()) {
			if (getLance1().estUnStrike() || this.estUnSpare())
				bo = true;
		} else if (getLance1().estLance() && getLance2().estLance() && !lance3.estLance()) {
			bo = true;
		}
		return bo;
	}

	public void addLance(int nb) {
		super.addLance(nb);
		if (getLance1().getNombreGuillesAbattues() != -1
			&& getLance2().getNombreGuillesAbattues() != -1
			&& lance3.getNombreGuillesAbattues() == -1) {
			lance3.setNombreGuillesAbattues(nb);
		}
	}

	public Lance getLance3() {
		return lance3;
	}

	@Override
	public String toString() {
		return super.toString() +
			", lance3=" + lance3;
	}
}
