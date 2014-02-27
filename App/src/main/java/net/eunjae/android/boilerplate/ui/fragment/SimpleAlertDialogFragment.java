package net.eunjae.android.boilerplate.ui.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;

public class SimpleAlertDialogFragment extends BaseDialogFragment {

	private int titleResId;
	private int positiveButtonTextResId;
	private DialogInterface.OnClickListener positiveButtonOnClickListener;
	private int messageResId;

    public SimpleAlertDialogFragment title(int titleResId) {
		this.titleResId = titleResId;
		return this;
	}

	public SimpleAlertDialogFragment message(int messageResId) {
		this.messageResId = messageResId;
		return this;
	}

	public SimpleAlertDialogFragment positiveButton(int textResId, DialogInterface.OnClickListener onClickListener) {
		this.positiveButtonTextResId = textResId;
		this.positiveButtonOnClickListener = onClickListener;
		return this;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder;
		builder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), android.R.style.Theme_Holo_Dialog));
		builder.setMessage("asdf");
		if (titleResId > 0) {
			builder.setTitle(titleResId);
		}
		if (messageResId > 0) {
			builder.setMessage(messageResId);
		}
		if (positiveButtonTextResId > 0 && positiveButtonOnClickListener != null) {
            builder.setPositiveButton(positiveButtonTextResId, wrapOnClickListener(positiveButtonOnClickListener));
        }
        return builder.create();
	}
}
