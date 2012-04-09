package com.android.privacy.pact;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PactReceiver extends BroadcastReceiver {

	private static final String TAG = "PactReceiver";
	
	@Override
	public void onReceive(Context arg0, Intent intent) {
		String packageName = intent.getStringExtra("packageName");
		int uid = intent.getIntExtra("uid", 0);
		byte accessMode = intent.getByteExtra("accessMode", (byte)0);
		String dataType = intent.getStringExtra("packageName");
		String output = intent.getStringExtra("packageName");
		
		Log.d(TAG, packageName + "." + uid + "; " + dataType + ":" + accessMode + "<" + output + ">");
	}

}
