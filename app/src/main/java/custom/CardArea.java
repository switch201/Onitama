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
    ArrayList<Card> player1Spots;
    ArrayList<Card> player2Spots;
    Card middleSpot;
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
        inizilizeCards(m,cardSpots);
    }

    public void inizilizeCards(MainActivity m,ArrayList<Card> cardSpots){
        player1Spots = new ArrayList<Card>();
        player2Spots = new ArrayList<Card>();
        ArrayList<String> cardNames = new ArrayList(Util.CARDS.keySet());
        for(int x = 0;x<cardSpots.size();x++){
            int draw = new Random().nextInt(cardNames.size());
            String cardName = cardNames.get(draw);
            List moveableSpaces = Util.CARDS.get(cardName);
            
            if(x<2){
                player2Spots.add(cardSpots.get(x));
                player2Spots.get(x).setMoveableSpots(moveableSpaces);
                player2Spots.get(x).setName(cardName);
                player2Spots.get(x).setOnClickListener(m);
            }
            else if(x==2){
                middleSpot = cardSpots.get(x);
                middleSpot.setMoveableSpots(moveableSpaces);
                middleSpot.setName(cardName);
                middleSpot.setOnClickListener(m);
            }
            else {
                int y = x - 3;
                player1Spots.add(cardSpots.get(x));
                player1Spots.get(y).setMoveableSpots(moveableSpaces);
                player1Spots.get(y).setName(cardName);
                player1Spots.get(y).setOnClickListener(m);
            }
            cardNames.remove(draw);
        }
    }



    public void highlightCard(Card c, boolean highlight){
        c.setActivated(highlight);
        c.setBackgroundColor(highlight? Color.YELLOW:Color.GRAY);
        selectedCard = highlight?c:null;
    }

    public boolean hasSelectedCard(){
        return selectedCard!=null;
    }
}
