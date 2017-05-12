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
    public ArrayList<Card> cardSpots;
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
            cardNames.remove(draw);
        }
    }

    public void playCard(){
        String name = cardSpots.get(2).name;
        List spots = cardSpots.get(2).moveableSpots;
        cardSpots.get(2).setCard(selectedCard);
        selectedCard.setMoveableSpots(spots);
        selectedCard.setName(name);
        selectedCard=null;
    }



    public void highlightCard(Card c, boolean highlight){
        c.setActivated(highlight);
        c.setBackgroundColor(highlight? Color.YELLOW:Color.GRAY);
        selectedCard = highlight?c:null;
    }

    public boolean hasSelectedCard(){

        return selectedCard!=null;
    }

    public boolean isPlayersCard(GameState gs){
        return selectedCard.controller == gs.activePlayer;
    }
}
