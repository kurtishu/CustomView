package com.dreamfactory.customview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.dreamfactory.customview.R;

/**
 * Created by kurtishu on 7/21/17.
 */

public class XformodeView extends View {

    private Bitmap mBgBitmap, mFgBitmap;
    private Paint mPaint;
    private Canvas mCanvas;
    private Path mPath;

    public XformodeView(Context context) {
        super(context);
    }

    public XformodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public XformodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAlpha(0);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(50);
        mPath = new Path();
        mBgBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        mFgBitmap = Bitmap.createBitmap(mBgBitmap.getWidth(), mBgBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mFgBitmap);
        mCanvas.drawColor(Color.GRAY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.reset();
                mPath.moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(event.getX(), event.getY());
                break;
        }

        mCanvas.drawPath(mPath, mPaint);
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBgBitmap, 0, 0 , null);
        canvas.drawBitmap(mFgBitmap, 0, 0 , null);
    }
}
