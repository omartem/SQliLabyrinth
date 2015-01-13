package com.nespresso.sofa.recruitment.labyrinth.doors;

import com.nespresso.sofa.recruitment.labyrinth.rooms.Room;
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
	
	@Override
	public boolean thisIsYourCode() {
		return false;
	}
	
	@Override
	public boolean canYouGoToThisRoom(String roomCode) {
		return firstRoom.thisIsYou(roomCode) || secondRoom.thisIsYou(roomCode);
	}
	
	public void close() {
		this.state = LabyrinthDoorStat.CLOSE;
	}

	public void setFirstRoom(Room firstRoom) {
		this.firstRoom = firstRoom;
	}

	public void setSecondRoom(Room secondRoom) {
		this.secondRoom = secondRoom;
	}
	
}
