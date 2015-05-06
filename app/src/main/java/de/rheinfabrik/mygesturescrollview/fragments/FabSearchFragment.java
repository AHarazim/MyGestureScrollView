package de.rheinfabrik.mygesturescrollview.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.rheinfabrik.mygesturescrollview.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class FabSearchFragment extends Fragment implements GestureDetector.OnGestureListener, View.OnTouchListener {

    private static final String TAG = FabSearchFragment.class.getSimpleName();

    @InjectView(R.id.searchFragmentRoot)
    RelativeLayout mSearchFragmentRoot;

    private GestureDetectorCompat mDetector;

    private boolean mSearchFragmentVisible = false;

    public FabSearchFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fab_search, container, false);
        rootView.setOnTouchListener(this);
        ButterKnife.inject(this, rootView);

        mDetector = new GestureDetectorCompat(getActivity(), this);
//        getActivity().getSupportFragmentManager().beginTransaction()
//                .add(R.id.searchFragmentContainer, new SearchFragment())
//                .commit();

        return rootView;
    }


    @OnClick(R.id.fab)
    public void onClickFab() {
        if (mSearchFragmentVisible) {
            closeSearch();
        } else {
            openSearch();
        }

    }


    private void openSearch() {
        mSearchFragmentRoot.setVisibility(View.VISIBLE);
        mSearchFragmentRoot.setTranslationY(mSearchFragmentRoot.getHeight() / 4);
        mSearchFragmentVisible = true;
    }

    private void closeSearch() {
        mSearchFragmentRoot.setVisibility(View.GONE);
        mSearchFragmentVisible = false;
    }

    // TouchListener

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d(TAG, event.toString());
        if (event.getAction() == MotionEvent.ACTION_UP) {
            int viewYPos = (int) mSearchFragmentRoot.getY();
            if (viewYPos < mSearchFragmentRoot.getHeight() / 4) {
                mSearchFragmentRoot.animate().translationY(0).setDuration(200).start();
            } else {
                mSearchFragmentRoot.animate().translationY(mSearchFragmentRoot.getHeight()).setDuration(500).start();

            }

        }

        return this.mDetector.onTouchEvent(event);
    }


    // GestureDetector

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        mSearchFragmentRoot.setY(mSearchFragmentRoot.getY() - distanceY);
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
