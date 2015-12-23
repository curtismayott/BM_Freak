package com.bossmonster.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bossmonster.R;
import com.bossmonster.activities.MainActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainMenuActivityFragment extends Fragment {

	public MainMenuActivityFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main_menu, container, false);
		Button startGame = (Button)rootView.findViewById(R.id.start_game_button);
		startGame.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(v.getContext(), MainActivity.class));
			}
		});
		return rootView;
	}
}
