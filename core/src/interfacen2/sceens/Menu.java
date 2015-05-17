package interfacen2.sceens;

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
import interfacen2.manag.AdaptEcran;

public class Menu implements Screen {

		My2GdxGame game;

		private Sprite boutonSpriteJeu;
		private Sprite boutonSpriteRegle;
		private Sprite boutonSpriteQuitter;
		private Sprite boutonSpriteReglages;
		private Sprite boutonSpritelogo;

		private Sprite boutonCliqueSprite;

		private Sprite arrierePlanSprite;

		private Sprite boutonRetourSprite;

		private BitmapFont font;

		private SpriteBatch batch;




		private float xposBouton1;

		private float xposBouton2;

		private float xposBouton3;

		private float xposBouton4;

		private float xposBoutonRetour;
		
		private float xposBoutonLogo;



		private float yposBouton1;

		private float yposBouton2;

		private float yposBouton3;

		private float yposBouton4;

		private float yposBoutonRetour;
		
		private float yposBoutonLogo;



		private boolean cliqueBouton1;

		private boolean cliqueBouton2;

		private boolean cliqueBouton3;

		private boolean cliqueBouton4;
		
		private boolean cliqueBouton5;
		

		private int page;



		public Menu(My2GdxGame g) {

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

			boutonSpriteJeu =new Sprite(new Texture(Gdx.files.internal("jeu.png"))) ;
			boutonSpriteRegle =new Sprite(new Texture(Gdx.files.internal("regles.png"))) ;
			boutonSpriteQuitter =new Sprite(new Texture(Gdx.files.internal("quitter.png"))) ;
			boutonSpriteReglages =new Sprite(new Texture(Gdx.files.internal("reglages.png"))) ;
			boutonSpritelogo =new Sprite(new Texture(Gdx.files.internal("titre.png"))) ;
			
			
			boutonCliqueSprite = new Sprite(new Texture(Gdx.files.internal("quitter.png"))) ;

			arrierePlanSprite = new Sprite(new Texture(Gdx.files.internal("acceuil.png")));

			boutonRetourSprite = new Sprite(new Texture(Gdx.files.internal("retour.png")));


			//Taille du Sprite
			boutonSpriteJeu.setSize(xUnite(180), yUnite(60));
			boutonSpriteRegle.setSize(xUnite(180), yUnite(60));
			boutonSpriteQuitter.setSize(xUnite(180), yUnite(60));
			boutonSpriteReglages.setSize(xUnite(180), yUnite(60));
			boutonSpritelogo.setSize(xUnite(300), yUnite(120));

			boutonCliqueSprite.setSize(xUnite(128), yUnite(64));

			arrierePlanSprite.setSize(xUnite(480), yUnite(320));

			boutonRetourSprite.setSize(xUnite(64), yUnite(64));

			// La police pour le texte

			font = new BitmapFont();

			font.setColor(Color.DARK_GRAY);

			font.setScale(xUnite(1), yUnite(1)); // définir la taille du texte selon l'écran


			xposBouton1 = xUnite(40); // Position du bouton 'nouveau jeu'

			yposBouton1 = yUnite(122);



			xposBouton2 = xUnite(40); // Position du bouton 'Reglage'

			yposBouton2 = yUnite(37);



			xposBouton3 = xUnite(270); // Position du bouton 'Regle'

			yposBouton3 = yUnite(122);


			xposBouton4 = xUnite(270); // Position du bouton 'Quitter'

			yposBouton4 = yUnite(37);



			xposBoutonRetour = xUnite(0);  // Position du bouton 'Retour'

			yposBoutonRetour = yUnite(260);

			boutonRetourSprite.setPosition(xposBoutonRetour, yposBoutonRetour);
			
			
			xposBoutonLogo = xUnite(120); // Position du bouton 'a propos'
			yposBoutonLogo = yUnite(180);
			


		}



		public void manipulerMenu()

		{

			Gdx.input.setInputProcessor(new InputProcessor() {



				@Override

				public boolean touchUp(int x, int y, int pointer, int bouton) {

					if(x>xUnite(40) && x < xUnite(220) && y>yUnite(137) && y<yUnite(195))

					{

						// le bouton 1 (nouv jeu) a été cliqué
						 game.setScreen(new NouvJeu(game));

					}

					if(x>xUnite(45) && x < xUnite(210) && y>yUnite(230) && y<yUnite(280))

					{

						// le bouton 2 (Reglages) a été cliqué
						game.setScreen(new Reglage(game));
						

					}



					if(x>xUnite(270) && x < xUnite(445) && y>yUnite(137) && y<yUnite(195))

					{

						// le bouton 3 (Regles) a été cliqué    

						page=3;

					}

					if(x>xUnite(0) && x<xUnite(64) && y>yUnite(0) && y<yUnite(64))

					{

						// le bouton retour a été cliqué

						page=0;

					}
					
					if(x>xUnite(270) && x < xUnite(445) && y>yUnite(230) && y<yUnite(280))

					{

						// le bouton quitter a été cliqué

						page=4;

					}
					
					if(x>xUnite(180) && x < xUnite(300) && y<yUnite(70) && y> yUnite(10))

					{

						// le bouton logo a été cliqué

						page=5;

					}



					cliqueBouton1 = false;

					cliqueBouton2 = false;

					cliqueBouton3 = false;

					cliqueBouton4 = false;
					
					cliqueBouton5 = false;
					


					return false;

				}



				@Override

				public boolean touchDown(int x, int y, int pointer, int bouton) {



					if(x>xUnite(40) && x < xUnite(220) && y>yUnite(137) && y<yUnite(195))

					{

						cliqueBouton1=true;

					}

					if(x>xUnite(45) && x < xUnite(210) && y>yUnite(230) && y<yUnite(280))

					{

						cliqueBouton2=true;

					}

					if(x>xUnite(270) && x < xUnite(445) && y>yUnite(137) && y<yUnite(195))

					{

						cliqueBouton3=true;

					}
					
					if(x>xUnite(270) && x < xUnite(445) && y>yUnite(230) && y<yUnite(280))

					{

						Gdx.app.exit();

					}
					
					if(x>xUnite(120) && x < xUnite(400) && y<yUnite(120) && y> yUnite(30))

					{

						cliqueBouton5=true;

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

				boutonSpriteRegle.setPosition(xposBouton3, yposBouton3); // fixer la position

				boutonSpriteRegle.draw(batch);                           // puis le dessiner

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
			
			
			// logo

						if(!cliqueBouton5)

						{

							boutonSpritelogo.setPosition(xposBoutonLogo, yposBoutonLogo); // fixer la position

							boutonSpritelogo.draw(batch);                           // puis le dessiner

						}else

						{

							boutonCliqueSprite.setPosition(xposBoutonLogo, yposBoutonLogo);

							boutonCliqueSprite.draw(batch);

						}


			batch.end();  // obligatoire pour finir le dessin sur un SpriteBatch



		}



		public void dessinerPage(int page)

		{

			batch.begin();



			if(page == 1)  // si on est à la page Game

				font.draw(batch, "The Game", xUnite(200), yUnite(320));  // dessiner le titre de la page 1

			if(page == 2)  // si on est à la page 
				
				font.draw(batch, "Reglages", xUnite(200), yUnite(320)); // dessiner le titre de la page 2

			if(page == 3)  // si on est à la page 

				font.draw(batch, "Regles", xUnite(220), yUnite(320)); // dessiner le titre de la page 3

			if(page == 5)  // si on est à la page regle

				font.draw(batch, "A propos", xUnite(220), yUnite(320)); // dessiner le titre de la page 5


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



			case 2:             // Contenu de la page reglage

				dessinerPage(2);

				break;



			case 3:             // Contenu de la page regle

				dessinerPage(3);

				break;
				
			
			case 5:             // Contenu de la page a propos

				dessinerPage(5);

				break;

			}
		}






		@Override

		public void hide() {

			// TODO Auto-generated method stub


		}

}
