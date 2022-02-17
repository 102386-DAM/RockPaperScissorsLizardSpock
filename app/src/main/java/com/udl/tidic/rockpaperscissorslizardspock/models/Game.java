package com.udl.tidic.rockpaperscissorslizardspock.models;

import android.graphics.Path;
import android.util.Log;
import android.widget.Toast;

public class Game {

    private static final String TAG = Game.class.getSimpleName();
    private Player player1;
    private Player player2;

    public Game(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    private int parseDecision(Options decision) {
        switch (decision) {
            case ROCK:
                return 0;
            case SPOCK:
                return 1;
            case PAPER:
                return 2;
            case LIZARD:
                return 3;
            case SCISSORS:
                return 4;
            default:
                return -1;
        }
    }

    public String playRound() {
        int p1_decision = this.parseDecision(this.player1.getDecision());
        int p2_decision = this.parseDecision(this.player2.getDecision());

        int diff = (p2_decision - p1_decision + 5) % 5;

        if (p2_decision == p1_decision) {
            Log.d(TAG,"AI and Player tie!");
            return "AI and Player tie!";


        } else if (diff < 3) {
            Log.d(TAG,"AI is the winner");
            return "AI is the winner";

        } else {
            Log.d(TAG,"Player is the winner");
            return "Player is the winner";

        }
    }
}
