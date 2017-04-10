package steelkiwi.com.library.view.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import steelkiwi.com.library.R;


/**
 * Created by yaroslav on 4/7/17.
 */

public class ProgressBarView extends FrameLayout {
    private static final int DELAY = 90;

    private ProgressBarDrawable progressBarDrawable;
    private int alpha;
    private int alphaStep;

    public ProgressBarView(Context context) {
        super(context);
        init();
    }

    public ProgressBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProgressBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        progressBarDrawable = new ProgressBarDrawable(getContext());
        prepareParentParams();
        setItemAlpha(255);
        setAlphaStep(14);
        setAlpha(0f);
    }

    private void prepareParentParams(){
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                (int) getResources().getDimension(R.dimen.progress_bar_height));
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        setBackgroundResource(android.R.color.transparent);
        setLayoutParams(params);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save(); // first save the state of the canvas
        for(float angle = 0; angle < 2f * Math.PI; angle += 2f * Math.PI / 36) {
            decreaseAlpha(getAlphaStep());
            progressBarDrawable.draw(canvas);
            progressBarDrawable.setAlpha(alpha);
            postInvalidateDelayed(DELAY);
        }
        canvas.restore(); // restore previous state (rotate it back)
    }

    public void setItemAlpha(int alpha) {
        this.alpha = alpha;
    }

    public void decreaseAlpha(int step) {
        this.alpha -= step;
    }

    public int getAlphaStep() {
        return alphaStep;
    }

    public void setAlphaStep(int alphaStep) {
        this.alphaStep = alphaStep;
    }
}
