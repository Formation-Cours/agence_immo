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
}
