package fr.webforce.entities;

import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class BienEntity {
	private Long id;
	@NonNull private Integer nbPieces;
	@NonNull private Integer surface;
	@NonNull private Integer prix;
	@NonNull private Integer annee;
	@NonNull private Boolean garage;
	@NonNull private Boolean terrase;
	@NonNull private Boolean balcon;
	@NonNull private Boolean jardin;
	private TypeEntity type;
	private AdresseEntity adresse;
}
