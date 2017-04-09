package custom;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.stuart.onitama4.MainActivity;
import com.example.stuart.onitama4.R;

/**
 * Created by Stuart on 3/16/2017.
 */

public class Board extends LinearLayout {

    public Space[][] spaces;
    public Space prevSpace;

    public Board(Context context) {
        super(context);
    }

    public Board(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Board(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Board(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void highlightSpace(Space s, boolean highlight){
        s.setActivated(highlight);
        prevSpace = highlight?s:null;
        s.setBackgroundColor(highlight?Color.YELLOW:Color.GRAY);
    }

    public boolean hasPrevSpace(){
        return prevSpace!=null;
    }

    public boolean move(Space to){
        if(prevSpace.hasPiece()&&!to.hasPiece()){
            to.setPiece(prevSpace.piece);
            prevSpace.removePiece();
            prevSpace.setBackgroundColor(Color.GRAY);
            prevSpace.setActivated(false);
            prevSpace=null;
            return true;
        }
        return false;
    }

    public void setSpaces(Space[][] spaces, MainActivity m){
        this.spaces = spaces;
        inizilzeSpaces(m);
    }

    public void inizilzeSpaces(MainActivity m){
        for(int x=0;x<5;x++) {
            for (int y = 0; y < 5; y++) {
                Space space = spaces[x][y];
                if(x==0||x==4){
                    if(y==2){
                        space.setPiece(new Piece("M", x==0 ? Color.BLUE:Color.RED));
                    }
                    else{
                        space.setPiece(new Piece("m", x==0 ? Color.BLUE:Color.RED));
                    }

                }
                space.setOnClickListener(m);
            }
        }
    }


    public Row getChildAt(int i){
        return (Row) super.getChildAt(i);
    }
}