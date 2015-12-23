package com.bossmonster.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bossmonster.R;

/**
 * Created by darkbobo on 12/20/15.
 */
public class GameViewFragment extends BaseFragment {

	public GameViewFragment(){

	}

	public static GameViewFragment newInstance(){
		GameViewFragment fragment = new GameViewFragment();

		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_game_view, container, false);

		return rootView;
	}

	@Override
	public void registerComponents() {

	}
}
