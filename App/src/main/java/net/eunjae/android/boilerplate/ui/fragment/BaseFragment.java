package net.eunjae.android.boilerplate.ui.fragment;

import android.support.v4.app.Fragment;
import net.eunjae.android.aevent.manager.AEventManager;
import net.eunjae.android.aevent.manager.AStickyEventManager;

public class BaseFragment extends Fragment {

	@Override
	public void onResume() {
		super.onResume();
		AStickyEventManager.getInstance().firePendingEvents(this);
		AEventManager.getInstance().register(this);
	}

	@Override
	public void onPause() {
		super.onPause();
		AEventManager.getInstance().unregister(this);
	}

	@Override
	public void onStop() {
		super.onStop();
	}
}
