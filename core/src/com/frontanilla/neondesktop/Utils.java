package com.frontanilla.neondesktop;

import com.badlogic.gdx.graphics.Color;

import java.util.Random;

public class Utils {

    private static final Random random = new Random();

    public static Color randomColor() {
        return new Color(random.nextFloat(),
                random.nextFloat(),
                random.nextFloat(),
                1);
    }
}
