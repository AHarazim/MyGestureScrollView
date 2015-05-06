package de.rheinfabrik.mygesturescrollview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import de.rheinfabrik.mygesturescrollview.fragments.FabSearchFragment;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new FabSearchFragment())
                    .commit();
        }
    }
}
