package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();

        if (savedInstanceState != null){

            game = (Game) savedInstanceState.getSerializable("game");

            Button button0 = (Button) findViewById((R.id.button0));
            button0.setText(savedInstanceState.getCharSequence("button0"));

            Button button1 = (Button) findViewById((R.id.button1));
            button1.setText(savedInstanceState.getCharSequence("button1"));

            Button button2 = (Button) findViewById((R.id.button2));
            button2.setText(savedInstanceState.getCharSequence("button2"));

            Button button3 = (Button) findViewById((R.id.button3));
            button3.setText(savedInstanceState.getCharSequence("button3"));

            Button button4 = (Button) findViewById((R.id.button4));
            button4.setText(savedInstanceState.getCharSequence("button4"));

            Button button5 = (Button) findViewById((R.id.button5));
            button5.setText(savedInstanceState.getCharSequence("button5"));

            Button button6 = (Button) findViewById((R.id.button6));
            button6.setText(savedInstanceState.getCharSequence("button6"));

            Button button7 = (Button) findViewById((R.id.button7));
            button7.setText(savedInstanceState.getCharSequence("button7"));

            Button button8 = (Button) findViewById((R.id.button8));
            button8.setText(savedInstanceState.getCharSequence("button8"));
        }

    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("game", game);

        Button button0 = (Button) findViewById((R.id.button0));
        CharSequence but0 = button0.getText();
        outState.putCharSequence("button0", but0);

        Button button1 = (Button) findViewById((R.id.button1));
        CharSequence but1 = button1.getText();
        outState.putCharSequence("button1", but1);

        Button button2 = (Button) findViewById((R.id.button2));
        CharSequence but2 = button2.getText();
        outState.putCharSequence("button2", but2);

        Button button3 = (Button) findViewById((R.id.button3));
        CharSequence but3 = button3.getText();
        outState.putCharSequence("button3", but3);

        Button button4 = (Button) findViewById((R.id.button4));
        CharSequence but4 = button4.getText();
        outState.putCharSequence("button4", but4);

        Button button5 = (Button) findViewById((R.id.button5));
        CharSequence but5 = button5.getText();
        outState.putCharSequence("button5", but5);

        Button button6 = (Button) findViewById((R.id.button6));
        CharSequence but6 = button6.getText();
        outState.putCharSequence("button6", but6);

        Button button7 = (Button) findViewById((R.id.button7));
        CharSequence but7 = button7.getText();
        outState.putCharSequence("button7", but7);

        Button button8 = (Button) findViewById((R.id.button8));
        CharSequence but8 = button8.getText();
        outState.putCharSequence("button8", but8);

    }

    public void tileClicked(View view) {
        int id = view.getId();
        TileState state = null;
        Button button = (Button) view;
        switch(id) {
            case R.id.button0:
                state = game.choose(0, 0);
                break;

            case R.id.button1:
                state = game.choose(0, 1);
                break;

            case R.id.button2:
                state = game.choose(0, 2);
                break;

            case R.id.button3:
                state = game.choose(1, 0);
                break;

            case R.id.button4:
                state = game.choose(1, 1);
                break;

            case R.id.button5:
                state = game.choose(1, 2);
                break;

            case R.id.button6:
                state = game.choose(2, 0);
                break;

            case R.id.button7:
                state = game.choose(2, 1);
                break;

            case R.id.button8:
                state = game.choose(2, 2);
                break;
        }


        switch(state) {
            case CROSS:
                button.setText("X");
                break;
            case CIRCLE:
                button.setText("O");
                break;
            case INVALID:
                // do something different
                break;
        }


        game.won();
        if (game.gameOver) {
            findViewById(R.id.button0).setClickable(false);
            findViewById(R.id.button1).setClickable(false);
            findViewById(R.id.button2).setClickable(false);
            findViewById(R.id.button3).setClickable(false);
            findViewById(R.id.button4).setClickable(false);
            findViewById(R.id.button5).setClickable(false);
            findViewById(R.id.button6).setClickable(false);
            findViewById(R.id.button7).setClickable(false);
            findViewById(R.id.button8).setClickable(false);

            if (game.won() == GameState.PLAYER_ONE) {
                TextView text = (TextView) findViewById(R.id.Win);
                text.setText("Player one congratzz");
                findViewById(R.id.Win).setVisibility(View.VISIBLE);
            }
            else if (game.won() == GameState.PLAYER_TWO) {
                TextView text = (TextView) findViewById(R.id.Win);
                text.setText("Player two congratzz");
                findViewById(R.id.Win).setVisibility(View.VISIBLE);
            }
            else {
                TextView text = (TextView) findViewById(R.id.Win);
                text.setText("It appears to be a Tie");
                findViewById(R.id.Win).setVisibility(View.VISIBLE);
            }



        }

    }

    public void resetClicked(View view) {
        setContentView(R.layout.activity_main);
        game = new Game();
        //reset users interface too!
    }
}
