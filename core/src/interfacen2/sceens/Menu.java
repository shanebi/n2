package interfacen2.sceens;

import interfacen2.manag.My2GdxGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Menu implements Screen {

		My2GdxGame game;

		private Sprite boutonSpriteJeu;
		private Sprite boutonSpritePropos;
		private Sprite boutonSpriteQuitter;
		private Sprite boutonSpriteReglages;

		private Sprite boutonCliqueSprite;

		private Sprite arrierePlanSprite;

		private Sprite boutonRetourSprite;

		private BitmapFont font;

		private SpriteBatch batch;



		private float largeur_ecran;

		private float hauteur_ecran;



		private float xposBouton1;

		private float xposBouton2;

		private float xposBouton3;

		private float xposBouton4;

		private float xposBoutonRetour;



		private float yposBouton1;

		private float yposBouton2;

		private float yposBouton3;

		private float yposBouton4;

		private float yposBoutonRetour;



		private boolean cliqueBouton1;

		private boolean cliqueBouton2;

		private boolean cliqueBouton3;

		private boolean cliqueBouton4;



		private float xDecalage;

		private float yDecalage;

		//private Sound mp3Sound;

		//private Music music;


		private int page;



		private String texteBouton1;

		private String texteBouton2;

		private String texteBouton3;

		private String texteBouton4;





		public Menu(My2GdxGame g) {

			game = g;

		}





		// Fonction qui maintien le rapport entre les positions Y

		// vis-à-vis de la taille de l'écran

		private float xUnite(float x)

		{

			return x*largeur_ecran/480f;

		}



		// Fonction qui maintien le rapport entre les positions Y

		// vis-à-vis de la taille de l'écran

		private float yUnite(float y)

		{

			return y*hauteur_ecran/320;

		}





		@Override

		public void show() {



			// Obtenir la taille de l'écran actuelle

			largeur_ecran = Gdx.graphics.getWidth();

			hauteur_ecran = Gdx.graphics.getHeight();



			batch = new SpriteBatch();



			// Charger Texture dans Sprite

			boutonSpriteJeu =new Sprite(new Texture(Gdx.files.internal("jeu.png"))) ;
			boutonSpritePropos =new Sprite(new Texture(Gdx.files.internal("apropos.png"))) ;
			boutonSpriteQuitter =new Sprite(new Texture(Gdx.files.internal("quitter.png"))) ;
			boutonSpriteReglages =new Sprite(new Texture(Gdx.files.internal("reglages.png"))) ;
			
			
			boutonCliqueSprite = new Sprite(new Texture(Gdx.files.internal("quitter.png"))) ;

			arrierePlanSprite = new Sprite(new Texture(Gdx.files.internal("acceuil.png")));

			boutonRetourSprite = new Sprite(new Texture(Gdx.files.internal("retour.png")));



			boutonSpriteJeu.setSize(xUnite(130), yUnite(50));
			boutonSpritePropos.setSize(xUnite(130), yUnite(50));
			boutonSpriteQuitter.setSize(xUnite(130), yUnite(50));
			boutonSpriteReglages.setSize(xUnite(130), yUnite(50));

			boutonCliqueSprite.setSize(xUnite(128), yUnite(64));

			arrierePlanSprite.setSize(xUnite(480), yUnite(320));

			boutonRetourSprite.setSize(xUnite(64), yUnite(64));

			//mp3Sound = Gdx.audio.newSound(Gdx.files.internal("button-28.mp3"));
			//Music music = Gdx.audio.newMusic(Gdx.files.internal("jungle-run-01.mp3"));

			// La police pour le texte

			font = new BitmapFont();

			font.setColor(Color.DARK_GRAY);

			font.setScale(xUnite(1), yUnite(1)); // définir la taille du texte selon l'écran


			xposBouton1 = xUnite(50); // Position du bouton 'nouveau jeu'

			yposBouton1 = yUnite(132);



			xposBouton2 = xUnite(50); // Position du bouton 'Options'

			yposBouton2 = yUnite(47);



			xposBouton3 = xUnite(300); // Position du bouton 'Bonus'

			yposBouton3 = yUnite(132);


			xposBouton4 = xUnite(300); // Position du bouton 'Quitter'

			yposBouton4 = yUnite(47);



			xposBoutonRetour = xUnite(0);  // Position du bouton 'Retour'

			yposBoutonRetour = yUnite(260);

			boutonRetourSprite.setPosition(xposBoutonRetour, yposBoutonRetour);
			
			
			// music.isPlaying();
			 //music.setLooping(true);
			 //music.play();
			



		}



		public void manipulerMenu()

		{

			/*Gdx.input.setInputProcessor(new InputProcessor() {



				@Override

				public boolean touchUp(int x, int y, int pointer, int bouton) {

					if(x>xUnite(180) && x < xUnite(300) && y<yUnite(70) && y> yUnite(10))

					{

						// le bouton 1 (startGame) a été cliqué
						// game.setScreen(new MapScreen(game));
						//mp3Sound.play();
						page=1;

					}

					if(x>xUnite(180) && x < xUnite(300) && y>yUnite(80) && y<yUnite(145))

					{

						// le bouton 2 (Options) a été cliqué

						page=2;

					}



					if(x>xUnite(180) && x < xUnite(300) && y>yUnite(155) && y<yUnite(220))

					{

						// le bouton 3 (Bonus) a été cliqué    

						page=3;

					}

					if(x>xUnite(0) && x<xUnite(64) && y>yUnite(0) && y<yUnite(64))

					{

						// le bouton retour a été cliqué

						page=0;

					}
					
					if(x>xUnite(0) && x<xUnite(64) && y>yUnite(230) && y<yUnite(293))

					{

						// le bouton quitter a été cliqué

						page=4;

					}



					cliqueBouton1 = false;

					cliqueBouton2 = false;

					cliqueBouton3 = false;

					cliqueBouton4 = false;



					return false;

				}



				@Override

				public boolean touchDown(int x, int y, int pointer, int bouton) {



					if(x>xUnite(180) && x < xUnite(300) && y>yUnite(10) && y<yUnite(70) )

					{

						cliqueBouton1=true;

					}

					if(x>xUnite(180) && x < xUnite(300) && y>yUnite(80) && y<yUnite(145))

					{

						cliqueBouton2=true;

					}

					if(x>xUnite(180) && x < xUnite(300) && y>yUnite(155) && y<yUnite(220))

					{

						cliqueBouton3=true;

					}
					
					if(x>xUnite(180) && x < xUnite(300) && y>yUnite(230) && y<yUnite(293))

					{

						Gdx.app.exit();

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

		*/}

		public void dessinerMenu()   // dessiner le menu

		{



			batch.begin();  // obligatoire pour commencer un dessin sur le SpriteBatch



			// arrierePlan

			arrierePlanSprite.draw(batch);



			// bouton 1

			if(!cliqueBouton1)

			{

				boutonSpriteJeu.setPosition(xposBouton1, yposBouton1);// fixer la position

				boutonSpriteJeu.draw(batch);                          // puis le dessiner

			}else

			{

				boutonCliqueSprite.setPosition(xposBouton1, yposBouton1);

				boutonCliqueSprite.draw(batch);                         

			}



			// bouton 2

			if(!cliqueBouton2) 

			{

				boutonSpriteReglages.setPosition(xposBouton2, yposBouton2);// fixer la position

				boutonSpriteReglages.draw(batch);                          // puis le dessiner

			}else

			{

				boutonCliqueSprite.setPosition(xposBouton2, yposBouton2);

				boutonCliqueSprite.draw(batch);

			}



			// bouton 3

			if(!cliqueBouton3)

			{

				boutonSpritePropos.setPosition(xposBouton3, yposBouton3); // fixer la position

				boutonSpritePropos.draw(batch);                           // puis le dessiner

			}else

			{

				boutonCliqueSprite.setPosition(xposBouton3, yposBouton3);

				boutonCliqueSprite.draw(batch);

			}


			// bouton 4

			if(!cliqueBouton4)

			{

				boutonSpriteQuitter.setPosition(xposBouton4, yposBouton4); // fixer la position

				boutonSpriteQuitter.draw(batch);                           // puis le dessiner

			}else

			{

				boutonCliqueSprite.setPosition(xposBouton4, yposBouton4);

				boutonCliqueSprite.draw(batch);

			}


			batch.end();  // obligatoire pour finir le dessin sur un SpriteBatch



		}



		public void dessinerPage(int page)

		{

			batch.begin();



			if(page == 1)  // si on est à la page Game

				font.draw(batch, "The Game", xUnite(200), yUnite(320));  // dessiner le titre de la page 1

			if(page == 2)  // si on est à la page Options
				
				font.draw(batch, "Reglages", xUnite(200), yUnite(320)); // dessiner le titre de la page 2

			if(page == 3)  // si on est à la page Bonus

				font.draw(batch, "A propos", xUnite(220), yUnite(320)); // dessiner le titre de la page 3




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



			switch(page)  // dans quelle page je me situe ?

			{

			case 0:              // Contenu de la page menu

				dessinerMenu();



				break;

			case 1:             // Contenu de la page Game

				dessinerPage(1);

				break;



			case 2:             // Contenu de la page Options

				dessinerPage(2);

				break;



			case 3:             // Contenu de la page Bonus

				dessinerPage(3);

				break;

			}
		}






		@Override

		public void hide() {

			// TODO Auto-generated method stub


		}

}
