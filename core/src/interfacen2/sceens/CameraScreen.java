package interfacen2.sceens;

import interfacen2.manag.AdaptEcran;
import interfacen2.manag.My2GdxGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Classe qui affiche une carte du réseau de la RTM avec une caméra.
 * 
 * @author trynobass
 */
public class CameraScreen implements Screen {

	Texture background;
	SpriteBatch batch;
	My2GdxGame game;
	private OrthographicCamera camera;

	int x0, y0; // position du doigt

	int lastx0; // précédente position du 1er doigt
	int lasty0; // précédente position du 1er doigt

	public static float vitesse_deplacement_camera = 20;


	private int limite_image_maxLargeur; // limite déplacement camera
	public static int limite_image_minHauteur = 0; // limite déplacement camera
	public static int limite_image_minLargeur = 0; // limite déplacement camera

	private int largeur_Ecran;
	private int hauteur_Ecran;

	/**
	 * Constructeur de la classe
	 * 
	 * @param game
	 *            La variable du jeu
	 */
	public CameraScreen(My2GdxGame game) {
		this.game = game;
	}

	@Override
	public void show() {

		largeur_Ecran = Gdx.graphics.getWidth();
		hauteur_Ecran = Gdx.graphics.getHeight();

		background = new Texture(Gdx.files.internal("map3.png"));
		batch = new SpriteBatch();

		camera = new OrthographicCamera(AdaptEcran.setEcranLargeur(largeur_Ecran), AdaptEcran.setEcranLargeur(hauteur_Ecran));
		camera.position.set(largeur_Ecran * 0.5f, hauteur_Ecran * 0.5f, 0);
		camera.update();

		limite_image_maxLargeur = background.getWidth() / 2;

		limite_image_minHauteur = hauteur_Ecran / 2;
		limite_image_minLargeur = largeur_Ecran / 2;
	}

	@Override
	public void render(float delta) {

		/*** fond coloré *****/
		/*
		 * Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1);
		 * Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		 * 
		 * camera.update();
		 * 
		 * batch.setProjectionMatrix(camera.combined);//permet d'activer les
		 * input batch.begin(); batch.draw(background, 0,
		 * 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()); batch.end();
		 * 
		 * 
		 * handleInput();
		 */

		GL20 gl = Gdx.graphics.getGL20();
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gl.glViewport(0, 0, largeur_Ecran, hauteur_Ecran);
		// camera.apply(gl);
		camera.update();

		manipulerCameraAndroid();

		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		batch.draw(background, 0, 0);
		batch.end();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

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
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void manipulerCameraAndroid() {
		Gdx.input.setInputProcessor(new InputProcessor() {

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer,
					int button) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer,
					int button) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				// camera.translate(screenX, screenY, pointer);

				// ************** Saisir les coordonnées actuelles
				// ********************/

				if (pointer == 0) // Pour le 1er doigt
				{
					x0 = screenX;
					y0 = screenY;
				}



				/********** Operation : Déplacer camera avec un doigt ******************/
				if(!Gdx.input.isTouched(1))             // si un seul doigt est posé sur l'écran
				{
					if(x0-lastx0<0 && y0-lasty0>-5 && y0-lasty0<5)    // Si drag vers droite
					{
						if(camera.position.x<limite_image_maxLargeur) // Limite de la camera a droite
						{
							camera.translate(vitesse_deplacement_camera, 0);
						}
					}
					else
					{
						if(x0-lastx0>0 && y0-lasty0>-5 && y0-lasty0<5)     // Si drag vers gauche
						{
							if(camera.position.x>limite_image_minLargeur)  // Limite de la camera à gauche
							{
								camera.translate(-vitesse_deplacement_camera, 0);
							}
						}
					}
				}

				if (pointer == 0)// 1er doigt
				{
					lastx0 = x0;
					lasty0 = y0;
				}
				return false;

			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyDown(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				// TODO Auto-generated method stub
				return false;
			}
		});

	}
}