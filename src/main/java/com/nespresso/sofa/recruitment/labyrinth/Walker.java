package com.nespresso.sofa.recruitment.labyrinth;



/**
 *
 * @author Ouadie LAHDIOUI <olahdioui@sqli.com, ouadiesoft@gmail.com>
 *
 */
public class Walker
{
	/**
	 * La chambre actuelle du walker
	 */
	private Room currentRoom;

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

}
