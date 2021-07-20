package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class High implements Screen {
    SpriteBatch batch;
    Texture img;
    Stage stage;
    Skin skin;
    int buttonofset=20;
    BitmapFont font1=new BitmapFont();
    private void createBasicSkin(){
        BitmapFont font=new BitmapFont();
        skin=new Skin();
        font1.setColor(Color.RED);
        font1.getData().setScale(2, 2);
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
    @Override
    public void show() {
        img=new Texture("tetris.jpg");
        batch=new SpriteBatch();

        stage=new Stage();

        Gdx.input.setInputProcessor(stage);
        createBasicSkin();

        TextButton back= new TextButton("back",skin);
        back.setPosition(Gdx.graphics.getWidth()/2-Gdx.graphics.getHeight()/8,Gdx.graphics.getHeight()/2);
        stage.addActor(back);
        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent s,float x,float y){


                ((Game) Gdx.app.getApplicationListener()).setScreen(new Start());




            }
        });


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();



        batch.draw(img,0,0);
        String f="High Score: "+hs();
         font1.draw(batch, f, Gdx.graphics.getWidth()/2-Gdx.graphics.getHeight()/8,Gdx.graphics.getHeight()/2+150);
        batch.end();

        stage.act();
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
        skin.dispose();

    }
    public int hs(){

        FileHandle file;
        String text;


        file = Gdx.files.internal("Hs.txt");
        text = file.readString();

        return Integer.parseInt(text);
    }
}

