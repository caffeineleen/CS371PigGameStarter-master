package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by smithka19 on 10/12/2016.
 */
public class PigGameState extends GameState
{
    private int playerID;
    private int score0;
    private int score1;
    private int runningTotal;
    private int currentVal;

    public PigGameState(){
        playerID = 0;
        score0 = 0;
        score1 = 0;
        runningTotal = 0;
        currentVal = 0;
    }
    //constructor

    public PigGameState(PigGameState p) {
        this.playerID = p.getPlayerID();
        this.score0 = p.getScore0();
        this.score1 = p.getScore1();
        this.runningTotal = p.getRunningTotal();
        this.currentVal = p.getCurrentVal();
    }
    //copy constructor

    public int getPlayerID(){
        return playerID;
    }
    int getScore0(){
        return score0;
    }
    int getScore1(){
        return score1;
    }
    int getRunningTotal(){
        return runningTotal;
    }
    int getCurrentVal(){
        return currentVal;
    }
    //getters

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public void setScore0(int score0) {
        this.score0 = score0;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public void setRunningTotal(int runningTotal) {
        this.runningTotal = runningTotal;
    }

    public void setCurrentVal(int currentVal) {
        this.currentVal = currentVal;
    }
    //setters
}
