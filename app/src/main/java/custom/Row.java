package custom;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Stuart on 3/16/2017.
 */

public class Row extends LinearLayout {


    public Row(Context context) {
        super(context);
    }

    public Row(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        ViewGroup.LayoutParams params = this.getLayoutParams();
//        params.height = 130;
//        this.setLayoutParams(params);
    }

    public Row(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Row(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public Space getChildAt(int i){
        return (Space) super.getChildAt(i);
    }
}
