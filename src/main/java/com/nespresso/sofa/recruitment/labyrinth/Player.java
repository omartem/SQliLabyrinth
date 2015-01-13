package com.nespresso.sofa.recruitment.labyrinth;

import com.nespresso.sofa.recruitment.labyrinth.doors.AbstractDoor;
import com.nespresso.sofa.recruitment.labyrinth.rooms.Room;



/**
 *
 * @author Ouadie LAHDIOUI <olahdioui@sqli.com, ouadiesoft@gmail.com>
 *
 */
public class Player
{
	/**
	 * La chambre actuelle du walker
	 */
	private Room currentRoom;
	private AbstractDoor lastDoor;

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}


	public void closeLastDoor() {
		if (this.lastDoor != null) {
			this.lastDoor.close();
		}
	}

}
