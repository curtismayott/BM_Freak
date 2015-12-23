package com.bossmonster.objects.treasures;

/**
 * Created by darkbobo on 12/19/15.
 */
public class Treasure {
	public boolean isCleric(){
		return false;
	}
	public boolean isWarrior(){
		return false;
	}
	public boolean isTheif(){
		return false;
	}
	public boolean isMage(){
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if(isCleric() && ((Treasure)o).isCleric()){
			return true;
		}else if(isMage() && ((Treasure)o).isMage()){
			return true;
		}else if(isWarrior() && ((Treasure)o).isWarrior()){
			return true;
		}else if(isTheif() && ((Treasure)o).isTheif()){
			return true;
		}
		return false;
	}
}
