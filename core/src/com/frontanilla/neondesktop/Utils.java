package com.frontanilla.neondesktop;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Utils {

    private static final Random random = new Random();

    public static Color randomColor() {
        return new Color(random.nextFloat(),
                random.nextFloat(),
                random.nextFloat(),
                1);
    }

    public static Vector2 getTextSize(String text, BitmapFont font) {
        Vector2 textSize = new Vector2();
        GlyphLayout layout = new GlyphLayout(font, text);
        textSize.x = layout.width;
        textSize.y = layout.height;
        return textSize;
    }

}
