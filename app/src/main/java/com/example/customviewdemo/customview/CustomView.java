package com.example.customviewdemo.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.example.customviewdemo.util.SizeConvertUtil;

public class CustomView extends View {

    private Context context;
    //创建画笔
    public Paint mPaint;

    private int viewParentWidth;

    /**
     * 设置线框的样式
     */
    private int height;

    //大边框的画笔宽度
    private int bigReftWidth;
    //白色线条画笔的宽度
    private int writeLineWidth;
    //每个颜色线条的宽度
    private int colorLineWidth;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e("TAG", "onLayout中获取的控件宽高 " + getWidth() + "   " + getHeight());
        this.viewParentWidth = getWidth();
        initData();
    }

    /**
     * dp和px的转换
     */
    private void initData() {
        //获取到的空间宽度
        height = SizeConvertUtil.dpTopx(context, 40);
        bigReftWidth = SizeConvertUtil.dpTopx(context, 3);
        writeLineWidth = SizeConvertUtil.dpTopx(context, 4);
        colorLineWidth = SizeConvertUtil.dpTopx(context, 6);
    }

    /**
     * 主要重写的方法
     *
     * @param canvas
     */
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();

        drawBottomColor(paint, canvas);

        drawTopColor(paint, canvas);

        drawWhiteLine(paint, canvas);
    }


    /**
     * 绘制底部颜色
     *
     * @param mPaint
     * @param canvas
     */
    private void drawBottomColor(Paint mPaint, Canvas canvas) {
        /**
         * STROKE 描边
         * FILL 填充
         * FILL_AND_STROKE 描边加填充
         */
        //设置画笔模式
        mPaint.setStyle(Paint.Style.FILL);
        //设置画笔宽度
        mPaint.setStrokeWidth(bigReftWidth);
        //画笔颜色
        mPaint.setColor(Color.BLACK);
        //绘制圆角矩形
        canvas.drawRoundRect(new RectF(getLeft(), getTop(), viewParentWidth, height), 0, 0, mPaint);
    }

    /**
     * 绘制上层颜色
     *
     * @param mPaint
     * @param canvas
     */
    private void drawTopColor(Paint mPaint, Canvas canvas) {
        mPaint = new Paint();

        /**
         * STROKE 描边
         * FILL 填充
         * FILL_AND_STROKE 描边加填充
         */
        //设置画笔模式
        mPaint.setStyle(Paint.Style.FILL);
        //设置画笔宽度
        mPaint.setStrokeWidth(bigReftWidth);

        //设置渐变形式
        LinearGradient lg = new LinearGradient(0, 0, viewParentWidth, height, Color.GRAY, Color.GREEN, Shader.TileMode.MIRROR);

        mPaint.setShader(lg);
        //绘制圆角矩形
        canvas.drawRoundRect(new RectF(getLeft(), getTop(), (viewParentWidth / 2), height), 0, 0, mPaint);
    }

    /**
     * 绘制小的白色线条
     *
     * @param paint
     * @param canvas
     */
    private void drawWhiteLine(Paint paint, Canvas canvas) {
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(writeLineWidth);
        paint.setStyle(Paint.Style.FILL);

        //计算绘制线条个数
        int linesNum = viewParentWidth % (writeLineWidth + colorLineWidth) == 0 ? (viewParentWidth / (writeLineWidth + colorLineWidth)) : (viewParentWidth / (writeLineWidth + colorLineWidth)) - 1;
        Log.e("TAG", "获取的个数 " + linesNum);

        int startX = getLeft();
        int startY = getTop();
        int endX = getLeft();
        int endY = height ;

        //循环绘制线条
        for (int i = 1; i <= linesNum+1; i++) {
            //绘制第i个线条
            startX = (colorLineWidth * i) + (writeLineWidth) * (i - 1) + getLeft();

            endX = startX;
            Log.e("TAG", "绘制的x位置坐标 I " + i + "   " + startX);
            Log.e("TAG", "绘制的colorLineWidth位置坐标 " + colorLineWidth);
            Log.e("TAG", "绘制的writeLineWidth位置坐标 " + writeLineWidth);

            canvas.drawLine(startX, startY, endX, endY, paint);
        }
    }
}
