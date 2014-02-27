package net.eunjae.android.boilerplate.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SimplePlaceholderFragment extends android.support.v4.app.Fragment {

    private final int layoutResId;

    public SimplePlaceholderFragment(int layoutResId) {
        this.layoutResId = layoutResId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(layoutResId, container, false);
        return rootView;
    }
}
