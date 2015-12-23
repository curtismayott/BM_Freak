package com.bossmonster.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.bossmonster.R;
import com.bossmonster.fragments.BaseFragment;
import com.bossmonster.fragments.GameViewFragment;
import com.bossmonster.fragments.HandFragment;
import com.bossmonster.fragments.DungeonListFragment;
import com.bossmonster.fragments.ScreenKeys;
import com.bossmonster.fragments.ToolbarFragment;
import com.bossmonster.listeners.DungeonListListener;
import com.bossmonster.listeners.GameViewListener;
import com.bossmonster.listeners.HandListener;
import com.bossmonster.listeners.MyOnClickListener;
import com.bossmonster.model.Game;
import com.bossmonster.model.TestData;

import java.util.HashMap;


public class MainActivity extends FragmentActivity {
	static FragmentManager manager;
	FrameLayout toolbar;
	FrameLayout viewContainer;
	public static HashMap<String,BaseFragment> fragments;
	public HashMap<String,MyOnClickListener> listeners;
	public static Game game;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);

		toolbar = (FrameLayout) findViewById(R.id.toolbar_fragment);
		viewContainer = (FrameLayout)findViewById(R.id.view_fragment);
		initMVC();
		game = new Game();
		game.startGame(TestData.setupPlayers());
		game.dealFirstHand();

		manager = getSupportFragmentManager();
		updateToolbar(0);
		manager.beginTransaction().replace(R.id.view_fragment, fragments.get(ScreenKeys.GAME_VIEW)).commit();
		manager.beginTransaction().add(R.id.hand_fragment, HandFragment.newInstance()).commit();
	}

	public static void changeScreen(String newScreen){
		manager.beginTransaction().replace(R.id.view_fragment, fragments.get(newScreen)).commit();
		if(newScreen.equals(ScreenKeys.GAME_VIEW)){
			updateToolbar(0);
		}else if(newScreen.equals(ScreenKeys.DUNGEON_LIST)){
			updateToolbar(1);
		}
	}

	public static void updateToolbar(int position){
		manager.beginTransaction().add(R.id.toolbar_fragment, ToolbarFragment.newInstance(position)).commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	public void initMVC(){
		fragments = new HashMap<>();
		fragments.put(ScreenKeys.GAME_VIEW, GameViewFragment.newInstance());
		fragments.put(ScreenKeys.DUNGEON_LIST, DungeonListFragment.newInstance());

		listeners = new HashMap<>();
		listeners.put(ScreenKeys.GAME_VIEW, new GameViewListener());
		listeners.put(ScreenKeys.DUNGEON_LIST, new DungeonListListener());

		for(String key : fragments.keySet()){
			fragments.get(key).registerController(listeners.get(key));
			listeners.get(key).registerView(fragments.get(key));
		}
	}
}
