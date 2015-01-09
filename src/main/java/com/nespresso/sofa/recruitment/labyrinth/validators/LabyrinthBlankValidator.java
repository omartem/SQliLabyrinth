package com.nespresso.sofa.recruitment.labyrinth.validators;

import org.apache.commons.lang.StringUtils;



/**
 *
 * @author Ouadie LAHDIOUI <olahdioui@sqli.com, ouadiesoft@gmail.com>
 *
 *         Mon nouveau design pattern VALIDATOR est une sorte d'implémentation du design pattern observer
 */
public class LabyrinthBlankValidator implements LabyrinthValidator
{

	@Override
	public boolean validat(final String pairRoom)
	{
		return StringUtils.isNotBlank(pairRoom);
	}

}
