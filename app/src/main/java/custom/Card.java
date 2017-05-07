package custom;

import android.content.Context;
import android.graphics.Color;
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
    public Player controller;

    public Card(Context context) {
        super(context);
        this.setTextColor(Color.GREEN);
    }

    public Card(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setTextColor(Color.GREEN);
    }

    public Card(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setTextColor(Color.GREEN);
    }

    public void setName(String name) {
        this.name = name;
        this.setText(name);
        this.setTextColor(Color.GREEN);
        this.setBackgroundColor(Color.GRAY);
    }

    public void setCard(Card card){
        setName(card.name);
        setMoveableSpots(card.moveableSpots);
    }

    public boolean hasController(){
        return controller!=null;
    }

    public void setMoveableSpots(List moveableSpots) {
        this.moveableSpots = moveableSpots;
    }
}
