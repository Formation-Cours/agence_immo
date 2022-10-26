package fr.webforce.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class BienEntity {
	@NonNull private Long id;
	@NonNull private Byte nbPieces;
	@NonNull private Short surface;
	@NonNull private Long prix;
	@NonNull private Short annee;
	@NonNull private Boolean garage;
	@NonNull private Boolean terrase;
	@NonNull private Boolean balcon;
	@NonNull private Boolean jardin;
	private TypeEntity type;
	private AdresseEntity adresse;
}
