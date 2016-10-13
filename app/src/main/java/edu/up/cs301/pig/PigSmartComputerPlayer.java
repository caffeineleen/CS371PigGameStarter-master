package edu.up.cs301.pig;

import android.util.Log;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;

/**
 * Created by smithka19 on 10/12/2016.
 */
public class PigSmartComputerPlayer extends GameComputerPlayer
{
    public PigSmartComputerPlayer(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info)
    {
        if(info instanceof PigGameState) {
            if (((PigGameState) info).getPlayerID() != playerNum) {
                return;
            }
            else {

                if(((PigGameState) info).getRunningTotal() > 10){
                    PigHoldAction hold = new PigHoldAction(this);
                    game.sendAction(hold);
                }
                else {
                    PigRollAction roll = new PigRollAction(this);
                    game.sendAction(roll);
                    Log.i("Random Roll", "Roll");
                }
                Log.i("computer", "works");
            }
        }
    }
}
