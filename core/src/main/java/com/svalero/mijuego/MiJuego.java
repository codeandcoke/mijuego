package com.svalero.mijuego;

import com.badlogic.gdx.Game;
import com.svalero.mijuego.screen.MainMenuScreen;

public class MiJuego extends Game {
    @Override
    public void create() {
        setScreen(new MainMenuScreen());
    }
}
