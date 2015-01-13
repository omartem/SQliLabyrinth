package com.nespresso.sofa.recruitment.labyrinth.doors;

import static com.nespresso.sofa.recruitment.labyrinth.tools.LabyrinthConstants.SENSOR_GATE_SEPARATOR;
/**
 * 
 * @author Ouadie LAHDIOUI <olahdioui@sqli.com, ouadiesoft@gmail.com>
 * 
 */
public class DoorFactory {
	
	public static AbstractDoor getDoor(String code) {
		
		AbstractDoor door;
		
		if(SENSOR_GATE_SEPARATOR.equals(code)){
			door = new SensorDoor(); 
		}else{
			door = new SimpleDoor();
		}
		
		return door;
		
	}
	
}
