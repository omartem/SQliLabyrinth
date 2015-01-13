package com.nespresso.sofa.recruitment.labyrinth.doors;



/**
 *
 * @author Ouadie LAHDIOUI <olahdioui@sqli.com, ouadiesoft@gmail.com>
 *
 */
public interface IDoor
{
	public boolean thisIsYourCode();
	public boolean canYouGoToThisRoom(String roomCode);
}
