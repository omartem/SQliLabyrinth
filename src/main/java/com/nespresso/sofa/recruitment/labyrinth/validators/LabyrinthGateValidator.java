package com.nespresso.sofa.recruitment.labyrinth.validators;

import static com.nespresso.sofa.recruitment.labyrinth.tools.LabyrinthConstants.SENSOR_GATE_SEPARATOR;
import static com.nespresso.sofa.recruitment.labyrinth.tools.LabyrinthConstants.SIMPLE_GATE_SEPARATOR;

import org.apache.commons.lang.StringUtils;


/**
 *
 * @author Ouadie LAHDIOUI <olahdioui@sqli.com, ouadiesoft@gmail.com>
 *
 *         Mon nouveau design pattern VALIDATOR est une sorte d'implémentation du design pattern observer
 */
public class LabyrinthGateValidator implements LabyrinthValidator
{

	@Override
	public boolean validat(final String pairRoom)
	{
		boolean isValidPairRoom = false;

		if (StringUtils.isNotBlank(pairRoom) && pairRoom.length() > 1)
		{
			isValidPairRoom = true;

			for (int i = 1; i < pairRoom.length(); i = i + 2)
			{
				if (!SIMPLE_GATE_SEPARATOR.equals(String.valueOf(pairRoom.charAt(i))) && !SENSOR_GATE_SEPARATOR.equals(String.valueOf(pairRoom.charAt(i))))
				{
					isValidPairRoom = false;
				}
			}

		}

		return isValidPairRoom;
	}
}
