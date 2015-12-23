package com.bossmonster.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bossmonster.R;
import com.bossmonster.objects.Card;
import com.bossmonster.utils.L;

import java.util.ArrayList;

/**
 * Created by darkbobo on 12/22/15.
 */
public class HandCardAdapter extends MyBaseAdapter {
	ArrayList<Card> hand;

	public HandCardAdapter(Context context, ArrayList<Card> hand){
		super(context);
		this.hand = hand;
	}
	@Override
	public int getCount() {
		return hand.size();
	}

	@Override
	public Object getItem(int position) {
		return hand.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView == null){
			convertView = inflater.inflate(R.layout.row_hand_card, parent, false);
			holder = new ViewHolder();
			holder.cardImage = (ImageView)convertView.findViewById(R.id.card_image);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder)convertView.getTag();
		}

		Card card = (Card)getItem(position);
		holder.cardImage.setImageResource(card.getResourceID());
		L.e(card.getCardName() + " " + card.getCardID() + " " + card.getResourceID());
		return convertView;
	}

	private class ViewHolder{
		ImageView cardImage;
	}
}
