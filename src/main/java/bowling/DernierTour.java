package bowling;

public class DernierTour extends Tour {
	private Lance lance3;

	public DernierTour() {
		super();
		this.lance3 = new Lance(-1);
	}

	public Boolean estTermine() {
		boolean bo = false;
		if (getLance1().estUnStrike() || this.estUnSpare()) {
			if (getLance1().estLance() && getLance2().estLance() && lance3.estLance())
				bo = true;
		} else if (getLance1().estLance() && getLance2().estLance()) {
			bo = true;
		}
		return bo;
	}

	public void addLance(int nb) {
		if (!getLance1().estLance()) {
			getLance1().setNombreGuillesAbattues(nb);
		} else if (!getLance2().estLance()) {
			getLance2().setNombreGuillesAbattues(nb);
		} else if (!lance3.estLance())
			lance3.setNombreGuillesAbattues(nb);
	}



	public Lance getLance3() {
		return lance3;
	}

	@Override
	public String toString() {
		return super.toString() +
			", lance3=" + lance3;
	}

	public int scoreDernierTour() {
		int tot = 0;
		if (getLance1().estLance() && getLance2().estLance() && lance3.estLance()) {
			tot = getLance1().getNombreGuillesAbattues() + getLance2().getNombreGuillesAbattues() + lance3.getNombreGuillesAbattues();
		} else if (getLance1().estLance() && getLance2().estLance() && !lance3.estLance()) {
			tot = getLance1().getNombreGuillesAbattues() + getLance2().getNombreGuillesAbattues();
		} else if (getLance1().estLance() && !getLance2().estLance()) {
			tot = getLance1().getNombreGuillesAbattues();
		}
		return tot;
	}
}
