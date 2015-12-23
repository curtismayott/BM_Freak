package com.bossmonster.listeners;

import android.view.View;
import android.view.View.OnClickListener;

import com.bossmonster.fragments.BaseFragment;

import java.util.HashMap;

/**
 * Created by darkbobo on 12/20/15.
 */
public class MyOnClickListener implements OnClickListener {
	HashMap<String,View> components;
	BaseFragment view;

	@Override
	public void onClick(View v) {

	}

	public void registerComponent(String key, View component){
		components.put(key, component);
	}

	public void registerView(BaseFragment fragment){
		this.view = fragment;
	}
}
