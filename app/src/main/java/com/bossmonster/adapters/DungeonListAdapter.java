package com.bossmonster.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bossmonster.R;
import com.bossmonster.model.Player;
import com.bossmonster.objects.Card;
import com.bossmonster.objects.rooms.Room;
import com.bossmonster.objects.treasures.ClericTreasure;
import com.bossmonster.objects.treasures.MageTreasure;
import com.bossmonster.objects.treasures.ThiefTreasure;
import com.bossmonster.objects.treasures.WarriorTreasure;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by darkbobo on 12/21/15.
 */
public class DungeonListAdapter extends MyBaseAdapter {
	ArrayList<Player> players;

	public DungeonListAdapter(Context context, ArrayList<Player> players){
		super(context);
		this.players = players;
	}

	@Override
	public int getCount() {
		return players.size();
	}

	@Override
	public Object getItem(int position) {
		return players.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView == null){
			convertView = inflater.inflate(R.layout.row_player, parent, false);
			holder = new ViewHolder();
			holder.playerName = (TextView)convertView.findViewById(R.id.player_name);
			holder.clericTreasure = (TextView)convertView.findViewById(R.id.player_clerics);
			holder.warriorTreasure = (TextView)convertView.findViewById(R.id.player_warriors);
			holder.mageTreasure = (TextView)convertView.findViewById(R.id.player_mages);
			holder.thiefTreasure = (TextView)convertView.findViewById(R.id.player_thieves);
			holder.playerBossCard = (ImageView)convertView.findViewById(R.id.player_boss_card);
			holder.playerDungeon1 = (ImageView)convertView.findViewById(R.id.player_dungeon_1);
			holder.playerDungeon2 = (ImageView)convertView.findViewById(R.id.player_dungeon_2);
			holder.playerDungeon3 = (ImageView)convertView.findViewById(R.id.player_dungeon_3);
			holder.playerDungeon4 = (ImageView)convertView.findViewById(R.id.player_dungeon_4);
			holder.playerDungeon5 = (ImageView)convertView.findViewById(R.id.player_dungeon_5);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder)convertView.getTag();
		}

		Player player = (Player)getItem(position);
		holder.playerName.setText(player.getName());
		holder.clericTreasure.setText(Integer.toString(player.getNumMatchingTreasures(new ClericTreasure())));
		holder.warriorTreasure.setText(Integer.toString(player.getNumMatchingTreasures(new WarriorTreasure())));
		holder.mageTreasure.setText(Integer.toString(player.getNumMatchingTreasures(new MageTreasure())));
		holder.thiefTreasure.setText(Integer.toString(player.getNumMatchingTreasures(new ThiefTreasure())));

		// set images
		ArrayList<Room> dungeon = player.getDungeon();
		if(dungeon.size() >= 1 && dungeon.get(0) != null){
			holder.playerDungeon1.setImageResource(dungeon.get(0).getResourceID());
		}
		if(dungeon.size() >= 2 && dungeon.get(1) != null){
			holder.playerDungeon2.setImageResource(dungeon.get(1).getResourceID());
		}
		if(dungeon.size() >= 3 && dungeon.get(2) != null){
			holder.playerDungeon3.setImageResource(dungeon.get(2).getResourceID());
		}
		if(dungeon.size() >= 4 && dungeon.get(3) != null){
			holder.playerDungeon4.setImageResource(dungeon.get(3).getResourceID());
		}
		if(dungeon.size() >= 5 && dungeon.get(4) != null){
			holder.playerDungeon5.setImageResource(dungeon.get(4).getResourceID());
		}
		return convertView;
	}

	private class ViewHolder{
		TextView playerName;
		TextView clericTreasure;
		TextView warriorTreasure;
		TextView mageTreasure;
		TextView thiefTreasure;
		ImageView playerBossCard;
		ImageView playerDungeon1;
		ImageView playerDungeon2;
		ImageView playerDungeon3;
		ImageView playerDungeon4;
		ImageView playerDungeon5;
	}
}
