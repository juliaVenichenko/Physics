package com.mygdx.game.screens.ThermalScreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Atom {
    private Texture texture; // Текстура атома
    private Vector2 position; // Позиция атома
    private Vector2 velocity; // Скорость атома
    private float size; // Размер атома

    // Конструктор класса Atom
    public Atom(Texture texture, float x, float y, float vx, float vy, float size) {
        this.texture = texture;
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(vx, vy);
        this.size = size;
    }

    // Метод для обновления позиции атома
    public void update(float deltaTime, float rectX, float rectY, float rectWidth, float rectHeight) {
        // Обновляем позицию атома
        position.add(velocity.x * deltaTime, velocity.y * deltaTime);

        // Проверяем границы заданного прямоугольника
        if (position.x < rectX + size / 2) { // Слева
            position.x = rectX + size / 2; // Устанавливаем на границу
            velocity.x = -velocity.x; // Отскакиваем
        }
        if (position.x > rectX + rectWidth - size / 2) { // Справа
            position.x = rectX + rectWidth - size / 2; // Устанавливаем на границу
            velocity.x = -velocity.x; // Отскакиваем
        }
        if (position.y < rectY + size / 2) { // Снизу
            position.y = rectY + size / 2; // Устанавливаем на границу
            velocity.y = -velocity.y; // Отскакиваем
        }
        if (position.y > rectY + rectHeight - size / 2) { // Сверху
            position.y = rectY + rectHeight - size / 2; // Устанавливаем на границу
            velocity.y = -velocity.y; // Отскакиваем
        }
    }

    // Метод для отрисовки атома
    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x - size / 2, position.y - size / 2, size, size);
    }

    // Геттеры для получения свойств атома
    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getSize() {
        return size;
    }

    // Метод для получения текстуры атома
    public Texture getTexture() {
        return texture;
    }

    // Метод для освобождения ресурсов (например, текстуры)
    public void dispose() {
        texture.dispose();
    }
}
