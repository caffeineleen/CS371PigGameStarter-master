package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;


import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame
{
    /**
     * This ctor creates a new game state
     */
    PigGameState pig;

    public PigLocalGame() {
        pig = new PigGameState();

    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if (playerIdx == getPlayerIdx(players[0]))
        {
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if(canMove(pig.getPlayerID())) {
            if (action instanceof PigRollAction) {
                int diceVal = pig.getCurrentVal();
                Random val = new Random();
                diceVal = val.nextInt(6);
                diceVal++;
                pig.setCurrentVal(diceVal);

                if (diceVal > 1) {
                    pig.setRunningTotal(pig.getRunningTotal() + diceVal);
                } else if (diceVal == 1) {
                    pig.setRunningTotal(0);
                }

                if (pig.getPlayerID() == 1) {
                    pig.setPlayerID(0);
                } else if (pig.getPlayerID() == 0) {
                    pig.setPlayerID(1);
                }
                return true;
            } else if (action instanceof PigHoldAction) {
                if (pig.getPlayerID() == 0) {
                    pig.setScore0(pig.getRunningTotal());
                    pig.setRunningTotal(0);

                    pig.setPlayerID(1);
                } else if (pig.getPlayerID() == 1) {
                    pig.setScore1(pig.getRunningTotal());
                    pig.setRunningTotal(0);

                    pig.setPlayerID(0);
                }
                return true;
            }
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState newPig = new PigGameState(pig);
        p.sendInfo(newPig);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(pig.getScore0() >= 50 || pig.getScore1() >= 50){
            if(pig.getScore1() >= 50){
                String message1 = "Player 1 has won!";
                return message1;
            }
            else{
                return  "Player 0 has won!";
            }
        }
        return null;
    }

}// class PigLocalGame
