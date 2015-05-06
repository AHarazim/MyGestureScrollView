package de.rheinfabrik.mygesturescrollview.fragments;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class TouchInterceptingRelativeLayout extends RelativeLayout {


    private static final String DEBUG_TAG = TouchInterceptingRelativeLayout.class.getSimpleName();

    private GestureDetectorCompat mDetector;

    public TouchInterceptingRelativeLayout(Context context) {
        super(context);
        setup();
    }

    public TouchInterceptingRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public TouchInterceptingRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup() {
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        Log.d(DEBUG_TAG, "onInterceptTouchEvent " + ev.toString());

        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            return true;
        }

        return false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(DEBUG_TAG, "onTouchEvent" + event.toString());
        return super.onTouchEvent(event);
    }
}
