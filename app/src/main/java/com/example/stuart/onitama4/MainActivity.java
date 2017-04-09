package com.example.stuart.onitama4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import custom.Board;
import custom.Piece;
import custom.Space;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Space[][] spaces = new Space[5][5];
    public Space prevSpace;

    final int[] SPACE_IDS = {
            R.id.button00,
            R.id.button01,
            R.id.button02,
            R.id.button03,
            R.id.button04,
            R.id.button10,
            R.id.button11,
            R.id.button12,
            R.id.button13,
            R.id.button14,
            R.id.button20,
            R.id.button21,
            R.id.button22,
            R.id.button23,
            R.id.button24,
            R.id.button30,
            R.id.button31,
            R.id.button32,
            R.id.button33,
            R.id.button34,
            R.id.button40,
            R.id.button41,
            R.id.button42,
            R.id.button43,
            R.id.button44
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);
        Board board = (Board) findViewById(R.id.theBoard);
        inizilzeSpaces();
        board.setSpaces(spaces);
    }

    public void inizilzeSpaces(){
        int add=0;
        for(int x=0;x<5;x++) {
            for (int y = 0; y < 5; y++) {
                Space space = (Space) findViewById(SPACE_IDS[y + add]);
                spaces[x][y] = space;
                if(x==0||x==4){
                    if(y==2){
                        space.setPiece(new Piece("M", x==0 ? Color.BLUE:Color.RED));
                    }
                    else{
                        space.setPiece(new Piece("m", x==0 ? Color.BLUE:Color.RED));
                    }

                }
                space.setOnClickListener(this);
            }
            add+=5;
        }
    }

    @Override
    public void onClick(View v) {
        Space s = (Space) v;
        if(s.isActivated()){
            s.setActivated(false);
            this.prevSpace =null;
            s.setBackgroundColor(Color.GRAY);
        }
        else{
            if(this.prevSpace ==null){
                s.setActivated(true);
                prevSpace = s;
                s.setBackgroundColor(Color.YELLOW);
            }
            else{
                if(prevSpace.hasPiece()){
                    s.setPiece(prevSpace.piece);
                    prevSpace.removePiece();
                }
            }

        }
    }
}
