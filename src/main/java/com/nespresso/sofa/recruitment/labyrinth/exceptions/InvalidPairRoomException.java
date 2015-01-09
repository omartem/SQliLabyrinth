package com.nespresso.sofa.recruitment.labyrinth.exceptions;

/**
 *
 * @author Ouadie LAHDIOUI <olahdioui@sqli.com, ouadiesoft@gmail.com>
 *
 *         Une Exception personalisée
 */
public class InvalidPairRoomException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par défaut de l'exception
	 */
	public InvalidPairRoomException()
	{
		super();
	}

	/**
	 * Constructeur avec message et cause de l'exception
	 *
	 * @param message
	 * @param cause
	 */
	public InvalidPairRoomException(final String message, final Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * Constructeur avec message de l'exception
	 *
	 * @param message
	 */
	public InvalidPairRoomException(final String message)
	{
		super(message);
	}

	/**
	 * Constructeur avec caus de l'exception
	 *
	 * @param cause
	 */
	public InvalidPairRoomException(final Throwable cause)
	{
		super(cause);
	}

}
