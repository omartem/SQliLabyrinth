package com.nespresso.sofa.recruitment.labyrinth;

import com.nespresso.sofa.recruitment.labyrinth.exceptions.IllegalMoveException;


/**
 *
 * @author Ouadie LAHDIOUI <olahdioui@sqli.com, ouadiesoft@gmail.com>
 *
 */
public interface Ilabyrinth
{
	/**
	 *
	 * @param room
	 * @throws IllegalMoveException
	 */
	void popIn(String room);

	/**
	 *
	 * @param room
	 */
	void walkTo(String room);

	/**
	 *
	 * @param closeLastDoor
	 */
	void closeLastDoor();

	/**
	 * @return
	 *
	 */
	String readSensors();


}
