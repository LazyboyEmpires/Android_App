package lazyboyempires.nmc.tik_tak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //0: yellow, 1: red, 2: empty
    int[] gameState = {2,2,2,2,2,2,2,2,2};//
    int activePlayer = 0;
    boolean gameActive = true;
    int[][] winningPosition = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7},{2,5,8}, {0,4,8},{2,4,6}};

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        int tappedState =  Integer.parseInt( counter.getTag().toString());
        if (gameState[tappedState] == 2 && gameActive) {
            gameState[tappedState] = activePlayer;
            counter.setTranslationY(-1500);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1500).setDuration(300);
            for (int[] winningPosition : winningPosition) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                    gameActive = false;
                    String winner = "";
                    if (activePlayer == 1) {
                        winner = "Yellow";
                    } else {
                        winner = "Red";
                    }
                    Button playAgainBtn = (Button) findViewById(R.id.playAgainBtn);
                    TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
                    winnerTextView.setText(winner + "has won");
                    winnerTextView.setVisibility(View.VISIBLE);
                    playAgainBtn.setVisibility(View.VISIBLE);

                }
            }
        }
    }

    public void playAgain(View view) {
        Button playAgainBtn = (Button) findViewById(R.id.playAgainBtn);
        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        winnerTextView.setVisibility(View.INVISIBLE);
        playAgainBtn.setVisibility(View.INVISIBLE);
        GridLayout myLayout = (GridLayout) findViewById(R.id.gridLayout);
        for (int i = 0 ; i < myLayout.getChildCount(); i++) {
            ImageView child =  (ImageView) myLayout.getChildAt(i);
            child.setImageDrawable(null);
        }
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        activePlayer = 0;
        gameActive = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}