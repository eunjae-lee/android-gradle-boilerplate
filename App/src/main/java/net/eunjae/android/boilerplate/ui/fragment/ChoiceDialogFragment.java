package net.eunjae.android.boilerplate.ui.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.ContextThemeWrapper;

import java.util.ArrayList;

public class ChoiceDialogFragment extends BaseDialogFragment {

    private final int titleStringResId;
    private ArrayList<Pair<Integer, Runnable>> items = new ArrayList<Pair<Integer, Runnable>>();

    public ChoiceDialogFragment(int titleStringResId) {
        this.titleStringResId = titleStringResId;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ArrayList<String> strings = new ArrayList<String>();
        for (Pair<Integer, Runnable> item : items) {
            strings.add(getResources().getString(item.first));
        }
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), android.R.style.Theme_Holo_Dialog));
        builder.setTitle(titleStringResId)
                .setItems(strings.toArray(new CharSequence[strings.size()]), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                        new Handler().post(items.get(which).second);
                    }
                });
        return builder.create();
    }

    public ChoiceDialogFragment add(int itemStringResId, Runnable action) {
        items.add(new Pair<Integer, Runnable>(itemStringResId, action));
        return this;
    }
}
