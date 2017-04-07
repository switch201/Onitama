package custom;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.stuart.onitama4.R;

/**
 * Created by Stuart on 3/16/2017.
 */

public class Board extends LinearLayout {

    public Space[][] spaces;

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

    public boolean move(Space from, Space to){
        if(from.hasPiece()&&!to.hasPiece()){
            to.setPiece(from.piece);
            from.removePiece();
            return true;
        }
        return false;
    }

    public void setSpaces(Space[][] spaces){
        this.spaces = spaces;
    }


    public Row getChildAt(int i){
        return (Row) super.getChildAt(i);
    }
}