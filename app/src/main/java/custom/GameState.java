package custom;

import android.graphics.Color;

import com.example.stuart.onitama4.MainActivity;

import java.util.ArrayList;

/**
 * Created by Stuart on 4/16/2017.
 */

public class GameState {
    public Player player1;
    public Player player2;
    public Player activePlayer;
    public ArrayList possibleMoves = new ArrayList();

    public GameState(){
        possibleMoves = new ArrayList();
        player1 = new Player("Player 1", "black");
        player2 = new Player("Player 2", "white");
        activePlayer = player1;
    }


    public boolean isPlayersTurn(Board board){
        return activePlayer.color==board.prevSpace.piece.color;
    }


    public  void switchPlayers(){
        if(activePlayer==player1){
            activePlayer=player2;
        }
        else{
            activePlayer=player1;
        }
    }
}
