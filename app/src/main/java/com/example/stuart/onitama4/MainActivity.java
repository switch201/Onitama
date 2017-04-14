package com.example.stuart.onitama4;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import custom.Board;
import custom.Card;
import custom.CardArea;
import custom.GameArea;
import custom.Space;
import custom.Util;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Space[][] spaces = new Space[5][5];
    public ArrayList cards = new ArrayList();

    Board board;
    CardArea cardArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_area);
        board = (Board) findViewById(R.id.theBoard);
        cardArea = (CardArea) findViewById(R.id.cardArea);
        getSpaces();
        board.setSpaces(spaces, this);
//        cardArea.setCards(cards, this);
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
        final Set<Integer> intSet = new HashSet<>();
        while (intSet.size() < 6) {
            intSet.add(new Random().nextInt(Util.CARDS.entrySet().size()));
        }
        for(int x=0;x<Util.CARD_IDS.length;x++){
            cards.add((Card) findViewById(Util.CARD_IDS[x]));
        }
    }


    @Override
    public void onClick(View v) {
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
}
