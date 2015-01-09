package com.nespresso.sofa.recruitment.labyrinth.validators;

import org.apache.commons.lang.StringUtils;



/**
 *
 * @author Ouadie LAHDIOUI <olahdioui@sqli.com, ouadiesoft@gmail.com>
 *
 *         Mon nouveau design pattern VALIDATOR est une sorte d'implémentation du design pattern observer
 */
public class LabyrinthNotPairValidator implements LabyrinthValidator
{

	@Override
	public boolean validat(final String pairRoom)
	{
		boolean isValidPairRoom = false;

		if (StringUtils.isNotBlank(pairRoom) && pairRoom.length() > 1 && (pairRoom.length() % 2) != 0)
		{
			isValidPairRoom = true;
		}

		return isValidPairRoom;
	}

}
