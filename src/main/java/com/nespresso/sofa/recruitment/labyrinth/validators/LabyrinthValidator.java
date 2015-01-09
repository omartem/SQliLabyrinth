package com.nespresso.sofa.recruitment.labyrinth.validators;

/**
 *
 * @author Ouadie LAHDIOUI <olahdioui@sqli.com, ouadiesoft@gmail.com>
 *
 *         Mon nouveau design pattern VALIDATOR est une sorte d'implémentation du design pattern observer
 */
public interface LabyrinthValidator
{
	/**
	 * Valider un couple de chambres
	 *
	 * @param pairRoom
	 * @return valide ou non
	 */
	boolean validat(String pairRoom);
}
