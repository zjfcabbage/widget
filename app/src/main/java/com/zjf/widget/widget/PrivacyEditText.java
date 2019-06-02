package com.zjf.widget.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.zjf.widget.R;

public class PrivacyEditText extends AppCompatEditText {
    private Drawable viewDrawble, viewOffDrawable;
    private boolean isShow;

    public PrivacyEditText(Context context) {
        this(context, null);
    }

    public PrivacyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public PrivacyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.PrivacyEditText);
        viewDrawble = array.getDrawable(R.styleable.PrivacyEditText_view_drawable);
        viewOffDrawable = array.getDrawable(R.styleable.PrivacyEditText_view_off_drawable);
        if (viewDrawble == null) {
            viewDrawble = getResources().getDrawable(R.drawable.icon_view);
        }
        if (viewOffDrawable == null) {
            viewOffDrawable = getResources().getDrawable(R.drawable.icon_view_off);
        }
        setDrawable(viewOffDrawable);
        setTransformationMethod(PasswordTransformationMethod.getInstance());
        isShow = false;
        array.recycle();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (!isShow) {
                if (viewOffDrawable != null) {
                    final float left = getWidth() - getPaddingRight() - viewOffDrawable.getIntrinsicWidth();
                    final float right = getWidth() - getPaddingRight();
                    if (event.getX() >= left && event.getX() <= right) {
                        setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        setDrawable(viewDrawble);
                        isShow = true;
                    }
                }
            } else {
                if (viewDrawble != null) {
                    final float left = getWidth() - getPaddingRight() - viewDrawble.getIntrinsicWidth();
                    final float right = getWidth() - getPaddingRight();
                    if (event.getX() >= left && event.getX() <= right) {
                        setTransformationMethod(PasswordTransformationMethod.getInstance());
                        setDrawable(viewOffDrawable);
                        isShow = false;
                    }
                }
            }
        }
        return super.onTouchEvent(event);
    }

    private void setDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], drawable, getCompoundDrawables()[3]);
    }
}
