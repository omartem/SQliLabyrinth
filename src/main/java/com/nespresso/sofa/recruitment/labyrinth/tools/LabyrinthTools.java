package com.nespresso.sofa.recruitment.labyrinth.tools;

import java.util.ArrayList;
import java.util.List;

import com.nespresso.sofa.recruitment.labyrinth.validators.LabyrinthValidable;
import com.nespresso.sofa.recruitment.labyrinth.validators.LabyrinthValidator;



/**
 *
 * @author Ouadie LAHDIOUI <olahdioui@sqli.com, ouadiesoft@gmail.com>
 *
 *         Une Classe utilitaire et qui joue le rôle d'un concretValidable dans mon pattern Validator
 */
public class LabyrinthTools implements LabyrinthValidable
{

	private final List<LabyrinthValidator> validators = new ArrayList<LabyrinthValidator>();

	@Override
	public void addValidator(final LabyrinthValidator validator)
	{
		if (validator != null)
		{
			validators.add(validator);
		}
	}

	@Override
	public void removeValidator(final LabyrinthValidator validator)
	{
		if (validator != null)
		{
			validators.remove(validator);
		}
	}

	@Override
	public boolean validat(final String pairRoom)
	{
		for (final LabyrinthValidator labyrinthValidator : validators)
		{
			if (!labyrinthValidator.validat(pairRoom))
			{
				return false;
			}
		}
		return true;
	}
}
