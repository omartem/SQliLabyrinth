package com.nespresso.sofa.recruitment.labyrinth.rooms;

import java.util.ArrayList;
import java.util.List;

import com.nespresso.sofa.recruitment.labyrinth.doors.AbstractDoor;



/**
 *
 * @author Ouadie LAHDIOUI <olahdioui@sqli.com, ouadiesoft@gmail.com>
 *
 */
public class Room
{
	private String code;
	
	private List<AbstractDoor> doors = new ArrayList<AbstractDoor>();

	public Room(String code) {
		super();
		this.code = code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void addDoor(AbstractDoor door) {
		if(door != null && !doors.contains(door)){
			doors.add(door);
		}
	}
	
	public boolean thisIsYou(String code){
		return this.code == code;
	}

	public boolean hasDoorToRoom(String toRoomCode) {
		for (AbstractDoor door : doors) {
			if(door.canYouGoToThisRoom(toRoomCode)) {
				return true;
			}
		}
		return false;
	}
	
}
