package steelkiwi.com.library.utils;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

/**
 * Created by yaroslav on 4/6/17.
 */

public class ShapeUtils {

    public static ShapeDrawable roundedRectWithColor(int color, float radius) {
        float[] cornerRadius = new float[] {
                radius, radius,
                radius, radius,
                radius, radius,
                radius, radius
        };

        RoundRectShape roundRectShape = new RoundRectShape(cornerRadius, null, null);
        ShapeDrawable shape = new ShapeDrawable();
        shape.getPaint().setColor(color);
        shape.setShape(roundRectShape);
        return shape;
    }
}
