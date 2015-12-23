package com.bossmonster.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bossmonster.R;
import com.bossmonster.activities.MainActivity;

/**
 * Created by darkbobo on 12/19/15.
 */
public class ToolbarFragment extends Fragment {
	View rootView;
	public static final String SCREEN_ARG = "screenArguments";
	Button gameScreen;
	Button otherDungeons;

	public ToolbarFragment(){

	}

	public static ToolbarFragment newInstance(int screen){
		ToolbarFragment fragment = new ToolbarFragment();
		Bundle args = new Bundle();
		args.putInt(SCREEN_ARG, screen);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_toolbar, container, false);
		int screen = getArguments().getInt(SCREEN_ARG);
		initViews();
		initListeners();
		resetButtons();
		switch (screen){
			case 0:
				gameScreen.setBackgroundColor(Color.BLUE);
				break;
			case 1:
				otherDungeons.setBackgroundColor(Color.BLUE);
		}
		return rootView;
	}

	public void resetButtons(){
		gameScreen.setBackgroundColor(Color.WHITE);
		otherDungeons.setBackgroundColor(Color.WHITE);
	}

	public void initViews(){
		gameScreen = (Button)rootView.findViewById(R.id.game_screen);
		otherDungeons = (Button)rootView.findViewById(R.id.other_players);
	}

	public void initListeners(){
		gameScreen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				MainActivity.changeScreen(ScreenKeys.GAME_VIEW);
			}
		});
		otherDungeons.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				MainActivity.changeScreen(ScreenKeys.DUNGEON_LIST);
			}
		});
	}
}
