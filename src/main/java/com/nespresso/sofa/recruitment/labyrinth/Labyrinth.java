package com.nespresso.sofa.recruitment.labyrinth;

import static com.nespresso.sofa.recruitment.labyrinth.tools.LabyrinthConstants.ERROR_PAIR_ROOM_SEPARATOR;
import static com.nespresso.sofa.recruitment.labyrinth.tools.LabyrinthConstants.SENSOR_GATE_SEPARATOR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.nespresso.sofa.recruitment.labyrinth.doors.AbstractDoor;
import com.nespresso.sofa.recruitment.labyrinth.doors.DoorFactory;
import com.nespresso.sofa.recruitment.labyrinth.doors.IDoor;
import com.nespresso.sofa.recruitment.labyrinth.exceptions.ClosedDoorException;
import com.nespresso.sofa.recruitment.labyrinth.exceptions.DoorAlreadyClosedException;
import com.nespresso.sofa.recruitment.labyrinth.exceptions.IllegalMoveException;
import com.nespresso.sofa.recruitment.labyrinth.exceptions.InvalidPairRoomException;
import com.nespresso.sofa.recruitment.labyrinth.tools.LabyrinthTools;
import com.nespresso.sofa.recruitment.labyrinth.validators.LabyrinthBlankValidator;
import com.nespresso.sofa.recruitment.labyrinth.validators.LabyrinthGateValidator;
import com.nespresso.sofa.recruitment.labyrinth.validators.LabyrinthNotPairValidator;


/**
 *
 * @author Ouadie LAHDIOUI <olahdioui@sqli.com, ouadiesoft@gmail.com>
 *
 */
public class Labyrinth implements Ilabyrinth
{

	private final static LabyrinthTools labyrinthTools = new LabyrinthTools();
	private final static List<IDoor> doors = new ArrayList<IDoor>();
	private Walker walker;
	
	/**
	 * Exemple : [A,[[B,SENSOR_GATE],[c,SIMPLE_GATE],...] B,[[D,SENSOR_GATE],[E,SIMPLE_GATE],...], ...]
	 */
	private final Map<String, Map<String, String>> roomsList = new HashMap<String, Map<String, String>>();
	private String popInRoom = "";
	private String lastDoor;
	private final StringBuilder sensorTrace = new StringBuilder("");
	private final List<String> closedDoors = new ArrayList<>();

	static
	{
		labyrinthTools.addValidator(new LabyrinthBlankValidator());
		labyrinthTools.addValidator(new LabyrinthNotPairValidator());
		labyrinthTools.addValidator(new LabyrinthGateValidator());
	}

	/**
	 * Constructeur par défaut de la labyrinth
	 */
	public Labyrinth()
	{
		super();
	}

	/**
	 * Constructeur avec des rooms de labyrinth
	 *
	 * @param rooms
	 */
	public Labyrinth(final String... rooms)
	{
		try
		{
			final StringBuilder invalidPairRooms = new StringBuilder("");

			for (final String room : rooms)
			{
				if (labyrinthTools.validat(room))
				{
					/**
					 * J'ai ajouter ce test même que mes validateurs font leurs travail, seulement pour être sûr. Normalement
					 * l'emplacement de cette vérification et dedans un de mes validateurs
					 */
					if (room.length() > 2)
					{
						final String sourceRoom = String.valueOf(room.charAt(0));
						final String destinationRoom = String.valueOf(room.charAt(2));
						final String gateType = String.valueOf(room.charAt(1));
						
						AbstractDoor door = DoorFactory.getDoor(gateType);
						door.setFirstRoom(new Room(sourceRoom));
						door.setSecondRoom(new Room(destinationRoom));
						
						doors.add(door);
					}
				}
				else
				{
					invalidPairRooms.append(StringUtils.isNotBlank(invalidPairRooms.toString()) ? ERROR_PAIR_ROOM_SEPARATOR + room
							: room);
				}
				
			}
			/**
			 * Initialisation du walker
			 */
			walker = new Walker();

			if (StringUtils.isNotBlank(invalidPairRooms.toString()))
			{

				throw new InvalidPairRoomException(invalidPairRooms.toString());
			}

		}
		catch (final InvalidPairRoomException e)
		{
			// TODO Please cher développeur transforme moi en clean code :(
			e.printStackTrace();
		}
	}


	@Override
	public void popIn(final String room)
	{
		if(StringUtils.isNotBlank(room)) {
			walker.setCurrentRoom(new Room(room));
		}
	}

	@Override
	public void walkTo(final String room)
	{

	}

	@Override
	public void closeLastDoor()
	{

	}

	@Override
	public String readSensors()
	{
		return "";
	}

}
