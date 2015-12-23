package com.bossmonster.utils;

import android.util.Log;

/**
 * Created by darkbobo on 12/20/15.
 */
public class L {
	public static void e(String text){
		e("BossMonster", text);
	}
	public static void e(String tag, String text){
		Log.e(tag, text);
	}
	public static void d(String text){
		d("BossMonster Debug", text);
	}
	public static void d(String tag, String text){
		Log.d(tag, text);
	}
}
