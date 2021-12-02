package com.example.pedra;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSOR = "scissor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("SetTextI18n")
    public void optionSelected(String userChoice) {
        TextView resultText = findViewById(R.id.resultText);
        TextView playerScore = findViewById(R.id.playerScore);
        TextView robotScore = findViewById(R.id.robotScore);
        resultText.setText("Choose an option below:");

        int countPlayerScore = Integer.parseInt(playerScore.getText().toString());
        int countRobotScore = Integer.parseInt(robotScore.getText().toString());

        ImageView resultImage = findViewById(R.id.imgResult);

        String[] plays = {ROCK, PAPER, SCISSOR};
        int index = new Random().nextInt(3);

        String robotChoice = plays[index];

        if (ROCK.equals(robotChoice))
            resultImage.setImageResource(R.drawable.rock);

        else if (PAPER.equals(robotChoice))
            resultImage.setImageResource(R.drawable.paper);

        else if (SCISSOR.equals(robotChoice))
            resultImage.setImageResource(R.drawable.scissor);


        //USER WINS
        if (userChoice.equals(PAPER) && robotChoice.equals(ROCK) || userChoice.equals(ROCK) && robotChoice.equals(SCISSOR)
                || userChoice.equals(SCISSOR) && robotChoice.equals(PAPER)) {

            countPlayerScore = countPlayerScore + 1;
            playerScore.setText(String.valueOf(countPlayerScore));

            if (countPlayerScore == 9) {
                resultText.setText("Congratulations You won!");
                playerScore.setText("0");
                robotScore.setText("0");
            }
        } else if (robotChoice.equals(userChoice)) {
            resultText.setText("It's a Draw!");
        }

        //ROBOT WINS
        else {
            countRobotScore = countRobotScore + 1;
            robotScore.setText(String.valueOf(countRobotScore));

            if (countRobotScore == 9) {
                resultText.setText("You lost, Try again!");
                robotScore.setText("0");
                playerScore.setText("0");
            }
        }
    }

    public void rockSelected(View view) {
        this.optionSelected(ROCK);
    }

    public void paperSelected(View view) {
        this.optionSelected(PAPER);
    }

    public void scissorSelected(View view) {
        this.optionSelected(SCISSOR);
    }
}