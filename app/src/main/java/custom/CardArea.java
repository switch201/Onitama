package custom;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by Stuart on 4/9/2017.
 */

public class CardArea extends LinearLayout {
    ArrayList cards;

    public CardArea(Context context) {
        super(context);
    }

    public CardArea(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CardArea(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CardArea(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setCards(ArrayList cards){
        this.cards=cards;
        inizilizeCards();
    }

    public void inizilizeCards(){
        Iterator it = Util.CARDS.entrySet().iterator();
        Iterator<Card> it2 = cards.iterator();
        while (it.hasNext()&&it2.hasNext()){
            Map.Entry pair = (Map.Entry) it.next();
            Card currentCard = it2.next();
            currentCard.setName((String)pair.getKey());
            currentCard.setMoveableSpots((List)pair.getValue());
            it2.remove();
            it.remove();
        }
    }
}
