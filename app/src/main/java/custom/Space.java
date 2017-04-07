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
        setListener();
    }

    public Space(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setBackgroundColor(Color.GRAY);
        setListener();
    }

    public Space(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setBackgroundColor(Color.GRAY);
        setListener();
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

    public void setListener(){
        this.setOnClickListener(new Space.OnClickListener() {
            Space prevSpace;
            public void onClick(View v) {
                Space s = (Space) v;
                if(s.isActivated()){
                    s.setActivated(false);
                    prevSpace=null;
                }
                else{
                    if(prevSpace==null){
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
        });
    }

    public boolean hasPiece(){
        return piece==null ? false:true;
    }
}
