package edu.laboratoriofpdual.clinicaweb.servlet.myexceptions;

public class UserAlreadyExistException extends Exception {

	public UserAlreadyExistException() {
		System.out.println("Este usuario ya existe.");
	}

}
