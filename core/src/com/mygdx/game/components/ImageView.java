package com.mygdx.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ImageView extends View{
    Texture texture;

    public ImageView(float x, float y, float width, float height, String imagePath) {
        super(x, y, width, height);
        texture = new Texture(imagePath);
//        this.width = texture.getWidth();
//        this.height = texture.getHeight();
    }
    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
