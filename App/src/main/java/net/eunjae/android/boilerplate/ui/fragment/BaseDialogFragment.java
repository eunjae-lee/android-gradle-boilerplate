package net.eunjae.android.boilerplate.ui.fragment;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v4.app.DialogFragment;

public class BaseDialogFragment extends DialogFragment {
    private Runnable dismissCallback;
    private Runnable cancelCallback;

    public BaseDialogFragment dismissListener(Runnable dismissCallback) {
        this.dismissCallback = dismissCallback;
        return this;
    }

    public BaseDialogFragment cancelListener(Runnable cancelCallback) {
        this.cancelCallback = cancelCallback;
        return this;
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        if (cancelCallback != null) {
            cancelCallback.run();
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (dismissCallback != null) {
            dismissCallback.run();
        }
    }

    protected DialogInterface.OnClickListener wrapOnClickListener(final DialogInterface.OnClickListener onClickListener) {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialogInterface, final int i) {
                dismiss();
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        onClickListener.onClick(dialogInterface, i);
                    }
                });
            }
        };
    }
}
