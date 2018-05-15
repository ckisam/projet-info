package fr.sam.core.world.manager;

import java.util.Random;

/**
 * Generateur de nombres aléatoires
 * 
 * @author Samuel
 *
 */
public class NumberGenerator {

	private static volatile NumberGenerator generator;

	private NumberGenerator() {
		super();
	}

	public static NumberGenerator getInstance() {
		if (generator == null) {
			synchronized (NumberGenerator.class) {
				if (generator == null) {
					generator = new NumberGenerator();
				}
			}
		}
		return (generator);
	}

	/**
	 * Retourne un nombre compris entre le minimum et le maximum (inclus)
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public int tireEntreMinEtMax(int min, int max) {
		return (new Random().nextInt(max - min + 1) + min);
	}

}
