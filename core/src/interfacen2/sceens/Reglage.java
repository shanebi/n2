package interfacen2.sceens;

import interfacen2.manag.AdaptEcran;
import interfacen2.manag.My2GdxGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Reglage implements Screen{
	My2GdxGame game;

	private Sprite boutonSpriteSon;
	private Sprite boutonSpriteMusic;	
	private Sprite boutonSpriteVitesse;
	private Sprite boutonCliqueSprite;

	private Sprite arrierePlanSprite;

	private Sprite boutonRetourSprite;

	private BitmapFont font;

	private SpriteBatch batch;


	private float xposBouton1;

	private float xposBouton2;
	
	private float xposBouton3;

	private float xposBoutonRetour;



	private float yposBouton1;

	private float yposBouton2;
	
	private float yposBouton3;

	private float yposBoutonRetour;


	private boolean cliqueBouton1;

	private boolean cliqueBouton2;
	
	private boolean cliqueBouton3;



	public Reglage(My2GdxGame g) {

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

		boutonSpriteSon =new Sprite(new Texture(Gdx.files.internal("son.png"))) ;
		boutonSpriteMusic =new Sprite(new Texture(Gdx.files.internal("musique.png"))) ;
		boutonSpriteVitesse =new Sprite(new Texture(Gdx.files.internal("vitesse du jeu.png"))) ;

		
		
		boutonCliqueSprite = new Sprite(new Texture(Gdx.files.internal("quitter.png"))) ;

		arrierePlanSprite = new Sprite(new Texture(Gdx.files.internal("acceuil.png")));

		boutonRetourSprite = new Sprite(new Texture(Gdx.files.internal("retour.png")));



		boutonSpriteSon.setSize(xUnite(150), yUnite(50));
		boutonSpriteMusic.setSize(xUnite(200), yUnite(70));
		boutonSpriteVitesse.setSize(xUnite(350), yUnite(70));

		boutonCliqueSprite.setSize(xUnite(128), yUnite(64));

		arrierePlanSprite.setSize(xUnite(480), yUnite(320));

		boutonRetourSprite.setSize(xUnite(64), yUnite(64));

		// La police pour le texte

		font = new BitmapFont();

		font.setColor(Color.DARK_GRAY);

		font.setScale(xUnite(1), yUnite(1)); // définir la taille du texte selon l'écran


		xposBouton1 = xUnite(130); // Position du bouton 'nouveau jeu'

		yposBouton1 = yUnite(230);



		xposBouton2 = xUnite(120); // Position du bouton 'Options'

		yposBouton2 = yUnite(130);


		xposBouton3 = xUnite(60); // Position du bouton 'Options'

		yposBouton3 = yUnite(40);




		xposBoutonRetour = xUnite(0);  // Position du bouton 'Retour'

		yposBoutonRetour = yUnite(260);

		boutonRetourSprite.setPosition(xposBoutonRetour, yposBoutonRetour);
		
		

	}



	public void manipulerMenu()

	{

		Gdx.input.setInputProcessor(new InputProcessor() {



			@Override

			public boolean touchUp(int x, int y, int pointer, int bouton) {

				if(x>xUnite(150) && x < xUnite(325) && y>yUnite(30) && y<yUnite(90))

				{

					// le bouton 1 (jeu local) a été cliqué
					
					

				}

				if(x>xUnite(150) && x < xUnite(320) && y>yUnite(130) && y<yUnite(190))

				{

					// le bouton 2 (jeu en ligne) a été cliqué

					

				}
				
				if(x>xUnite(150) && x < xUnite(320) && y>yUnite(220) && y<yUnite(280))

				{

					// le bouton 3 (jeu en ligne) a été cliqué
					// game.setScreen(new NouvJeu(game));


				}
				
				if(x>xUnite(0) && x<xUnite(64) && y>yUnite(0) && y<yUnite(64))

				{

					// le bouton retour a été cliqué
					game.setScreen(new Menu(game));
					

				}






				cliqueBouton1 = false;

				cliqueBouton2 = false;
				
				cliqueBouton3 = false;


				return false;

			}



			@Override

			public boolean touchDown(int x, int y, int pointer, int bouton) {



				if(x>xUnite(160) && x < xUnite(260) && y>yUnite(35) && y<yUnite(90))

				{

					cliqueBouton1=true;

				}

				if(x>xUnite(120) && x < xUnite(318) && y>yUnite(130) && y<yUnite(190))

				{

					cliqueBouton2=true;

				}
				
				if(x>xUnite(70) && x < xUnite(408) && y>yUnite(220) && y<yUnite(280))

				{

					cliqueBouton3=true;


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

			boutonSpriteSon.setPosition(xposBouton1, yposBouton1);// fixer la position

			boutonSpriteSon.draw(batch);                          // puis le dessiner

		}else

		{

			boutonCliqueSprite.setPosition(xposBouton1, yposBouton1);

			boutonCliqueSprite.draw(batch);                         

		}



		// bouton 2

		if(!cliqueBouton2) 

		{

			boutonSpriteMusic.setPosition(xposBouton2, yposBouton2);// fixer la position

			boutonSpriteMusic.draw(batch);                          // puis le dessiner

		}else

		{

			boutonCliqueSprite.setPosition(xposBouton2, yposBouton2);

			boutonCliqueSprite.draw(batch);

		}
		
		
		if(!cliqueBouton3) 

		{

			boutonSpriteVitesse.setPosition(xposBouton3, yposBouton3);// fixer la position

			boutonSpriteVitesse.draw(batch);                          // puis le dessiner

		}else

		{

			boutonCliqueSprite.setPosition(xposBouton3, yposBouton3);

			boutonCliqueSprite.draw(batch);

		}
		
		boutonRetourSprite.draw(batch);



		

		batch.end();  // obligatoire pour finir le dessin sur un SpriteBatch



	}




	@Override

	public void dispose() {

		font.dispose();

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
