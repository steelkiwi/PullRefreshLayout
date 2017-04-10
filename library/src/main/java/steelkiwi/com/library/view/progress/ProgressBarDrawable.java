package steelkiwi.com.library.view.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import steelkiwi.com.library.R;

/**
 * Created by yaroslav on 4/10/17.
 */

public class ProgressBarDrawable extends Drawable {

    private Paint paint;
    private RectF rectF;
    private float height;
    private float width;
    private float offset;
    private float cornerRadius;

    public ProgressBarDrawable(Context context) {
        paint = new Paint();
        rectF = new RectF();
        offset = context.getResources().getDimension(R.dimen.offset_top);
        height = context.getResources().getDimension(R.dimen.progress_item_height);
        width = context.getResources().getDimension(R.dimen.progress_item_width);
        cornerRadius = context.getResources().getDimension(R.dimen.rectangle_corner_radius);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.argb(255, 0, 0, 0));
        paint.setAntiAlias(true);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        rectF.set((canvas.getWidth() / 2) - (width / 2), offset, (canvas.getWidth() / 2) + (width / 2), height);
        // Finally, draw the rounded corners rectangle object on the canvas
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint);
        canvas.rotate(20, canvas.getWidth() / 2, canvas.getHeight() / 2); // rotate it
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
