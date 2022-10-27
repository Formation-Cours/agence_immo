package fr.webforce.entities;

import fr.webforce.enums.TypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeEntity {
	private Long id;
	private TypeEnum nom;

	public void setEnum(String nom) {
		this.nom = switch (nom) {
			case "maison" -> TypeEnum.MAISON;
			case "appartement" -> TypeEnum.APPARTEMENT;
			case "chateau" -> TypeEnum.CHATEAU;
			case "terrain" -> TypeEnum.TERRAIN;
			case "garage" -> TypeEnum.GARAGE;
			default -> null;
		};
	}
}
