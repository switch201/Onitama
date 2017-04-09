package custom;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Stuart on 3/16/2017.
 */

public class Space extends android.support.v7.widget.AppCompatTextView {

    public Piece piece = null;

    public Space(Context context) {
        super(context);
        this.setBackgroundColor(Color.GRAY);
    }

    public Space(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setBackgroundColor(Color.GRAY);
    }

    public Space(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setBackgroundColor(Color.GRAY);
    }

    // This is used to make square buttons.
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }


    public void setPiece(Piece p){
        this.piece = p;
        this.setText(p.rank);
        this.setTextColor(p.color);
    }

    public void removePiece(){
        this.piece = null;
        this.setText("");
        this.setTextColor(Color.BLACK);
    }



    public boolean hasPiece(){
        return piece==null ? false:true;
    }
}
