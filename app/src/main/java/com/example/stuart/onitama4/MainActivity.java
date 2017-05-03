package com.example.stuart.onitama4;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;

import custom.Board;
import custom.Card;
import custom.CardArea;
import custom.GameState;
import custom.Space;
import custom.Util;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Space[][] spaces = new Space[5][5];
    public ArrayList cardSpots = new ArrayList();

    Board board;
    CardArea cardArea;
    GameState gs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_area);
        board = (Board) findViewById(R.id.theBoard);
        cardArea = (CardArea) findViewById(R.id.cardArea);
        gs = new GameState();
        getSpaces();
        getCards();
        board.setSpaces(spaces, this);
        cardArea.setCardSpots(cardSpots, this);
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

    public boolean moveOrCapture(Space s) {
        if (cardArea.hasSelectedCard()&&isLeagleMove()) {
            if (s.hasPiece()) {
                return board.capture(s);
            } else {
                return board.move(s);
            }
        }
        return false;
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
                    if((board.hasPrevSpace())&&gs.isPlayersTurn(board)&&moveOrCapture(s)){
                        Log.d("noises", "Happy Chime");
                        gs.switchPlayers();
                    }
                    else{
                        Log.d("noises", "Sad Chime");
                    }

                }

            }
        }
        else if(v instanceof Card){
            Card c = (Card) v;
            if (c.isActivated()){
                cardArea.highlightCard(c, false);
            }
            else{
                if(!cardArea.hasSelectedCard()){
                    cardArea.highlightCard(c, true);
                }
            }
        }
        showMoves();
    }

    public boolean isLeagleMove(){
        return true;
    }

    public void showMoves(){
        if(cardArea.hasSelectedCard()&&board.hasPrevSpace()){
            Iterator it = cardArea.selectedCard.moveableSpots.iterator();
            while (it.hasNext()){
                Point p = (Point) it.next();
                try{
                    //this current setup shows moves relative to player 2 probably use minus to show relative to player 1
                    board.spaces[p.y+board.prevSpace.x][p.x+board.prevSpace.y].setBackgroundColor(Color.RED);
                    gs.possibleMoves.add(board.spaces[p.y+board.prevSpace.x][p.x+board.prevSpace.y]);
                }
                catch (Throwable t){}

            }

        }
        else{
            if(!gs.possibleMoves.isEmpty()){
                Iterator<Space> it = gs.possibleMoves.iterator();
                while (it.hasNext()){
                    it.next().setBackgroundColor(Color.GRAY);
                }
                gs.possibleMoves.clear();
            }
        }
    }
}
