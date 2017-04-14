package custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stuart on 4/11/2017.
 */

public class Card extends android.support.v7.widget.AppCompatTextView {

    public String name;
    public List moveableSpots;

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

    public void setMoveableSpots(List moveableSpots) {
        this.moveableSpots = moveableSpots;
    }
}
