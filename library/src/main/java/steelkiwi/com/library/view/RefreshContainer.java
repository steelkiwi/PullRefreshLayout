package steelkiwi.com.library.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;

import steelkiwi.com.library.CustomTouchListener;
import steelkiwi.com.library.R;
import steelkiwi.com.library.utils.AnimationUtils;
import steelkiwi.com.library.utils.Constants;
import steelkiwi.com.library.view.progress.ProgressBarView;


/**
 * Created by yaroslav on 4/5/17.
 */

public class RefreshContainer extends FrameLayout {

    private RecyclerView recyclerView;
    private ProgressBarView progressBar;
    private RefreshContainer.OnRefreshListener listener;
    private boolean isRefreshOpen;

    public interface OnRefreshListener {
        void onRefresh();
    }

    public RefreshContainer(Context context) {
        super(context);
        init();
    }

    public RefreshContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RefreshContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setRefreshOpen(false);
        prepareRefreshLayout();
    }

    private void prepareRefreshLayout() {
        progressBar = new ProgressBarView(getContext());
        addView(progressBar);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View view = getChildAt(1);
        if (view instanceof RecyclerView) {
            recyclerView = (RecyclerView) getChildAt(1);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return touchListener.onTouch(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        touchListener.onTouch(event);
        return false;
    }

    private CustomTouchListener touchListener = new CustomTouchListener(getContext()) {

        @Override
        public boolean onSwipeDown() {
            if(!isRefreshOpen() && isFirstItemVisible()) {
                setRefreshOpen(true);
                animateProgressStart();
                if(listener != null) {
                    listener.onRefresh();
                }
            }
            return false;
        }
    };

    private void animateProgressStart(){
        AnimationUtils.translateByY(recyclerView, getResources().getDimension(R.dimen.refresh_layout_bottom_margin), Constants.DELAY_900, new OvershootInterpolator());
        AnimationUtils.alpha(progressBar, 1f, Constants.DELAY_700, new AccelerateDecelerateInterpolator());
    }

    public void finishRefreshing() {
        AnimationUtils.translateByY(recyclerView, 0, Constants.DELAY_900, new OvershootInterpolator());
        AnimationUtils.translateByY(progressBar, 0, Constants.DELAY_900, new OvershootInterpolator());
        progressBar.setAlpha(0f);
        setRefreshOpen(false);
    }

    private boolean isFirstItemVisible(){
        return ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0;
    }

    public boolean isRefreshOpen() {
        return isRefreshOpen;
    }

    public void setRefreshOpen(boolean refreshOpen) {
        isRefreshOpen = refreshOpen;
    }

    public void setListener(OnRefreshListener listener) {
        this.listener = listener;
    }
}
