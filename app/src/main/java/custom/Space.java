package custom;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.example.stuart.onitama4.R;

/**
 * Created by Stuart on 3/16/2017.
 */

public class Space extends android.support.v7.widget.AppCompatImageButton {

    public Piece piece = null;
    public int kingSpace;
    public int x;
    public int y;

    public Space(Context context) {
        super(context);
    }

    public Space(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Space(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // This is used to make square buttons.
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }


    public void setPiece(Piece p){
        this.piece = p;
        if(p.color == "white"){
            if(p.rank == "king"){
                this.setImageDrawable(getResources().getDrawable(R.drawable.white_king));
            }
            else{
                this.setImageDrawable(getResources().getDrawable(R.drawable.white_pawn));
            }
        }
        else if(p.color == "black"){
            if(p.rank == "king"){
                this.setImageDrawable(getResources().getDrawable(R.drawable.black_king));
            }
            else{
                this.setImageDrawable(getResources().getDrawable(R.drawable.black_pawn));
            }
        }
    }

    public void removePiece(){
        this.piece = null;
      this.setImageDrawable(getResources().getDrawable(R.drawable.empty_space));
        this.getBackground().clearColorFilter();
    }



    public boolean hasPiece(){
        return piece==null ? false:true;
    }
}
