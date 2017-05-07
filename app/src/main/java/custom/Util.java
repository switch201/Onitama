package custom;

import android.graphics.Point;

import com.example.stuart.onitama4.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Stuart on 4/12/2017.
 */

public class Util {
    public static final int[] SPACE_IDS = {
            R.id.button00,
            R.id.button01,
            R.id.button02,
            R.id.button03,
            R.id.button04,
            R.id.button10,
            R.id.button11,
            R.id.button12,
            R.id.button13,
            R.id.button14,
            R.id.button20,
            R.id.button21,
            R.id.button22,
            R.id.button23,
            R.id.button24,
            R.id.button30,
            R.id.button31,
            R.id.button32,
            R.id.button33,
            R.id.button34,
            R.id.button40,
            R.id.button41,
            R.id.button42,
            R.id.button43,
            R.id.button44
    };

    public static final int[] CARD_IDS = {
            R.id.top1,
            R.id.top2,
            R.id.middle,
            R.id.bottom1,
            R.id.bottom2
    };



   public static final LinkedHashMap<String,List<Point>> CARDS;
    static
    {
        CARDS = new LinkedHashMap<>();
        CARDS.put("Tiger", Arrays.asList(new Point(0,-1),new Point(0,2)));
        CARDS.put("Dragon", Arrays.asList(new Point(-2,1),new Point(-1,-1), new Point(1,-1), new Point(2,1)));
        CARDS.put("Frog", Arrays.asList(new Point(-2,0),new Point(-1,1), new Point(1,-1)));
        CARDS.put("Rabbit", Arrays.asList(new Point(-1,-1),new Point(1,1), new Point(2,0)));
        CARDS.put("Crab", Arrays.asList(new Point(-2,0),new Point(0,1), new Point(2,0)));
        CARDS.put("Elephant", Arrays.asList(new Point(-1,0),new Point(-1,1), new Point(1,0), new Point(1,1)));
        CARDS.put("Goose", Arrays.asList(new Point(-1,0),new Point(-1,1), new Point(1,0), new Point(1,-1)));
        CARDS.put("Rooster", Arrays.asList(new Point(-1,0),new Point(-1,-1), new Point(1,0), new Point(1,1)));
        CARDS.put("Monkey", Arrays.asList(new Point(-1,1),new Point(-1,1), new Point(1,1), new Point(1,-1)));
        CARDS.put("Mantis", Arrays.asList(new Point(-1,1),new Point(0,-1), new Point(1,1)));
        CARDS.put("Horse", Arrays.asList(new Point(-1,0),new Point(0,1), new Point(0,-1)));
        CARDS.put("Ox", Arrays.asList(new Point(0,1),new Point(1,0), new Point(0,-1)));
        CARDS.put("Crane", Arrays.asList(new Point(-1,-1),new Point(0,1), new Point(1,-1)));
        CARDS.put("Boar", Arrays.asList(new Point(-1,0),new Point(0,1), new Point(1,0)));
        CARDS.put("Eel", Arrays.asList(new Point(-1,1),new Point(-1,-1), new Point(1,0)));
        CARDS.put("Cobra",Arrays.asList(new Point(-1,0),new Point(1,1), new Point(1,-1)));
    }

    public static LinkedHashMap<String,List<Point>> flipedCards(){
        LinkedHashMap<String,List<Point>> flippedCards = new LinkedHashMap<>();
        Iterator<String> cards = CARDS.keySet().iterator();
        while(cards.hasNext()){
            String cardName = cards.next();
            Iterator<Point> points = CARDS.get(cardName).iterator();
            List<Point> flippedPoints = new ArrayList<Point>();
            while (points.hasNext()){
                Point normalPoint = points.next();
                flippedPoints.add(new Point(-normalPoint.x,-normalPoint.y));
            }
            flippedCards.put(cardName,flippedPoints);
        }
        return flippedCards;
    }

}
