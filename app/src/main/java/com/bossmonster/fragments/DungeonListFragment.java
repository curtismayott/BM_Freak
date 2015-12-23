package com.bossmonster.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bossmonster.R;
import com.bossmonster.activities.MainActivity;
import com.bossmonster.adapters.DungeonListAdapter;

import java.util.List;

/**
 * Created by darkbobo on 12/20/15.
 */
public class DungeonListFragment extends BaseFragment {
	ListView playerList;
	DungeonListAdapter adapter;
	public DungeonListFragment(){

	}

	public static DungeonListFragment newInstance(){
		DungeonListFragment fragment = new DungeonListFragment();

		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_dungeon_list, container, false);
		playerList = (ListView)rootView.findViewById(R.id.player_list);
		adapter = new DungeonListAdapter(getActivity(), MainActivity.game.getPlayers());
		playerList.setAdapter(adapter);
		return rootView;
	}

	@Override
	public void registerComponents() {

	}
}
