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
		this.lesTours = new ArrayList<Tour>();
		Tour tour1 = new Tour();
		lesTours.add(tour1);
		this.scorePartie = 0;
	}

	/**
	 * Cette méthode doit être appelée à chaque lancer de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de ce lancer
	 * @return vrai si le joueur doit lancer à nouveau pour continuer son tour, faux sinon
	 * @throws IllegalStateException si la partie est terminée
	 */
	public boolean enregistreLancer(int nombreDeQuillesAbattues) {
		if (this.estTerminee())
			throw new IllegalStateException();

		Lance lance = new Lance(nombreDeQuillesAbattues);
		tourCourant().addLance(lance);
		
		if (numeroProchainLancer() == 1) {
			Tour tour = new Tour();
			lesTours.add(tour);
		}
		Boolean bo = false;
		if (numeroProchainLancer()==2 ||numeroProchainLancer()==3 )
			bo=true;

		return bo;

	}

	/**
	 * Cette méthode donne le score du joueur.
	 * Si la partie n'est pas terminée, on considère que les lancers restants
	 * abattent 0 quille.
	 *
	 * @return Le score du joueur
	 */

	public int score() {
		int scoreTot = 0;
		/*
		for (Tour tour : lesTours){
			if (tour.estUnSpare())
				
			if (tour.estUnStrike()){
				
			}else {
				scoreTot+=tour.scoreTour();
			}
		}*/
		return scoreTot;
	}

	/**
	 * @return vrai si la partie est terminée pour ce joueur, faux sinon
	 */
	public boolean estTerminee() {
		Boolean bo = false;
		if (numeroProchainLancer() == 0)
			bo = true;
		return bo;
	}


	/**
	 * @return Le numéro du tour courant [1..10], ou 0 si le jeu est fini
	 */
	public int numeroTourCourant() {
		return lesTours.size();
	}

	public Tour tourCourant() {
		return lesTours.get(numeroTourCourant()-1);
	}

	/**
	 * @return Le numéro du prochain lancer pour tour courant [1..3], ou 0 si le jeu
	 * est fini
	 */
	public int numeroProchainLancer() {
		int nb = -1;
		if (tourCourant().nbLance() == 0)
			nb = 1;
		if (numeroTourCourant() < 10) {
			if (tourCourant().nbLance() == 1) {
				if (tourCourant().estUnStrike()) {
					nb = 1;
				} else {
					nb = 2;
				}
			} else if (tourCourant().nbLance() == 2) {
				nb = 1;
			}
		} else if (numeroTourCourant() == 10) {
			if (tourCourant().nbLance() == 1) {
				nb = 2;
			} else if (tourCourant().nbLance() == 2) {
				if (tourCourant().estUnSpare() || tourCourant().estUnStrike()) {
					nb = 3;
				} else {
					nb = 0;
				}
			}
		}
		return nb;


	}
}