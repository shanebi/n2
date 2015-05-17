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

public class FinJeu implements Screen{
	My2GdxGame game;

	private Sprite boutonSpriteScore;
	private Sprite boutonSpriteRejouer;
	private Sprite boutonSpriteRetour;
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


	private int page;



	public FinJeu(My2GdxGame g) {

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

		boutonSpriteScore =new Sprite(new Texture(Gdx.files.internal("score.png"))) ;
		boutonSpriteRejouer =new Sprite(new Texture(Gdx.files.internal("rejouer.png"))) ;
		boutonSpriteRetour =new Sprite(new Texture(Gdx.files.internal("retour1.png"))) ;


		boutonCliqueSprite = new Sprite(new Texture(Gdx.files.internal("quitter.png"))) ;

		arrierePlanSprite = new Sprite(new Texture(Gdx.files.internal("acceuil.png")));

		boutonRetourSprite = new Sprite(new Texture(Gdx.files.internal("retour.png")));



		boutonSpriteScore.setSize(xUnite(180), yUnite(60));
		boutonSpriteRejouer.setSize(xUnite(180), yUnite(60));
		boutonSpriteRetour.setSize(xUnite(180), yUnite(60));

		boutonCliqueSprite.setSize(xUnite(128), yUnite(64));

		arrierePlanSprite.setSize(xUnite(480), yUnite(320));

		boutonRetourSprite.setSize(xUnite(64), yUnite(64));

		// La police pour le texte

		font = new BitmapFont();

		font.setColor(Color.DARK_GRAY);

		font.setScale(xUnite(1), yUnite(1)); // définir la taille du texte selon l'écran


		xposBouton1 = xUnite(150); // Position du bouton 'nouveau jeu'

		yposBouton1 = yUnite(230);



		xposBouton2 = xUnite(150); // Position du bouton 'Options'

		yposBouton2 = yUnite(130);


		xposBouton3 = xUnite(150); // Position du bouton 'Options'

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
					//game.setScreen(new CameraScreen(game));
					page=1;


				}

				if(x>xUnite(150) && x < xUnite(320) && y>yUnite(130) && y<yUnite(190))

				{

					// le bouton 2 (jeu en ligne) a été cliqué
					game.setScreen(new Menu(game));


				}

				if(x>xUnite(150) && x < xUnite(320) && y>yUnite(220) && y<yUnite(280))

				{

					// le bouton 2 (jeu en ligne) a été cliqué
					game.setScreen(new NouvJeu(game));


				}

				if(x>xUnite(0) && x<xUnite(64) && y>yUnite(0) && y<yUnite(64))

				{

					// le bouton retour a été cliqué

					page=0;

				}






				cliqueBouton1 = false;

				cliqueBouton2 = false;

				cliqueBouton3 = false;



				return false;

			}



			@Override

			public boolean touchDown(int x, int y, int pointer, int bouton) {



				if(x>xUnite(150) && x < xUnite(325) && y>yUnite(30) && y<yUnite(90))

				{

					cliqueBouton1=true;

				}

				if(x>xUnite(150) && x < xUnite(320) && y>yUnite(130) && y<yUnite(190))

				{

					cliqueBouton2=true;

				}

				if(x>xUnite(150) && x < xUnite(320) && y>yUnite(220) && y<yUnite(280))

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

			boutonSpriteScore.setPosition(xposBouton1, yposBouton1);// fixer la position

			boutonSpriteScore.draw(batch);                          // puis le dessiner

		}else

		{

			boutonCliqueSprite.setPosition(xposBouton1, yposBouton1);

			boutonCliqueSprite.draw(batch);                         

		}



		// bouton 2

		if(!cliqueBouton2) 

		{

			boutonSpriteRejouer.setPosition(xposBouton2, yposBouton2);// fixer la position

			boutonSpriteRejouer.draw(batch);                          // puis le dessiner

		}else

		{

			boutonCliqueSprite.setPosition(xposBouton2, yposBouton2);

			boutonCliqueSprite.draw(batch);

		}



		// bouton 3

		if(!cliqueBouton3) 

		{

			boutonSpriteRetour.setPosition(xposBouton3, yposBouton3);// fixer la position

			boutonSpriteRetour.draw(batch);                          // puis le dessiner

		}else

		{

			boutonCliqueSprite.setPosition(xposBouton3, yposBouton3);

			boutonCliqueSprite.draw(batch);

		}






		batch.end();  // obligatoire pour finir le dessin sur un SpriteBatch



	}



	public void dessinerPage(int page)

	{

		batch.begin();



		if(page == 1)  // si on est à la page Game

			font.draw(batch, "Score", xUnite(200), yUnite(320));  // dessiner le titre de la page 1
		//game.setScreen(new CameraScreen(game));



		boutonRetourSprite.draw(batch);

		batch.end();

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

		if(page==2)
			dessinerPage(2);

		// Contenu de la page menu

		//dessinerMenu();

		switch(page)  // dans quelle page je me situe ?

		{

		case 0:              // Contenu de la page menu

			dessinerMenu();



			break;

		case 1:             // Contenu de la page Game

			dessinerPage(1);

			break;
		}



	}






	@Override

	public void hide() {

		// TODO Auto-generated method stub


	}

}
