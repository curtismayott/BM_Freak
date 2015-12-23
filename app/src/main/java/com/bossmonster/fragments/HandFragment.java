package com.bossmonster.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bossmonster.R;
import com.bossmonster.activities.MainActivity;
import com.bossmonster.adapters.HandCardAdapter;
import com.bossmonster.adapters.HandDungeonAdapter;
import com.bossmonster.objects.Card;
import com.bossmonster.objects.rooms.Room;
import com.bossmonster.views.HorizontalListView;

import java.util.ArrayList;

/**
 * Created by darkbobo on 12/20/15.
 */
public class HandFragment extends BaseFragment {

	public HandFragment(){

	}

	public static HandFragment newInstance(){
		HandFragment fragment = new HandFragment();

		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_hand, container, false);
		HorizontalListView handList = (HorizontalListView)rootView.findViewById(R.id.hand_list);
		HandCardAdapter cardAdapter = new HandCardAdapter(getActivity(), MainActivity.game.getPlayers().get(0).getHand());
		handList.setAdapter(cardAdapter);
		return rootView;
	}

	@Override
	public void registerComponents() {

	}
}
