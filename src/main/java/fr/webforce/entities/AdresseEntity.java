package fr.webforce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdresseEntity {
	private Long id;
	private Integer num;
	private String rue;
	private String cp;
	private String ville;
}
