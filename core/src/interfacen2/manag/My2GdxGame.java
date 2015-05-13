package interfacen2.manag;

import interfacen2.sceens.ImageLancement;

import com.badlogic.gdx.Game;



public class My2GdxGame extends Game{

	@Override
	public void create() {

		setScreen(new ImageLancement(this));

	}
}
