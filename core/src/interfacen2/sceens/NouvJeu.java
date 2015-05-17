package interfacen2.sceens;

import interfacen2.manag.AdaptEcran;
import interfacen2.manag.My2GdxGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class NouvJeu implements Screen{
	My2GdxGame game;

	private Sprite boutonSpriteJeuLocal;
	private Sprite boutonSpriteJeuLigne;
	private Sprite boutonCliqueSprite;

	private Sprite arrierePlanSprite;

	private SpriteBatch batch;


	private float xposBouton1;

	private float xposBouton2;


	private float yposBouton1;

	private float yposBouton2;


	private boolean cliqueBouton1;

	private boolean cliqueBouton2;



	public NouvJeu(My2GdxGame g) {

		game = g;

	}





	// Fonction qui maintien le rapport entre les positions Y

			// vis-à-vis de la taille de l'écran

			private float xUnite(float x)

			{
				return AdaptEcran.setEcranPostX(x);

			}



			// Fonction qui maintien le rapport entre les positions Y

			// vis-à-vis de la taille de l'écran

			private float yUnite(float y)

			{
				return AdaptEcran.setEcranPosY(y);

			}





	@Override

	public void show() {



		batch = new SpriteBatch();



		// Charger Texture dans Sprite

		boutonSpriteJeuLocal =new Sprite(new Texture(Gdx.files.internal("local.png"))) ;
		boutonSpriteJeuLigne =new Sprite(new Texture(Gdx.files.internal("ligne.png"))) ;
		
		
		boutonCliqueSprite = new Sprite(new Texture(Gdx.files.internal("quitter.png"))) ;

		arrierePlanSprite = new Sprite(new Texture(Gdx.files.internal("acceuil.png")));


		//Taille du Sprite
		boutonSpriteJeuLocal.setSize(xUnite(430), yUnite(90));
		boutonSpriteJeuLigne.setSize(xUnite(440), yUnite(90));

		boutonCliqueSprite.setSize(xUnite(128), yUnite(64));

		arrierePlanSprite.setSize(xUnite(480), yUnite(320));

		


		xposBouton1 = xUnite(20); // Position du bouton 'jeu local'

		yposBouton1 = yUnite(180);



		xposBouton2 = xUnite(20); // Position du bouton 'jeu en ligne'

		yposBouton2 = yUnite(40);

		
		

	}



	public void manipulerMenu()

	{

		Gdx.input.setInputProcessor(new InputProcessor() {



			@Override

			public boolean touchUp(int x, int y, int pointer, int bouton) {

				if(x>xUnite(25) && x < xUnite(450) && y>yUnite(55) && y<yUnite(140))

				{

					// le bouton 1 (jeu local) a été cliqué
					 game.setScreen(new FinJeu(game));
					
					

				}

				if(x>xUnite(25) && x < xUnite(450) && y>yUnite(200) && y<yUnite(270))

				{

					// le bouton 2 (jeu en ligne) a été cliqué

					

				}






				cliqueBouton1 = false;

				cliqueBouton2 = false;
				


				return false;

			}



			@Override

			public boolean touchDown(int x, int y, int pointer, int bouton) {



				if(x>xUnite(25) && x < xUnite(450) && y>yUnite(55) && y<yUnite(140))

				{

					cliqueBouton1=true;

				}

				if(x>xUnite(25) && x < xUnite(450) && y>yUnite(200) && y<yUnite(270))

				{

					cliqueBouton2=true;

				}

			

				return false;

			}



			@Override

			public boolean touchDragged(int arg0, int arg1, int arg2) {

				return false;

			}



			@Override

			public boolean scrolled(int arg0) {

				return false;

			}



			@Override

			public boolean mouseMoved(int arg0, int arg1) {

				return false;

			}



			@Override

			public boolean keyUp(int arg0) {

				return false;

			}



			@Override

			public boolean keyTyped(char arg0) {

				return false;

			}



			@Override

			public boolean keyDown(int arg0) {

				return false;

			}

		});

	}

	public void dessinerMenu()   // dessiner le menu

	{



		batch.begin();  // obligatoire pour commencer un dessin sur le SpriteBatch



		// arrierePlan

		arrierePlanSprite.draw(batch);



		// bouton 1

		if(!cliqueBouton1)

		{

			boutonSpriteJeuLocal.setPosition(xposBouton1, yposBouton1);// fixer la position

			boutonSpriteJeuLocal.draw(batch);                          // puis le dessiner

		}else

		{

			boutonCliqueSprite.setPosition(xposBouton1, yposBouton1);

			boutonCliqueSprite.draw(batch);                         

		}



		// bouton 2

		if(!cliqueBouton2) 

		{

			boutonSpriteJeuLigne.setPosition(xposBouton2, yposBouton2);// fixer la position

			boutonSpriteJeuLigne.draw(batch);                          // puis le dessiner

		}else

		{

			boutonCliqueSprite.setPosition(xposBouton2, yposBouton2);

			boutonCliqueSprite.draw(batch);

		}
		

		batch.end();  // obligatoire pour finir le dessin sur un SpriteBatch



	}


	@Override

	public void dispose() {

		batch.dispose();

	}



	@Override

	public void pause() {



	}





	@Override

	public void resize(int arg0, int arg1) {

	}



	@Override

	public void resume() {





	}



	@Override

	public void render(float delta) {

		// TODO Auto-generated method stub

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		Gdx.gl.glClearColor(1, 1, 1, 1);



		manipulerMenu();  // gestion des input



		          // Contenu de la page menu

			dessinerMenu();


		
	}






	@Override

	public void hide() {

		// TODO Auto-generated method stub


	}

}
