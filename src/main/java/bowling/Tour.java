package bowling;

import java.util.ArrayList;

public class Tour {
	private ArrayList<Lance> lesLances;

	public Tour(ArrayList<Lance> lesLances) {
		this.lesLances = lesLances;
	}

	public Tour() {
		this.lesLances = new ArrayList<Lance>();
	}
	
	public Boolean estUnSpare(){
		Boolean bo = false;
		if (scoreTour()==10 && lesLances.size()==2)
			bo= true;
		return bo;
	}

	public Boolean estUnStrike(){
		Boolean bo = false;
		if (scoreTour()==10 && lesLances.size()==1)
			bo= true;
		return bo;
	}
	
	public int scoreTour (){
		int score=0;
		for (Lance l:lesLances){
			score+=l.getNombreGuillesAbattues();
		}
		return score;
	}
	
	
	public void addLance(Lance l){
		lesLances.add(l);
	}
	
	public int nbLance(){
		return lesLances.size();
	}
	
	public Lance getLance(int i){
		return lesLances.get(i);
	}

}
