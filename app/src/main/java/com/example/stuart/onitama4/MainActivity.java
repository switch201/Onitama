package com.example.stuart.onitama4;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import custom.Board;
import custom.Card;
import custom.CardArea;
import custom.Space;
import custom.Util;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Space[][] spaces = new Space[5][5];
    public ArrayList cardSpots = new ArrayList();

    Board board;
    CardArea cardArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_area);
        board = (Board) findViewById(R.id.theBoard);
        cardArea = (CardArea) findViewById(R.id.cardArea);
        getSpaces();
        getCards();
        board.setSpaces(spaces, this);
        cardArea.setCardSpots(cardSpots);
    }

    public void getSpaces(){
        int add=0;
        for(int x=0;x<5;x++) {
            for (int y = 0; y < 5; y++) {
                spaces[x][y] = (Space) findViewById(Util.SPACE_IDS[y + add]);
            }
            add+=5;
        }
    }

    public void getCards(){
        for(int x=0;x<Util.CARD_IDS.length;x++){
            cardSpots.add(findViewById(Util.CARD_IDS[x]));
        }
    }


    @Override
    public void onClick(View v) {
        if(v instanceof Space){
            Space s = (Space) v;
            if(s.isActivated()){
                board.highlightSpace(s, false);
            }
            else{
                if(!board.hasPrevSpace()&&s.hasPiece()){
                    board.highlightSpace(s, true);
                }
                else{
                    if((board.prevSpace!=null)&&board.moveOrCapture(s)){
                        Log.d("noises", "Happy Chime");
                    }
                    else{
                        Log.d("noises", "Sad Chime");
                    }

                }

            }
        }
        else if(v instanceof Card){
            Card c = (Card) v;
        }
    }
}
