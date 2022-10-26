package fr.webforce;

import fr.webforce.services.BienService;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		BienService bienService = new BienService();
		bienService.findAll();
	}
}