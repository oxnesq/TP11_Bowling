package bowling;

public class DernierTour extends Tour{
	private Lance lance3;

	public DernierTour() {
		super(null, null);
		this.lance3=null;
	}

	public int scoreTour (){
		return super.scoreTour()+lance3.getNombreGuillesAbattues();
	}

	public Boolean estTermine(){
		boolean bo = false;
		if (getLance1()!=null && getLance2()!=null && lance3!=null){
			if (getLance1().estUnStrike() || this.estUnSpare())
			bo=true;
		} else if (getLance1()!=null && getLance2()!=null){
			bo=true;
		}
		return bo;
	}

	public void addLance(Lance l){
		super.addLance(l);
		if (getLance1()!=null&&getLance2()!=null &&lance3==null){
			lance3=l;
		}
	}

	public Lance getLance3() {
		return lance3;
	}
}
