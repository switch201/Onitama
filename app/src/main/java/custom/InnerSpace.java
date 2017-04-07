package custom;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Stuart on 3/18/2017.
 */

public class InnerSpace extends View {
    public InnerSpace(Context context) {
        super(context);
        this.setBackgroundColor(Color.WHITE);
    }

    public InnerSpace(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setBackgroundColor(Color.WHITE);
    }

    public InnerSpace(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setBackgroundColor(Color.WHITE);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InnerSpace(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.setBackgroundColor(Color.WHITE);
    }
}
