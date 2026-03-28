package com.svalero.mijuego.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Disposable;
import com.svalero.mijuego.domain.Enemy;

public class RenderManager implements Disposable {

    private Batch batch;
    private LogicManager logicManager;

    public RenderManager(LogicManager logicManager, Batch batch) {
        this.logicManager = logicManager;
        this.batch = batch;
    }

    public void drawFrame() {
        batch.begin();
        logicManager.player.draw(batch);
        // TODO Gestionar enemigos como un array
        for (Enemy enemy : logicManager.enemies) {
            enemy.draw(batch);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
