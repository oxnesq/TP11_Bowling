package bowling;

import java.util.ArrayList;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancers successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class PartieMonoJoueur {
	private ArrayList<Tour> lesTours;
	private int scorePartie;

	public PartieMonoJoueur() {
		this.lesTours= new ArrayList<Tour>();
		this.scorePartie=0;
	}
	
	
	/**
	 * Cette méthode doit être appelée à chaque lancer de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de ce lancer
	 * @throws IllegalStateException si la partie est terminée
	 * @return vrai si le joueur doit lancer à nouveau pour continuer son tour, faux sinon	
	 */
	public boolean enregistreLancer(int nombreDeQuillesAbattues) {
		if (this.estTerminee())
			throw new IllegalStateException();
			
		Boolean bo = null;
		
		Lance lance=new Lance(nombreDeQuillesAbattues);
		if (lesTours.get(numeroTourCourant()).nbLance()==2){ // changer pour strike
			Tour tour = new Tour();
			lesTours.add(tour);
			tour.addLance(lance);
			bo= true;
		} else {
			lesTours.get(numeroTourCourant()).addLance(lance);
			//on aura jamais le cas ou tour cree mais vide
			bo = false;
		}
		
		return bo;
		
	}

	/**
	 * Cette méthode donne le score du joueur.
	 * Si la partie n'est pas terminée, on considère que les lancers restants
	 * abattent 0 quille.
	 * @return Le score du joueur
	 */
	
	public int score() {
		int scoreTot=0;
		
		for (Tour tour : lesTours){
			if (tour.estUnSpare())
				
			if (tour.estUnStrike()){
				
			}else {
				scoreTot+=tour.scoreTour();
			}
		}
		return scoreTot;
	}

	/**
	 * @return vrai si la partie est terminée pour ce joueur, faux sinon
	 */
	public boolean estTerminee() {
		Boolean bo = false;
		if (lesTours.size()==10)
			bo=true;
		return bo;
    }


	/**
	 * @return Le numéro du tour courant [1..10], ou 0 si le jeu est fini
	 */
	public int numeroTourCourant() {
		return lesTours.size();
	}

	/**
	 * @return Le numéro du prochain lancer pour tour courant [1..3], ou 0 si le jeu
	 *         est fini
	 */
	public int numeroProchainLancer() {
		throw new UnsupportedOperationException("Pas encore implémenté");
	}

}
