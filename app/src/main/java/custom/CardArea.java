package custom;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.stuart.onitama4.MainActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Stuart on 4/9/2017.
 */

public class CardArea extends LinearLayout {
    ArrayList<Card> cardSpots;
    public Card selectedCard;

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

    public void setCardSpots(ArrayList cardSpots, MainActivity m){
        this.cardSpots = cardSpots;
        inizilizeCards(m);
    }

    public void inizilizeCards(MainActivity m){
        ArrayList<String> cardNames = new ArrayList(Util.CARDS.keySet());
        for(int x = 0;x<cardSpots.size();x++){
            int draw = new Random().nextInt(cardNames.size());
            String cardName = cardNames.get(draw);
            List moveableSpaces = Util.CARDS.get(cardName);
            cardSpots.get(x).setMoveableSpots(moveableSpaces);
            cardSpots.get(x).setName(cardName);
            cardSpots.get(x).setOnClickListener(m);
            if(x<2){
                cardSpots.get(x).setColor(Color.RED);
            }
            if(x==2){
                cardSpots.get(x).setColor(Color.GRAY);
            }else{
                cardSpots.get(x).setColor(Color.BLUE);
            }
            cardNames.remove(draw);
        }
    }
//
//    public void swapCards(Card c){
//        List tempSpots = c.moveableSpots;
//        String tempName = c.name;
//        c.setName(cardSpots.get(2).name);
//        c.setMoveableSpots(cardSpots.get(2).moveableSpots);
//        c.setColor(Color.GRAY);
//        cardSpots.get(2).setMoveableSpots(tempSpots);
//        cardSpots.get(2).setName(tempName);
//
//
//    }

    public void highlightCard(Card c, boolean highlight){
        c.setActivated(highlight);
        c.setBackgroundColor(highlight? Color.YELLOW:Color.GRAY);
        selectedCard = highlight?c:null;
    }

    public boolean hasSelectedCard(){
        return selectedCard!=null;
    }
}
