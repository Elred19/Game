
package item.potion;

import main.Game;

public class MegaLifePotion extends Potion {
	int price;
	public MegaLifePotion(Game game,int price) {
		super("LIFE_POTION", game, price);
		this.price = price;
	}
	@Override
	public void apply() {
		game.player.life += 30;
		
	}
}
