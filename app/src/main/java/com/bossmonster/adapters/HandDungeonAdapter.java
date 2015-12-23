package com.bossmonster.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bossmonster.R;
import com.bossmonster.objects.rooms.Room;

import java.util.ArrayList;

/**
 * Created by darkbobo on 12/22/15.
 */
public class HandDungeonAdapter extends MyBaseAdapter {
	ArrayList<Room> rooms;

	public HandDungeonAdapter(Context context, ArrayList<Room> rooms){
		super(context);
		this.rooms = rooms;
	}

	@Override
	public int getCount() {
		return rooms.size();
	}

	@Override
	public Object getItem(int position) {
		return rooms.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView == null){
			convertView = inflater.inflate(R.layout.row_hand_dungeon, parent, false);
			holder = new ViewHolder();
			holder.cardImage = (ImageView)convertView.findViewById(R.id.card_image);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder)convertView.getTag();
		}

		Room room = (Room)getItem(position);
		holder.cardImage.setImageResource(room.getResourceID());

		return convertView;
	}

	private class ViewHolder{
		ImageView cardImage;
	}
}
