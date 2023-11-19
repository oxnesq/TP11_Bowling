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
		for (int i=0;i<9;i++){
			Tour tour = new Tour();
			lesTours.add(tour);
		}
		DernierTour tour = new DernierTour();
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
		/*
		if (this.estTerminee()) {
			throw new IllegalStateException("Partie terminée");
		}
		

		Lance lance = new Lance(nombreDeQuillesAbattues);
		tourCourant().addLance(lance);

		if (numeroProchainLancer() == 1) {
			Tour tour = new Tour();
			lesTours.add(tour);
		}
*/
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
		/*
		for (int i = 0; i < lesTours.size(); i++) {
			if (i < lesTours.size() - 2) { /// A CHANGER
				scoreTot += score2Tours(lesTours.get(i), lesTours.get(i + 1), lesTours.get(i + 2));
			} else if (i < lesTours.size() - 1) {
				scoreTot += score2Tours(lesTours.get(i), lesTours.get(i + 1), null);
			} else {
				scoreTot += lesTours.get(i).scoreTour();
			}
			System.out.println(scoreTot);
		}*/
		return scoreTot;
	}

	public int score2Tours(Tour t, Tour tsuivant, Tour t3) {
		int scoreFinalTour = 0;/*
		//spare : 10+ pts 1er lancé tour suivant
		if (t.estUnSpare()) {
			scoreFinalTour = 10 + tsuivant.getLance(0).getNombreGuillesAbattues();
		} else if (t.estUnStrike()) {
			// strike : 10+ pts 2 prochains lances
			if (tsuivant.estUnStrike()) {
				if (t3 != null) {
					scoreFinalTour = 10 + 10 + t3.getLance(0).getNombreGuillesAbattues();
				} else {
					//si les deux derniers tours sont des strikes 10+10
					scoreFinalTour = 10 + 10;

				}

				
			} else {
				System.out.println("On passe ici");
				scoreFinalTour = 10 + 10 + 10;
			}
			
				 
			} else {
				scoreFinalTour = tsuivant.scoreTour();
			}}
			*/
			return scoreFinalTour;
		
	}

	/**
	 * @return vrai si la partie est terminée pour ce joueur, faux sinon
	 */
	public boolean estTerminee() {
		Boolean bo = false;
		/*
		//if (numeroProchainLancer()==0)
		if (lesTours.size() >= 10 &&
			(tourCourant().nbLance() == 3 ||
				(!tourCourant().estUnStrike() && !tourCourant().estUnSpare() && tourCourant().nbLance() == 2)))
			bo = true;*/
		return bo;
	}


	/**
	 * @return Le numéro du tour courant [1..10], ou 0 si le jeu est fini
	 */
	public int numeroTourCourant() {
		int i =0;
		for (Tour tour : lesTours){
			if (!tour.estTermine())
				i=tour.getNumTour();
		}
		if (estTerminee())
			i = 0;
		return i;
	}

	public Tour tourCourant() {
		return lesTours.get(lesTours.size() - 1);
	}

	/**
	 * @return Le numéro du prochain lancer pour tour courant [1..3], ou 0 si le jeu
	 * est fini
	 */
	public int numeroProchainLancer() {
		int numProchainLance = -1;
		/*
		//si partie finie alors pas de num prochain lancer
		if (numeroTourCourant() == 0)
			return 0;
		//si num de ce lancer est 0 alors tour sans lancer => prochain =1
		if (tourCourant().nbLance() == 0)
			numProchainLance = 1;
		//pour tous les tours "normaux"
		if (numeroTourCourant() < 10) {
			if (tourCourant().nbLance() == 1) {
				// si le num de lancer est 1 alors soit c'est un strike et nv tour soit lancer 2
				if (tourCourant().estUnStrike()) {
					numProchainLance = 1;
				} else {
					numProchainLance = 2;
				}
			} else if (tourCourant().nbLance() == 2) {
				// si le lancer actuel est le deuxieme alors tour finit
				numProchainLance = 1;
			}
		} else if (numeroTourCourant() == 10) {
			// pour le dernier tour il y a le bonus ou fin de partie donc diff
			if (tourCourant().nbLance() == 1) {
				numProchainLance = 2;
			} else if (tourCourant().nbLance() == 2) {
				if (tourCourant().estUnSpare() || tourCourant().estUnStrike()) {
					// si strike ou spare alors 3eme lance
					numProchainLance = 3;
				} else {
					numProchainLance = 0;
				}
			} else if (tourCourant().nbLance() == 3) {
				//si 3eme lance alors fin de partie
				numProchainLance = 0;
			}
		}*/
		return numProchainLance;


	}
}