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
	private int largeur_Ecran;
	private int hauteur_Ecran;
	 
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
		largeur_Ecran = Gdx.graphics.getWidth();
		hauteur_Ecran = Gdx.graphics.getHeight();
		 // load assets
		  otarie=new Texture(Gdx.files.internal("map3.png"));
		  MonOtarie=new TextureRegion(otarie,0,0,1024,512);
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
		  batch.draw(MonOtarie,0,0,(AdaptEcran.setEcranLargeur(800)),(AdaptEcran.setEcranLargeur(320)));
		  batch.end();
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

}
