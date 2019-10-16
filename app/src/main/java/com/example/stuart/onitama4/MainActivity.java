package com.example.stuart.onitama4;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public boolean moveOrCapture(Space s, Card c) {
        if (isLegalMove(s)) {
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
                Log.d("gameInfo", "Space ("+s.x+","+s.y+") has been deactivated");
            }
            else{
                if(!board.hasPrevSpace()&&s.hasPiece()){
                    board.highlightSpace(s, true);
                    Log.d("gameInfo", "Space ("+s.x+","+s.y+") has been activated");
                }
                else{
                    if((board.hasPrevSpace())&&gs.isPlayersTurn(board)&&cardArea.hasSelectedCard()&& isCurrentPlayersCard(cardArea.selectedCard)&&moveOrCapture(s, cardArea.selectedCard)){
                        Log.d("noises", "Happy Chime");
                        Log.d("gameInfo", gs.activePlayer.name+" has moved a piece from ("+board.prevSpace.x+","+board.prevSpace.y+") to ("+s.x+","+s.y+") using card: "+cardArea.selectedCard.name);
                        gs.switchPlayers();
                        cardArea.swapCards(cardArea.selectedCard);
                        board.prevSpace=null;
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
                Log.d("gameInfo", c.name+" card has been deactivated");
            }
            else{
                if(!cardArea.hasSelectedCard()){
                    cardArea.highlightCard(c, true);
                    Log.d("gameInfo", c.name+" card has been activated");
                }
            }
        }
        showMoves();
    }

    public boolean isLegalMove(Space s){
        Iterator it = gs.possibleMoves.iterator();
        while(it.hasNext()){
            if(s==it.next()){
                Log.d("gameInfo", gs.activePlayer.name+" Attempted a Legal Move");
                return true;
            }
        }
        Log.d("gameInfo", gs.activePlayer.name+" Attempted an Illegal Move");
        return false;
    }

    public void showMoves(){
        if(cardArea.hasSelectedCard()&&board.hasPrevSpace()){
            Iterator it = cardArea.selectedCard.moveableSpots.iterator();
            while (it.hasNext()){
                Point p = (Point) it.next();
                try{
                    //this current setup shows moves relative to player 2 probably use minus to show relative to player 1.
                    if(gs.activePlayer.color=="black"){
                        board.spaces[board.prevSpace.x-p.y][board.prevSpace.y-p.x].getBackground().setColorFilter(Util.SPACE_BACKGROUND_TARGET, PorterDuff.Mode.MULTIPLY);
                        gs.possibleMoves.add(board.spaces[board.prevSpace.x-p.y][board.prevSpace.y-p.x]);
                    }
                    else{
                        board.spaces[p.y+board.prevSpace.x][p.x+board.prevSpace.y].getBackground().setColorFilter(Util.SPACE_BACKGROUND_TARGET, PorterDuff.Mode.MULTIPLY);;
                        gs.possibleMoves.add(board.spaces[p.y+board.prevSpace.x][p.x+board.prevSpace.y]);
                    }

                }
                catch (Throwable t){}

            }

        }
        else{
            if(!gs.possibleMoves.isEmpty()){
                Iterator<Space> it = gs.possibleMoves.iterator();
                while (it.hasNext()){
                    it.next().getBackground().clearColorFilter();
                }
                gs.possibleMoves.clear();
            }
        }
    }

    public boolean isCurrentPlayersCard(Card c){
        List<Card> theCards = new ArrayList<>();
        if(gs.activePlayer.color=="black"){
            theCards = cardArea.getPlayer1Cards();
        }
        else{
            theCards = cardArea.getPlayer2Cards();
        }
        return theCards.contains(c);
    }
}
