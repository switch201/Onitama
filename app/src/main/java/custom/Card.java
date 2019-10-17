package custom;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.stuart.onitama4.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stuart on 4/11/2017.
 */

public class Card extends android.support.v7.widget.AppCompatImageButton {

    public String name;
    public int src;
    public List moveableSpots;
    public int color;

    public Card(Context context) {
        super(context);
    }

    public Card(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Card(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSrc(Integer id){
        this.src = id;
        this.setImageDrawable(getResources().getDrawable(this.src));
    }

    public void setMoveableSpots(List moveableSpots) {
        this.moveableSpots = moveableSpots;
    }

    public void setColor(int color){
        this.color = color;
    }
}
