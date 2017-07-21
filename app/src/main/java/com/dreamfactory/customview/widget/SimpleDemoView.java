package com.dreamfactory.customview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kurtishu on 7/21/17.
 */

public class SimpleDemoView extends View {

    private Paint mPaint = new Paint();
    private int mWidth;
    private int mHeight;

    public SimpleDemoView(Context context) {
        super(context);
    }

    public SimpleDemoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SimpleDemoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        //mPaint.setStyle(Paint.Style.STROKE);
        //mPaint.setColor(Color.BLUE);
        //mPaint.setStrokeWidth(15f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);

//        canvas.translate(100, 100);
//        canvas.scale(2, 2);
//
//        canvas.drawPoint(10, 10, mPaint);
//
//        canvas.drawLine(0, 0, 100, 100, mPaint);
//
//        canvas.drawRect(200, 200, 300, 300, mPaint);
//
//        RectF roundRect = new RectF(200, 400, 300, 500);
//        canvas.drawRoundRect(roundRect, 5, 5, mPaint);
//
//        canvas.drawOval(0, 300, 400, 500, mPaint);
//
//        canvas.drawCircle(500,500,100,mPaint);
//
//        canvas.drawArc(0, 400, 500, 900, 0, 90, false, mPaint);

//        canvas.translate( mWidth / 2, mHeight / 2);
//
//        //canvas.drawCircle(0, 0, 300, mPaint);
//        canvas.drawArc(-300, -300, 300, 300, 145, 250, false, mPaint);
//
//        canvas.save();
//        for (int i = 0 ; i <=360; i+=10) {
//            if (i <= 30 || i >= 150) {
//                canvas.drawLine(320, 0, 360, 0, mPaint);
//            }
//            canvas.rotate(10);
//        }
//        canvas.restore();
//
//        canvas.save();
//        canvas.skew(0,1);
//        canvas.drawRect(0, 300, 100, 400, mPaint);
//        canvas.restore();
//
//        canvas.save();
//        canvas.drawCircle(200, 600, 100, mPaint);
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
//
//        canvas.drawRect(0, 400, 200, 600, mPaint);
//        mPaint.setXfermode(null);

        canvas.drawARGB(255, 139, 197, 186);

        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        int layerId = canvas.saveLayer(0, 0, canvasWidth, canvasHeight, null, Canvas.ALL_SAVE_FLAG);
        int r = canvasWidth / 3;
        //正常绘制黄色的圆形
        mPaint.setColor(Color.YELLOW);
        canvas.drawCircle(r, r, r, mPaint);
        //使用CLEAR作为PorterDuffXfermode绘制蓝色的矩形
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(r, r, r * 2.7f, r * 2.7f, mPaint);
        //最后将画笔去除Xfermode
        mPaint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
    }
}
