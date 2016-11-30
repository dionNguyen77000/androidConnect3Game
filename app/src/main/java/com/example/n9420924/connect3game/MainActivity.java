package com.example.n9420924.connect3game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    //0 = mark_X and 1 = mark_O
    int activePlayer = 0;

    int[] gameState= {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    public void dropIn(View v) {
        ImageView counter = (ImageView) v;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2) {
            gameState[tappedCounter] = activePlayer;
            counter.setTranslationY(-1000f);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.mark_x);
                activePlayer = 1;

            } else {
                counter.setImageResource(R.drawable.mark_o);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1000f).rotation(360).setDuration(500);

            for (int[] winningPositioin: winningPositions){
                if (gameState[winningPositioin[0]] == gameState[winningPositioin[1]] &&
                        gameState[winningPositioin[1]] ==gameState[winningPositioin[2]] &&
                        gameState[winningPositioin[0]] !=2){
                    System.out.println(gameState[winningPositioin[0]]);

                    //someone has won
                    LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);

                }
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
