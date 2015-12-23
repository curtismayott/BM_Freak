package com.bossmonster.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.bossmonster.listeners.MyOnClickListener;

/**
 * Created by darkbobo on 12/19/15.
 */
public class BaseFragment extends Fragment {
	Context context;
	View rootView;
	MyOnClickListener controller;

	public void registerController(MyOnClickListener controller){
		this.controller = controller;
	}

	public void registerComponents(){

	}
}
