package com.nespresso.sofa.recruitment.labyrinth;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.nespresso.sofa.recruitment.labyrinth.exceptions.IllegalMoveException;
import com.nespresso.sofa.recruitment.labyrinth.rooms.Room;
import com.nespresso.sofa.recruitment.labyrinth.rooms.RoomFactory;


/**
 *
 * @author Ouadie LAHDIOUI <olahdioui@sqli.com, ouadiesoft@gmail.com>
 *
 */
public class Labyrinth implements Ilabyrinth
{
	
	/**
	 * Les champbres du labyrinthe
	 */
	List<Room> rooms = new ArrayList<Room>();
	
	/**
	 * Le joueur de la labyrinthe
	 */
	private Player player;
	
	/**
	 * Constructeur par défaut du labyrinthe
	 */
	public Labyrinth()
	{
		super();
	}

	/**
	 * Constructeur avec des rooms du labyrinthe
	 *
	 * @param rooms
	 */
	public Labyrinth(final String... roomArgs)
	{
		rooms = RoomFactory.buildRooms(roomArgs);

		player = new Player();
	}

	/**
	 * Posisioner un joueur dans une chambre
	 */
	@Override
	public void popIn(final String room)
	{
		if(StringUtils.isNotBlank(room)) {
			player.setCurrentRoom(new Room(room));
		}
	}

	@Override
	public void walkTo(final String toRoomCode)
	{
		for (Room toRoom : rooms) {
			if(toRoom.thisIsYou(toRoomCode)) {
				Room walkerCurrentRoom = this.player.getCurrentRoom();
				if(walkerCurrentRoom != null) {
					if(walkerCurrentRoom.hasDoorToRoom(toRoomCode)){
						this.player.setCurrentRoom(toRoom);
					}else{
						throw new IllegalMoveException("Sorry, You can't go to this room :(");
					}
				}
			}
		}
	}

	/**
	 * Fermer la dernière porte
	 */
	@Override
	public void closeLastDoor()
	{
		this.player.closeLastDoor();
	}

	@Override
	public String readSensors()
	{
		return "";
	}

}
