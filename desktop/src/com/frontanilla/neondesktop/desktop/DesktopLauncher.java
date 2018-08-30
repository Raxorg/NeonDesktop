package com.frontanilla.neondesktop.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.frontanilla.neondesktop.NeonGame;

import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        DisplayMode dm = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
        config.width = dm.getWidth() / 2;
        config.height = dm.getHeight() / 2;
        new LwjglApplication(new NeonGame(), config);
    }
}
