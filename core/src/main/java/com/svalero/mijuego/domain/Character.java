package com.svalero.mijuego.domain;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.svalero.mijuego.manager.ResourceManager;
import lombok.Data;

@Data
public abstract class Character {

    protected TextureRegion currentFrame;
    protected Vector2 position;
    protected Rectangle rectangle;
    protected float stateTime;

    public enum State {
        IDDLE_LEFT, IDDLE_RIGHT, RUNNING_RIGHT, RUNNING_LEFT, JUMPING
    }
    public State state;
    protected Animation<TextureRegion> runningLeftAnimation;
    protected Animation<TextureRegion> runningRightAnimation;

    private String rightAnimationName;
    private String leftAnimationName;

    public Character(TextureRegion currentFrame, Vector2 position, State initialState, String leftAnimationName, String rightAnimationName) {
        this.currentFrame = currentFrame;
        this.position = position;
        rectangle = new Rectangle(position.x, position.y, currentFrame.getRegionWidth(), currentFrame.getRegionHeight());

        state = initialState;
        this.rightAnimationName = rightAnimationName;
        this.leftAnimationName = leftAnimationName;
        runningLeftAnimation = new Animation<>(0.15f, ResourceManager.getRegions(leftAnimationName));
        runningRightAnimation = new Animation<>(0.15f, ResourceManager.getRegions(rightAnimationName));
    }

    public void draw(Batch batch) {
        batch.draw(currentFrame, position.x, position.y);
    }

    public void update(float dt) {
        stateTime += dt;

        // Actualizar qué textura toca pintar
        switch (state) {
            case IDDLE_LEFT:
                currentFrame = ResourceManager.getRegion(leftAnimationName);
                break;
            case IDDLE_RIGHT:
                currentFrame = ResourceManager.getRegion(rightAnimationName);
                break;
            case RUNNING_LEFT:
                currentFrame = runningLeftAnimation.getKeyFrame(stateTime, true);
                break;
            case RUNNING_RIGHT:
                currentFrame = runningRightAnimation.getKeyFrame(stateTime, true);
                break;
        }
    }

    public float getTopPosition() {
        return position.y + rectangle.getHeight();
    }
}
