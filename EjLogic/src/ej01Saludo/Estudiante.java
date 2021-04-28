package ej01Saludo;

public class Estudiante {
	private String lastName;
	private String career;
	private String level;
	/**
	 * @param lastName
	 * @param career
	 * @param level
	 */
	public Estudiante(String lastName, String career, String level) {
		this.lastName = lastName;
		this.career = career;
		this.level = level;
	}
	
	public Estudiante() {
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	public void saludaA1() {
		System.out.println("Hello, Mr. " + this.getLastName());
	}
	
	public void saludaA2() {
		System.out.println("Hello, Mr. " + this.getLastName() + " ¿whitch is your level?");
	}
	
	public void saludoDe1() {
		System.out.println("Hello, professor.");
	}
	
	public void saludoDe2() {
		System.out.println("Hello, professor. I'm in " + this.getLevel() + " degree.");
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	
	
	
	
	

}
