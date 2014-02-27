package net.eunjae.android.boilerplate.ui.activity;

import android.os.Bundle;

import net.eunjae.android.boilerplate.R;
import net.eunjae.android.boilerplate.ui.activity.base.FragmentBaseActivity;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_start)
public class StartActivity extends FragmentBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityFragment(savedInstanceState, R.id.container, R.layout.fragment_start);
    }
}
