package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Stage stage;
	Skin skin;
	//Table table = new Table();
	private void createBasicSkin(){
		BitmapFont font=new BitmapFont();
		skin=new Skin();
		skin.add("default",font);
		Pixmap pixmap=new Pixmap((int)Gdx.graphics.getWidth()/4,(int)Gdx.graphics.getHeight()/8,Pixmap.Format.RGB888);
		pixmap.setColor(Color.RED);
		pixmap.fill();;
		skin.add("background",new Texture(pixmap));
		TextButton.TextButtonStyle style=new TextButton.TextButtonStyle();
		style.up=skin.newDrawable("background",Color.GRAY);
		style.down=skin.newDrawable("background",Color.DARK_GRAY);
		style.checked=skin.newDrawable("background",Color.DARK_GRAY);
		style.over=skin.newDrawable("background",Color.DARK_GRAY);
		style.font=skin.getFont("default");
		skin.add("default",style);
	}
	TextButton exit;
	@Override
	public void create () {
		img=new Texture("tetris.jpg");
		batch=new SpriteBatch();
		int buttonofset=20;
		stage=new Stage();

		Gdx.input.setInputProcessor(stage);
		createBasicSkin();
		TextButton start= new TextButton("Start",skin);
		//table.background(new TextureRegionDrawable(new TextureRegion(img)));
		start.setPosition(Gdx.graphics.getWidth()/2-Gdx.graphics.getHeight()/8,Gdx.graphics.getHeight()/2 +(start.getHeight()+buttonofset)) ;
		TextButton credits= new TextButton("Credits",skin);
		stage.addActor(start);
		credits.setPosition(Gdx.graphics.getWidth()/2-Gdx.graphics.getHeight()/8,Gdx.graphics.getHeight()/2);
		stage.addActor(credits);
		exit= new TextButton("Exit",skin);
		exit.setPosition(Gdx.graphics.getWidth()/2-Gdx.graphics.getHeight()/8,Gdx.graphics.getHeight()/2 -(start.getHeight()+buttonofset));

		stage.addActor(exit);

	}


	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();



		batch.draw(img,0,0);
		batch.end();

		stage.act();
		stage.draw();

		exit.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent s,float x,float y){




				//*/Gdx.app.exit();

			}
		});
	}
	

}
