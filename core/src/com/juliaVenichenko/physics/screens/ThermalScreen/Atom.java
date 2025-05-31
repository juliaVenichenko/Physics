package com.juliaVenichenko.physics.screens.ThermalScreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Atom {
    private Texture texture;
    private Vector2 position;
    private Vector2 velocity;
    private float size;

    public Atom(Texture texture, float x, float y, float vx, float vy, float size) {
        this.texture = texture;
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(vx, vy);
        this.size = size;
    }
    public void update(float deltaTime, float rectX, float rectY, float rectWidth, float rectHeight) {
        position.add(velocity.x * deltaTime, velocity.y * deltaTime);

        if (position.x < rectX + size / 2) {
            position.x = rectX + size / 2;
            velocity.x = -velocity.x;
        }
        if (position.x > rectX + rectWidth - size / 2) {
            position.x = rectX + rectWidth - size / 2;
            velocity.x = -velocity.x;
        }
        if (position.y < rectY + size / 2) {
            position.y = rectY + size / 2;
            velocity.y = -velocity.y;
        }
        if (position.y > rectY + rectHeight - size / 2) {
            position.y = rectY + rectHeight - size / 2;
            velocity.y = -velocity.y;
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x - size / 2, position.y - size / 2, size, size);
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getSize() {
        return size;
    }

    public Texture getTexture() {
        return texture;
    }

    public void dispose() {
        texture.dispose();
    }
}
