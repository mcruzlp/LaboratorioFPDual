package EjPlanetas;

public enum Planeta {
	MERCURIO(true, false, false, 57.91),
	VENUS(true, true, false, 108.2),
	TIERRA(true, true, true, 149.6),
	MARTE(true, true, false, 227.9),
	JUPITER(false, true, false, 778.5),
	SATURNO(false, true, false, 1434.00),
	URANO(false, true, false, 2871.00),
	NEPTUNO(false, true, false, 4495.00),
	PLUTON(false, true, false, 59064.00);
	
	private boolean isInsideAsteroidsRing;
	private boolean hasAnAtmosphere;
	private boolean isHabitable;
	private float distanceFromSun;
	
	/**
	 * @param isInsideAsteroidsRing
	 * @param hasAnAtmosphere
	 * @param isHabitable
	 * @param distanceFromSun
	 */
	
	private Planeta(boolean isInsideAsteroidsRing, boolean hasAnAtmosphere, boolean isHabitable, float distanceFromSun) {
		this.isInsideAsteroidsRing = false;
		this.hasAnAtmosphere = false;
		this.isHabitable = false;
		this.distanceFromSun = distanceFromSun;
	}
	
	/**
	 * @return the isHabitable
	 */
	public boolean isHabitable() {
		return isHabitable;
	}

	/**
	 * @param isHabitable the isHabitable to set
	 */
	public void setHabitable(boolean isHabitable) {
		this.isHabitable = isHabitable;
	}
	
	/**
	 * @return the isInsideAsteroidsRing
	 */
	
	public boolean isInsideAsteroidsRing() {
		return isInsideAsteroidsRing;
	}
	
	/**
	 * @param isInsideAsteroidsRing the isInsideAsteroidsRing to set
	 */
	
	public void setInsideAsteroidsRing(boolean isInsideAsteroidsRing) {
		this.isInsideAsteroidsRing = isInsideAsteroidsRing;
	}
	
	/**
	 * @return the hasAnAtmosphere
	 */
	
	public boolean isHasAnAtmosphere() {
		return hasAnAtmosphere;
	}
	
	/**
	 * @param hasAnAtmosphere the hasAnAtmosphere to set
	 */
	
	public void setHasAnAtmosphere(boolean hasAnAtmosphere) {
		this.hasAnAtmosphere = hasAnAtmosphere;
	}
	
	/**
	 * @return the distanceFromSun
	 */
	
	public float getDistanceFromSun() {
		return distanceFromSun;
	}
	
	/**
	 * @param distanceFromSun the distanceFromSun to set
	 */
	
	public void setDistanceFromSun(int distanceFromSun) {
		this.distanceFromSun = distanceFromSun;
	}
	
	@Override
	public String toString() {
		if (this.isInsideAsteroidsRing == true) {
			if (this.hasAnAtmosphere == true) {
				return "Este planeta está en el anillo de asteroides, tiene atmósfera y la distancia hasta "
						+ "el sol es de: " + distanceFromSun + "km.";
			} else return "Este planeta, está en el anillo de asteroides, no tiene atmósfera y la distancia "
					+ "hasta el sol es de: " + distanceFromSun + "km.";
		} else {
			if (this.hasAnAtmosphere == true) {
				return "Este planeta no está en el anillo de asteroides, tiene atmósfera y la distancia hasta"
						+ " el sol es de: " + distanceFromSun + "km.";
			} else return "Este planeta no está en el anillo de asteroides, no tiene atmósfera y la distancia "
					+ "hasta el sol es de: " + distanceFromSun + "km.";
		}
		
	}
}
