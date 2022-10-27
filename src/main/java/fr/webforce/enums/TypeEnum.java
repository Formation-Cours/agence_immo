package fr.webforce.enums;

public enum TypeEnum {

	MAISON("maison"),
	APPARTEMENT("appartement"),
	CHATEAU("chateau"),
	TERRAIN("terrain"),
	GARAGE("garage");
	private String name;

	TypeEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "TypeEnum{" +
				"name='" + name + '\'' +
				'}';
	}
}
