package bowling;

import java.util.ArrayList;

public class Tour {
	private Lance lance1;
	private Lance lance2;
	private static int num;
	private int numTour;

	public Tour(Lance lance1, Lance lance2) {
		this.lance1 = lance1;
		this.lance2=lance2;
		this.numTour=num;
		num+=1;
	}

	public Tour() {
		this.lance1 = null;
		this.lance2=null;
		this.numTour=num;
		num+=1;
	}
	
	public Boolean estUnSpare(){
		Boolean bo = false;
		if (scoreTour()==10 && lance2!=null)
			bo= true;
		return bo;
	}
	
	public int scoreTour (){
		return lance1.getNombreGuillesAbattues()+lance2.getNombreGuillesAbattues();
	}
	
	public Boolean estTermine(){
		boolean bo = false;
		if (lance1.estUnStrike()){
			bo=true;
		} else if (lance1!=null && lance2!=null){
			bo=true;
		}
		return bo;
	}
	
	
	public void addLance(Lance l){
		if (lance1==null){
			lance1=l;
		} else if (lance2==null){
			lance2=l;
		}
	}
	
	public int nbLance(){
		int i=0;
		if (lance1!=null){
			i+=1;
		} else if (lance2==null){
			i+=1;;
		}
		return i;
	}
	
	public Lance getLance1(){
		return lance1;
	}
	public Lance getLance2(){
		return lance2;
	}

	public int getNumTour() {
		return numTour;
	}
}
