package com.example.stuart.onitama4;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import custom.Board;
import custom.Space;
import custom.Util;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Space[][] spaces = new Space[5][5];

    Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_area);
        board = (Board) findViewById(R.id.theBoard);
        getSpaces();
        board.setSpaces(spaces, this);
    }

    public void getSpaces(){
        int add=0;
        for(int x=0;x<5;x++) {
            for (int y = 0; y < 5; y++) {
                Space space = (Space) findViewById(Util.SPACE_IDS[y + add]);
                spaces[x][y] = space;
            }
            add+=5;
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
