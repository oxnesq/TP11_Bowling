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
		for (int i = 0; i < 9; i++) {
			Tour tour = new Tour();
			lesTours.add(tour);
		}
		DernierTour dernierTour = new DernierTour();
		lesTours.add(dernierTour);
		this.scorePartie = 0;
		
	}

	public DernierTour getDernierTour() {
		for (Tour tour : lesTours) {
			if (tour instanceof DernierTour) {
				return (DernierTour) tour;
			}
		}
		return null;
	}

	/**
	 * Cette méthode doit être appelée à chaque lancer de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de ce lancer
	 * @return vrai si le joueur doit lancer à nouveau pour continuer son tour, faux sinon
	 * @throws IllegalStateException si la partie est terminée
	 */
	public boolean enregistreLancer(int nombreDeQuillesAbattues) {
		if (estTerminee()) {
			throw new IllegalStateException("Partie terminée");
		}
		//System.out.println(numeroTourCourant());
		/*for (Tour t : lesTours){
			System.out.println(t);
		}*/
		tourCourant().addLance(nombreDeQuillesAbattues);


		Boolean bo = false;
		if (numeroProchainLancer() == 2 || numeroProchainLancer() == 3)
			bo = true;
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
		int limite = numeroTourCourant()-1;
		if (estTerminee()) {
			limite = lesTours.size() - 2;
		}
		for (int i = 0; i <= limite; i++) {
			System.out.println("dans la boucle");
			// spare
			if (lesTours.get(i).estUnSpare()) {
				System.out.println("spare");
				System.out.println(lesTours.get(i));
				scoreTot += score2ToursSpare(lesTours.get(i), lesTours.get(i + 1));
			} else if (lesTours.get(i).getLance1().estUnStrike()) {
				//strike
				if (i < limite - 2) {
					scoreTot += score2toursStrike(lesTours.get(i), lesTours.get(i + 1), lesTours.get(i + 2));
				} else if (i < limite-1) {
					if (lesTours.get(i+1).getLance1().estUnStrike()) {
						scoreTot += 10 + 10 + getDernierTour().getLance1().getNombreGuillesAbattues();
					} else {
						scoreTot += 10 + lesTours.get(i+1).scoreTour();
					}
				} else {
					scoreTot+=10+ getDernierTour().scoreTour();
				}

			} else {
				// autre
				System.out.println("tour normal");
				scoreTot += lesTours.get(i).scoreTour();
			}
			System.out.println(scoreTot);
		}
		if (getDernierTour().estTermine()) {
			scoreTot += getDernierTour().scoreDernierTour();
		}
		return scoreTot;
	}

	public int score2ToursSpare(Tour t, Tour tsuivant) {
		return 10 + Math.max(0, tsuivant.getLance1().getNombreGuillesAbattues());

	}

	public int score2toursStrike(Tour t, Tour tsuivant, Tour t3) {
		int scoreFinalTour = 0;
		if (tsuivant.getLance1().estUnStrike()) {
			scoreFinalTour = 10 + 10 + t3.getLance1().getNombreGuillesAbattues();
		} else {
			scoreFinalTour = 10 + tsuivant.scoreTour();
		}
		return scoreFinalTour;
	}

	/**
	 * @return vrai si la partie est terminée pour ce joueur, faux sinon
	 */
	public boolean estTerminee() {
		Boolean bo = false;
		if (getDernierTour().estTermine())
			bo = true;
		return bo;
	}


	/**
	 * @return Le numéro du tour courant [1..10], ou 0 si le jeu est fini
	 */
	public int numeroTourCourant() {
		int i = 1;
		if (estTerminee())
			return 0;
		for (Tour tour : lesTours) {
			if (tour.estTermine()) {
				i += 1;
			}

		}
		return i;
	}

	public Tour tourCourant() {
		return lesTours.get(numeroTourCourant() - 1);
	}

	/**
	 * @return Le numéro du prochain lancer pour tour courant [1..3], ou 0 si le jeu
	 * est fini
	 */
	public int numeroProchainLancer() {
		int numProchainLance = -1;
		//si partie finie alors pas de num prochain lancer
		if (estTerminee()) {
			return 0;
		} else if (!tourCourant().estTermine()) {
			numProchainLance = tourCourant().nbLance() + 1;
		} else {
			numProchainLance = 1;
		}
		return numProchainLance;


	}
}