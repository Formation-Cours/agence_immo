package fr.webforce;

import fr.webforce.entities.AdresseEntity;
import fr.webforce.entities.BienEntity;
import fr.webforce.entities.TypeEntity;
import fr.webforce.enums.TypeEnum;
import fr.webforce.services.AdresseService;
import fr.webforce.services.BienService;
import fr.webforce.services.TypeService;

import java.util.Optional;
import java.util.Scanner;

/*
1. Une recherche de bien(s) par son type.
2. Une recherche de bien(s) par la ville
3. Une recherche de bien(s) par son prix
4. Une insertion d’un bien avec son adresse
5. Une mise à jour du bien et/ou son adresse
6. Une suppression d’un bien après une recherche de celui-ci
 */
public class Main {
	private static AdresseService adresseService = new AdresseService();
	private static TypeService typeService = new TypeService();
	private static BienService bienService = new BienService();

	public static void main(String[] args) {
//		q4InsertBienEtAdresse();
//		findAll();
//		findByType();
//		findByTown();
//		findByPrice();

		var all = bienService.findAll();
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < all.size(); i++) {
			AdresseEntity a = all.get(i).getAdresse();
			System.out.printf("%d : %d %s %s %s%n", i+1, a.getNum(), a.getRue(), a.getCp(), a.getVille());
		}
		int choix = sc.nextInt();
		BienEntity b = all.get(choix-1);
		bienService.delete(b.getId());
	}

	private static void findByType() {
		// Question 1
		var all = bienService.findByType("iso");
		System.out.println(all);
	}
	private static void findByTown() {
		// Question 2
		var all = bienService.findByTown("maubeuge");
		System.out.println(all);
	}
	private static void findByPrice() {
		// Question 3
		var all = bienService.findByPrice(170_000, 0.2);
		System.out.println(all);
	}
	private static void findAll() {
		var all = bienService.findAll();
		System.out.println(all);
	}

	private static void q4InsertBienEtAdresse() {
		// Question 4
		AdresseEntity ad = new AdresseEntity(null, 12, "rue sans pavé", "59560", "Comines");
		TypeEntity type = new TypeEntity(null, TypeEnum.MAISON);
		BienEntity bien = new BienEntity(null, 4, 115, 500_000, 1961, true,
				false, false, true, type, ad);


		adresseService.insert(ad);

		typeService.insert(type);

		Optional<Integer> nb = bienService.insert(bien);
		if (nb.isPresent()) {
			if (nb.get() > 0) {
				System.out.println("Félicitations, tout s'est correctement déroulé!");
			}
		}
	}
}
