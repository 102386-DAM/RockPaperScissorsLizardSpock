package com.udl.tidic.rockpaperscissorslizardspock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Region;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.udl.tidic.rockpaperscissorslizardspock.models.Game;
import com.udl.tidic.rockpaperscissorslizardspock.models.Options;
import com.udl.tidic.rockpaperscissorslizardspock.models.Player;

public class GameActivity extends AppCompatActivity {

    private static String TAG = GameActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");

        Button button_rock = findViewById(R.id.ROCK);
        Button button_scissors = findViewById(R.id.SCISSOR);
        Button button_paper = findViewById(R.id.PAPER);
        Button button_lizard = findViewById(R.id.LIZARD);
        Button button_spock = findViewById(R.id.SPOCK);

        button_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Options decision = Options.ROCK;
                initGame(name, decision);
            }
        });

        button_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Options decision = Options.SCISSORS;
                initGame(name, decision);
            }
        });

        button_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Options decision = Options.PAPER;
                initGame(name, decision);
            }
        });

        button_lizard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Options decision = Options.LIZARD;
                initGame(name, decision);
            }
        });

        button_spock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Options decision = Options.SPOCK;
                initGame(name, decision);
            }
        });

    }


    private void initGame(String name, Options decision) {
        Log.d(TAG, decision.name());
        Player p1 = new Player(name, decision);
        Player p2 = new Player("ai", Options.getRandomDecision());

        Game game = new Game(p1, p2);
        String winner = game.playRound();

        Toast.makeText(getApplicationContext(), "AI decision: " + Options.getRandomDecision().toString(), Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(), winner, Toast.LENGTH_LONG).show();
    }


    private Options getEnumOption(String text) {
        switch (text) {
            case "ROCK":
                return Options.ROCK;
            case "SCISSORS":
                return Options.SCISSORS;
            case "PAPER":
                return Options.PAPER;
            case "LIZARD":
                return Options.LIZARD;
            case "SPOCK":
                return Options.SPOCK;
            default:
                return Options.PAPER;
        }
    }
}