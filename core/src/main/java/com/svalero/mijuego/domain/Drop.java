package com.svalero.mijuego.domain;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import lombok.Data;

import static com.svalero.mijuego.util.Constants.DROP_SPEED;

@Data
public class Drop extends Character {

    public Drop(Texture texture, int x, int y) {
        super(texture, new Vector2(x, y));
    }

    public void move(float delta) {
        position.y -= DROP_SPEED * delta;
        rectangle.y = position.y;
    }
}
