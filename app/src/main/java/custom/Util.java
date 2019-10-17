package custom;

import android.graphics.Color;
import android.graphics.Point;

import com.example.stuart.onitama4.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

    public static final int SPACE_BACKGROUND_DEFAULT = 0;
    public static final int SPACE_BACKGROUND_HIGHLIGHT= Color.YELLOW;
    public static final int SPACE_BACKGROUND_TARGET = Color.RED;



   public static final LinkedHashMap<String,LinkedHashMap<String,List<Integer>>> CARDS;
    static
    {
        CARDS = new LinkedHashMap<>();
        LinkedHashMap DATA = new LinkedHashMap<>();
        DATA.put("movableSpaces", Arrays.asList(new Point(0,-1),new Point(0,2)));
        DATA.put("src", Arrays.asList(R.drawable.tiger_card));
        CARDS.put("Tiger", DATA);

        DATA = new LinkedHashMap<>();
        DATA.put("movableSpaces", Arrays.asList(new Point(2,1),new Point(1,-1), new Point(-1,-1), new Point(-2,1)));
        DATA.put("src", Arrays.asList(R.drawable.dragon_card));
        CARDS.put("Dragon", DATA);

        DATA = new LinkedHashMap<>();
        DATA.put("movableSpaces", Arrays.asList(new Point(2,0),new Point(1,1), new Point(-1,-1)));
        DATA.put("src", Arrays.asList(R.drawable.frog_card));
        CARDS.put("Frog", DATA);

        DATA = new LinkedHashMap<>();
        DATA.put("movableSpaces", Arrays.asList(new Point(1,-1),new Point(-1,1), new Point(-2,0)));
        DATA.put("src", Arrays.asList(R.drawable.rabbit_card));
        CARDS.put("Rabbit", DATA);

        DATA = new LinkedHashMap<>();
        DATA.put("movableSpaces", Arrays.asList(new Point(2,0),new Point(0,1), new Point(-2,0)));
        DATA.put("src", Arrays.asList(R.drawable.crab_card));
        CARDS.put("Crab", DATA);

        DATA = new LinkedHashMap<>();
        DATA.put("movableSpaces", Arrays.asList(new Point(1,0),new Point(1,1), new Point(-1,0), new Point(-1,1)));
        DATA.put("src", Arrays.asList(R.drawable.elephant_card));
        CARDS.put("Elephant", DATA);

        DATA = new LinkedHashMap<>();
        DATA.put("movableSpaces", Arrays.asList(new Point(1,0),new Point(1,1), new Point(-1,0), new Point(-1,-1)));
        DATA.put("src", Arrays.asList(R.drawable.goose_card));
        CARDS.put("Goose", DATA);

        DATA = new LinkedHashMap<>();
        DATA.put("movableSpaces", Arrays.asList(new Point(1,0),new Point(1,-1), new Point(-1,0), new Point(-1,1)));
        DATA.put("src", Arrays.asList(R.drawable.rooster_card));
        CARDS.put("Rooster", DATA);

        DATA = new LinkedHashMap<>();
        DATA.put("movableSpaces", Arrays.asList(new Point(1,1),new Point(1,1), new Point(-1,1), new Point(-1,-1)));
        DATA.put("src", Arrays.asList(R.drawable.monkey_card));
        CARDS.put("Monkey", DATA);

        DATA = new LinkedHashMap<>();
        DATA.put("movableSpaces", Arrays.asList(new Point(1,1),new Point(0,-1), new Point(-1,1)));
        DATA.put("src", Arrays.asList(R.drawable.mantis_card));
        CARDS.put("Mantis", DATA);

        DATA = new LinkedHashMap<>();
        DATA.put("movableSpaces", Arrays.asList(new Point(1,0),new Point(0,1), new Point(0,-1)));
        DATA.put("src", Arrays.asList(R.drawable.horse_card));
        CARDS.put("Horse", DATA);

        DATA = new LinkedHashMap<>();
        DATA.put("movableSpaces", Arrays.asList(new Point(0,1),new Point(-1,0), new Point(0,-1)));
        DATA.put("src", Arrays.asList(R.drawable.ox_card));
        CARDS.put("Ox", DATA);

        DATA = new LinkedHashMap<>();
        DATA.put("movableSpaces", Arrays.asList(new Point(1,-1),new Point(0,1), new Point(-1,-1)));
        DATA.put("src", Arrays.asList(R.drawable.crane_card));
        CARDS.put("Crane", DATA);

        DATA = new LinkedHashMap<>();
        DATA.put("movableSpaces", Arrays.asList(new Point(1,0),new Point(0,1), new Point(-1,0)));
        DATA.put("src", Arrays.asList(R.drawable.boar_card));
        CARDS.put("Boar", DATA);

        DATA = new LinkedHashMap<>();
        DATA.put("movableSpaces", Arrays.asList(new Point(1,1),new Point(1,-1), new Point(-1,0)));
        DATA.put("src", Arrays.asList(R.drawable.eel_card));
        CARDS.put("Eel", DATA);

        DATA = new LinkedHashMap<>();
        DATA.put("movableSpaces", Arrays.asList(new Point(1,0),new Point(-1,1), new Point(-1,-1)));
        DATA.put("src", Arrays.asList(R.drawable.cobra_card));
        CARDS.put("Cobra", DATA);
    }
}
