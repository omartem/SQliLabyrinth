package com.nespresso.sofa.recruitment.labyrinth.validators;

/**
 *
 * @author Ouadie LAHDIOUI <olahdioui@sqli.com, ouadiesoft@gmail.com>
 *
 *         Mon nouveau design pattern VALIDATOR est une sorte d'implémentation du design pattern observer
 */
public interface LabyrinthValidable
{
	/**
	 * Ajouter un validateur labyrinth
	 *
	 * @param validator
	 */
	void addValidator(final LabyrinthValidator validator);

	/**
	 * Supprimer un validateur labyrinth
	 *
	 * @param validator
	 */
	void removeValidator(final LabyrinthValidator validator);

	/**
	 * Le comportement de le validation d'un couple de chambre
	 *
	 * @param pairRoom
	 * @return valide ou non
	 */
	boolean validat(final String pairRoom);
}
