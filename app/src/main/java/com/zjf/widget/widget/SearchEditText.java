package com.zjf.widget.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.zjf.widget.R;

public class SearchEditText extends AppCompatEditText {

    private boolean showSearchDrawable;
    private Drawable clearDrawable, searchDrawable;
    private OnClearTextListener listener;

    public interface OnClearTextListener {
        void onClearTextListener();
    }

    public SearchEditText(Context context) {
        this(context, null);
    }

    public SearchEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public SearchEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SearchEditText);
        showSearchDrawable = array.getBoolean(R.styleable.SearchEditText_show_search_drawable, false);
        searchDrawable = array.getDrawable(R.styleable.SearchEditText_search_drawable);
        clearDrawable = array.getDrawable(R.styleable.SearchEditText_clear_drawable);
        if (showSearchDrawable && searchDrawable == null) {
            setShowSearchDrawable(true);
        } else if (!showSearchDrawable && searchDrawable != null) {
            setSearchDrawable(searchDrawable);
        }
        if (clearDrawable != null) {
            setClearDrawable(clearDrawable);
        } else {
            setClearDrawable(R.drawable.icon_clear);
        }
        setFocusableInTouchMode(true);  //点击的时候弹出软键盘
        array.recycle();
    }

    public void setClearDrawable(Drawable clearDrawable) {
        this.clearDrawable = clearDrawable;
    }

    public void setClearDrawable(@DrawableRes int drawableRes) {
        this.clearDrawable = getResources().getDrawable(drawableRes);
    }

    public void setShowSearchDrawable(boolean showSearchDrawable) {
        this.showSearchDrawable = showSearchDrawable;
        if (showSearchDrawable) {
            searchDrawable = getResources().getDrawable(R.drawable.icon_search);
        } else {
            searchDrawable = null;
        }
        setCompoundDrawablesWithIntrinsicBounds(searchDrawable, getCompoundDrawables()[1], getCompoundDrawables()[2], getCompoundDrawables()[3]);
    }

    public void setSearchDrawable(Drawable searchDrawable) {
        this.searchDrawable = searchDrawable;
        setCompoundDrawablesWithIntrinsicBounds(searchDrawable, getCompoundDrawables()[1], getCompoundDrawables()[2], getCompoundDrawables()[3]);
    }

    public void setSearchDrawable(@DrawableRes int drawableRes) {
        this.searchDrawable = getResources().getDrawable(drawableRes);
        setCompoundDrawablesWithIntrinsicBounds(searchDrawable, getCompoundDrawables()[1], getCompoundDrawables()[2], getCompoundDrawables()[3]);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (clearDrawable != null) {
                final float left = getWidth() - getPaddingRight() - clearDrawable.getIntrinsicWidth();
                final float right = getWidth() - getPaddingRight();
                if (event.getX() >= left && event.getX() <= right) {
                    this.setText("");
                    if (listener != null) {
                        listener.onClearTextListener();
                    }
                }
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        setClearDrawableVisibility(text.length() > 0);
    }

    private void setClearDrawableVisibility(boolean visibile) {
        Drawable right = visibile ? clearDrawable : null;
        if (showSearchDrawable) {
            setCompoundDrawablesWithIntrinsicBounds(searchDrawable, getCompoundDrawables()[1], right, getCompoundDrawables()[3]);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], right, getCompoundDrawables()[3]);
        }
    }

    public void setOnClearTextListener(OnClearTextListener listener) {
        this.listener = listener;
    }

}
