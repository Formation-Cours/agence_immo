package fr.webforce;

import fr.webforce.entities.AdresseEntity;
import fr.webforce.entities.BienEntity;
import fr.webforce.entities.TypeEntity;
import fr.webforce.enums.TypeEnum;
import fr.webforce.services.AdresseService;
import fr.webforce.services.BienService;
import fr.webforce.services.TypeService;

import java.util.Optional;

/*
1. Une recherche de bien(s) par son type.
2. Une recherche de bien(s) par la ville
3. Une recherche de bien(s) par son prix
4. Une insertion d’un bien avec son adresse
5. Une mise à jour du bien et/ou son adresse
6. Une suppression d’un bien après une recherche de celui-ci
 */
public class Main {
	public static void main(String[] args) {
//		q4InsertBienEtAdresse();
	}

	private static void q4InsertBienEtAdresse() {
		// Question 4
		AdresseEntity ad = new AdresseEntity(null, 12, "rue sans pavé", "59560", "Comines");
		TypeEntity type = new TypeEntity(null, TypeEnum.MAISON);
		BienEntity bien = new BienEntity(null, 4, 115, 500_000, 1961, true,
				false, false, true, type, ad);

		AdresseService adresseService = new AdresseService();
		adresseService.insert(ad);

		TypeService typeService = new TypeService();
		typeService.insert(type);

		BienService bienService = new BienService();
		Optional<Integer> nb = bienService.insert(bien);
		if (nb.isPresent()){
			if (nb.get() > 0){
				System.out.println("Félicitations, tout s'est correctement déroulé!");
			}
		}
	}
}
