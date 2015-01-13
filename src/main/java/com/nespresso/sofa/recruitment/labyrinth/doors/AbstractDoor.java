package com.nespresso.sofa.recruitment.labyrinth.doors;

import com.nespresso.sofa.recruitment.labyrinth.Room;
import com.nespresso.sofa.recruitment.labyrinth.tools.LabyrinthDoorStat;

/**
 *
 * @author Ouadie LAHDIOUI <olahdioui@sqli.com, ouadiesoft@gmail.com>
 * 
 */
public abstract class AbstractDoor implements IDoor
{
	/**
	 * La première chambre
	 */
	private Room firstRoom;
	
	/**
	 * La deuxième chambre
	 */
	private Room secondRoom;
	
	/**
	 * L'état de la porte
	 */
	private LabyrinthDoorStat state;
	
	public Room getFirstRoom() {
		return firstRoom;
	}

	public Room getSecondRoom() {
		return secondRoom;
	}

	public LabyrinthDoorStat getState() {
		return state;
	}

	public void setState(LabyrinthDoorStat state) {
		this.state = state;
	}

	public void setFirstRoom(Room firstRoom) {
		this.firstRoom = firstRoom;
	}

	public void setSecondRoom(Room secondRoom) {
		this.secondRoom = secondRoom;
	}
	
}
