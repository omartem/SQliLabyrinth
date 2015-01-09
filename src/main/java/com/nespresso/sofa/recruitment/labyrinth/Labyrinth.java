package com.nespresso.sofa.recruitment.labyrinth;

import static com.nespresso.sofa.recruitment.labyrinth.tools.LabyrinthConstants.ERROR_PAIR_ROOM_SEPARATOR;
import static com.nespresso.sofa.recruitment.labyrinth.tools.LabyrinthConstants.SENSOR_GATE_SEPARATOR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

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

	final static LabyrinthTools labyrinthTools = new LabyrinthTools();
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

						populatRoomList(sourceRoom, destinationRoom, gateType);
						populatRoomList(destinationRoom, sourceRoom, gateType);

					}
				}
				else
				{
					invalidPairRooms.append(StringUtils.isNotBlank(invalidPairRooms.toString()) ? ERROR_PAIR_ROOM_SEPARATOR + room
							: room);
				}
			}

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

	/**
	 * Enrichire la liste roomsList
	 *
	 * @param sourceRoom
	 * @param destinationRoom
	 * @param gateType
	 */
	private void populatRoomList(final String sourceRoom, final String destinationRoom, final String gateType)
	{
		if (StringUtils.isNotBlank(sourceRoom) && StringUtils.isNotBlank(destinationRoom) && StringUtils.isNotBlank(gateType))
		{
			if (roomsList.containsKey(sourceRoom))
			{
				if (!roomsList.get(sourceRoom).containsKey(destinationRoom))
				{
					roomsList.get(sourceRoom).put(destinationRoom, gateType);
				}
			}
			else
			{
				final Map<String, String> destinationRooms = new HashMap<String, String>();
				destinationRooms.put(destinationRoom, gateType);
				roomsList.put(sourceRoom, destinationRooms);
			}

		}

	}

	@Override
	public void popIn(final String room)
	{
		if (StringUtils.isNotBlank(room))
		{
			this.popInRoom = room;
		}
	}

	@Override
	public void walkTo(final String room)
	{
		if (StringUtils.isNotBlank(room) && StringUtils.isNotBlank(popInRoom))
		{
			final Map<String, String> possibleMovement = roomsList.get(popInRoom);
			if (possibleMovement.containsKey(room))
			{
				
				if(!closedDoors.contains(popInRoom + room)){
					
					if (SENSOR_GATE_SEPARATOR.equals(possibleMovement.get(room)))
					{
						sensorTrace.append((StringUtils.isNotBlank(sensorTrace.toString()) ? ";" : "") + popInRoom + room);
					}
					lastDoor = popInRoom;
					popInRoom = room;
					
				}else{
					throw new ClosedDoorException("Porte " + popInRoom + room + " est fermé :(");
				}
			}
			else
			{
				throw new IllegalMoveException("Impossible de passer à la chambre " + room + " à partir de " + popInRoom + " :(");
			}
		}
	}

	@Override
	public void closeLastDoor()
	{
		if (closedDoors.contains(lastDoor + popInRoom) || closedDoors.contains(popInRoom + lastDoor))
		{
			throw new DoorAlreadyClosedException("Dernier porte déja fermé :(");
		}
		else
		{
			closedDoors.add(lastDoor + popInRoom);
			closedDoors.add(popInRoom + lastDoor);
		}
	}

	@Override
	public String readSensors()
	{
		return sensorTrace.toString();
	}

}
