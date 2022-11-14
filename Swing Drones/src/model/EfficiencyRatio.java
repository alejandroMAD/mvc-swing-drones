package model;

/**
 * <p>Constants defining efficiency ratios for drones batteries performance.</p>
 * <p>Drones move at speeds between 1-5 and their battery consumption per timer delay
 * can be calculated with the formula:</p>
 * 
 * <p>(drone xVelocity / 100) * (1 - efficiencyRatio)</p>
 * 
 * <p>The PERFECT efficiency should belong to a renewable-energy perpetuum mobile
 * dron yet to be invented.
 * 
 * @author Alejandro M. González
 *
 * 
 */
public enum EfficiencyRatio {
	
	LOW (0.25),
	MEDIUM (0.5),
	HIGH (0.75),
	PERFECT (1);
	
	private final double ratio;
	
	private EfficiencyRatio(double ratio) {
		this.ratio = ratio;
	}

	/**
	 * Returns the efficiency ratio value corresponding to the specified constant name.
	 * 
	 * @return the efficiency ratio as a double type
	 */
	public double getRatio() {
		return ratio;
	}
	
	/**
	 * Returns the constant name corresponding to the specified efficiency ratio value.
	 * 
	 * @param ratio the efficiency ratio value.
	 * @return A String with the name of the constant corresponding to the provided ratio value.
	 */
	public static String getRatioName(double ratio) {
		for (EfficiencyRatio efficiencyRatio : EfficiencyRatio.values()) {
			if (efficiencyRatio.getRatio() == ratio) {
				return efficiencyRatio.name();
			}
		}
		return null;
	}
}

