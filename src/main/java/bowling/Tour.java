package bowling;

import java.util.ArrayList;

public class Tour {
	private Lance lance1;
	private Lance lance2;
	private static int num=1;
	private int numTour;

	public Tour() {
		this.lance1 = new Lance(-1);
		this.lance2 =new Lance(-1);
		this.numTour = num;
		this.num+=1;
	}

	public Boolean estUnSpare() {
		Boolean bo = false;
		if (scoreTour() == 10 && lance2.estLance())
			bo = true;
		return bo;
	}

	public int scoreTour() {
		int tot =0;
		if (lance1.estLance() && lance2.estLance()) {
			tot=lance1.getNombreGuillesAbattues() + lance2.getNombreGuillesAbattues();
		}else if (lance1.estLance() && !lance2.estLance()) {
			tot=lance1.getNombreGuillesAbattues() ;
		}else {
			tot=0;
		}
		return tot;
		
	}

	public Boolean estTermine() {
		boolean bo = false;
		if (lance1.estUnStrike()) {
			bo = true;
		} else if (lance1.estLance() && lance2.estLance()) {
			bo = true;
		}
		return bo;
	}

	public void addLance(int nb) {
		if (!lance1.estLance()) {
			lance1.setNombreGuillesAbattues(nb);
		} else if (!lance2.estLance()) {
			lance2.setNombreGuillesAbattues(nb);
		}
	}

	public int nbLance() {
		int i = 0;
		if (lance1.estLance()) {
			i += 1;
		} else if (lance2.estLance()) {
			i += 1;
			;
		}
		return i;
	}

	public Lance getLance1() {
		return lance1;
	}

	public Lance getLance2() {
		return lance2;
	}

	public int getNumTour() {
		return numTour;
	}

	@Override
	public String toString() {
		return "Tour : " +
			" numTour=" + numTour +
			", lance1=" + lance1 +
			", lance2=" + lance2;
	}
}
