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
		if (scoreTour()==10 && lesLances.size()==2)
			return true;
		return false;
	}

	public Boolean estUnStrike(){
		if (scoreTour()==10 && lesLances.size()==1)
			return true;
		return false;
	}
	
	/*public boolean estEnCours(){
		Boolean bo=false;
		if (lesLances.size()==0 ||lesLances.size()==1 )
			for (Lance l : lesLances){
				if (l.getNombreGuillesAbattues()<10)
					bo=true;
		}
		return bo;
	}*/
	
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

}
