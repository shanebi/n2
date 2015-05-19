package interfacen2.sceens;

import interfacen2.manag.AdaptEcran;
import interfacen2.manag.My2GdxGame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class nouvCam implements Screen{
	 My2GdxGame game;
	 Texture otarie;
	 TextureRegion MonOtarie;
	 SpriteBatch batch;
	 OrthographicCamera camera;
	 
	 int x0, y0; // position du doigt

		int lastx0; // précédente position du 1er doigt
		int lasty0; // précédente position du 1er doigt

		public static float vitesse_deplacement_camera = 20;


		private int limite_image_maxLargeur; // limite déplacement camera
		public static int limite_image_minHauteur = 0; // limite déplacement camera
		public static int limite_image_minLargeur = 0; // limite déplacement camera
	private float largeur_Ecran;
	private float hauteur_Ecran;
	 
	 public nouvCam(My2GdxGame g) {

			game = g;

		}

	

	@Override
	public void resize(int width, int height) {
		
		  camera.setToOrtho(false,width,height);
		
	}


	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {

		MonOtarie.getTexture().dispose();
		  batch.dispose();
	}

	@Override
	public void show() {
		largeur_Ecran = AdaptEcran.setEcranLargeur(800);
		hauteur_Ecran = AdaptEcran.setEcranLargeur(320);
		 // load assets
		  otarie=new Texture(Gdx.files.internal("map3.png"));
		  limite_image_maxLargeur = otarie.getWidth() / 2;
		  MonOtarie=new TextureRegion(otarie,0,0,1024,512);
		  limite_image_maxLargeur = otarie.getWidth() / 2;
		  batch=new SpriteBatch();
		  // create viewport
		  camera=new OrthographicCamera();
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(1,1,1, 1);
		  Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		  // render our images
		  batch.setProjectionMatrix(camera.combined);
		  batch.begin();
		  batch.draw(MonOtarie,0,0,largeur_Ecran,hauteur_Ecran);
		  batch.end();
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

}
