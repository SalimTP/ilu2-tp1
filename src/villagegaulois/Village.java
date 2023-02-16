package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private Marche marche;

	public Village(String nom, int nbVillageoisMaximum, int nbEtals) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		marche = new Marche(nbEtals);
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les lÃ©gendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	
	// Deuxième partie TP
	
	public String installerVendeur(Gaulois vendeur, String produit,int nbProduit) {
		StringBuilder chaine2 = new StringBuilder();
		
		
		return chaine2.toString();
		
	}
	
	// Classe interne Marche (Première partie TP)
	private static class Marche {
		private Etal[] etals;

	    public Marche(int nbEtals) {
	    	etals = new Etal[nbEtals];
	    	
	    	for(int i = 0; i < etals.length; i++) {
		    	etals[i] = new Etal();
	    	}
	    }
	    
	    public void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
	    	Etal etal = etals[indiceEtal];
            etals[indiceEtal] = etal;
            System.out.println(vendeur.getNom() + " s'est installé à l'étal " + indiceEtal + ".");        
	    }	
	    
	    public int trouverEtalLibre() {
            for (int i = 0; i < etals.length; i++) {
                if (!(etals[i].isEtalOccupe())) {
                    return i;
                }
            }
            return -1;
        }
	    
	    public Etal[] trouverEtals(String produit) {
            int nbEtalsProduit = 0;
            for (int i = 0; i < etals.length; i++) {
                Etal etal = etals[i];
                if (etal.contientProduit(produit)) {
                    nbEtalsProduit++;
                }
                
            }
            Etal[] etalsProduit = new Etal[nbEtalsProduit];
            int j = 0;
            for (int i = 0; i < etals.length; i++) {
                Etal etal = etals[i];
                if (etal.contientProduit(produit)) {
                    etalsProduit[j] = etal;
                    j++;
                }
            }
            return etalsProduit;
        }
	    
	    public Etal trouverVendeur(Gaulois gaulois) {
            for (Etal etal : etals) {
                if (etal.getVendeur() == gaulois) {
                    return etal;
                }
            }
            return null;
        }	   
	}	
}