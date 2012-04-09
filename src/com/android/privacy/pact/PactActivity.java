package com.android.privacy.pact;

import java.util.List;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.privacy.*;
import android.util.Log;


import android.os.Bundle;

public class PactActivity extends Activity {
    /** Called when the activity is first created. */
	private static final String TAG = "PactActivity";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		final PrivacySettingsManager privacyMan =
				(PrivacySettingsManager)getSystemService("privacy");
		Log.d(TAG, "PrivacyServiceAvailable? " + privacyMan.isServiceAvailable());
		
		
		final PackageManager packageMan = getPackageManager();
		List<ApplicationInfo> packages = packageMan
		          .getInstalledApplications(PackageManager.GET_META_DATA);
		
		for (ApplicationInfo packageInfo : packages) {
			Log.d(TAG, "Installed package :" + packageInfo.packageName + "uid: " + packageInfo.uid);
			PrivacySettings privacyInfo = privacyMan.getSettings(packageInfo.packageName, packageInfo.uid);
			
			if(privacyInfo == null)
				privacyInfo = new PrivacySettings(0, packageInfo.packageName, packageInfo.uid);

			Log.d(TAG, "Privacy settings :" + privacyInfo.describeContents());
			
			
			if (packageInfo.packageName == "com.android.browser") {
				
			}
		}
		

    }
}